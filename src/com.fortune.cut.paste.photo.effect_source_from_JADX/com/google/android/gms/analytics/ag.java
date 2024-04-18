package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ag implements C0383d {
    private static final String BS;
    private final C0382a BT;
    private volatile C0396r BU;
    private final String BV;
    private af BW;
    private long BX;
    private final int BY;
    private final Context mContext;
    private ld wb;
    private C0399o ys;
    private volatile boolean yt;
    private final C0392e zc;

    /* renamed from: com.google.android.gms.analytics.ag.a */
    class C0382a extends SQLiteOpenHelper {
        private boolean BZ;
        private long Ca;
        final /* synthetic */ ag Cb;

        C0382a(ag agVar, Context context, String str) {
            this.Cb = agVar;
            super(context, str, null, 1);
            this.Ca = 0;
        }

        private void m1491a(SQLiteDatabase sQLiteDatabase) {
            Object obj = null;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                    if (!hashSet.remove("hit_app_id")) {
                        obj = 1;
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (obj != null) {
                        sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
            } finally {
                rawQuery.close();
            }
        }

        private boolean m1492a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        ae.m1488W("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                ae.m1488W("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.BZ || this.Ca + 3600000 <= this.Cb.wb.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.BZ = true;
                this.Ca = this.Cb.wb.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.Cb.mContext.getDatabasePath(this.Cb.BV).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.BZ = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            C0406t.ag(sQLiteDatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m1492a("hits2", sQLiteDatabase)) {
                m1491a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(ag.BS);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        BS = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    }

    ag(C0392e c0392e, Context context, C0399o c0399o) {
        this(c0392e, context, "google_analytics_v4.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS, c0399o);
    }

    ag(C0392e c0392e, Context context, String str, int i, C0399o c0399o) {
        this.yt = true;
        this.mContext = context.getApplicationContext();
        this.ys = c0399o;
        this.BV = str;
        this.zc = c0392e;
        this.wb = lf.m5325if();
        this.BT = new C0382a(this, this.mContext, this.BV);
        this.BU = new C0397h(new DefaultHttpClient(), this.mContext, this.ys);
        this.BX = 0;
        this.BY = i;
    }

    static String m1495A(Map<String, String> map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(ac.encode((String) entry.getKey()) + "=" + ac.encode((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    private void m1497a(Map<String, String> map, long j, String str) {
        SQLiteDatabase al = al("Error opening database for putHit");
        if (al != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", m1495A(map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    parseLong = Long.parseLong((String) map.get("AppUID"));
                } catch (NumberFormatException e) {
                }
                contentValues.put("hit_app_id", Long.valueOf(parseLong));
                if (str == null) {
                    str = "http://www.google-analytics.com/collect";
                }
                if (str.length() != 0) {
                    ae.m1488W("Empty path: not sending hit");
                }
                contentValues.put("hit_url", str);
                try {
                    al.insert("hits2", null, contentValues);
                    this.zc.m1536B(false);
                    return;
                } catch (SQLiteException e2) {
                    ae.m1488W("Error storing hit");
                    return;
                }
            }
            parseLong = 0;
            contentValues.put("hit_app_id", Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() != 0) {
                contentValues.put("hit_url", str);
                al.insert("hits2", null, contentValues);
                this.zc.m1536B(false);
                return;
            }
            ae.m1488W("Empty path: not sending hit");
        }
    }

    private void m1498a(Map<String, String> map, Collection<ha> collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (ha haVar : collection) {
                if ("appendVersion".equals(haVar.getId())) {
                    map.put(substring, haVar.getValue());
                    return;
                }
            }
        }
    }

    private SQLiteDatabase al(String str) {
        try {
            return this.BT.getWritableDatabase();
        } catch (SQLiteException e) {
            ae.m1488W(str);
            return null;
        }
    }

    private void fh() {
        int fj = (fj() - this.BY) + 1;
        if (fj > 0) {
            List G = m1501G(fj);
            ae.m1487V("Store full, deleting " + G.size() + " hits to make room.");
            m1505b((String[]) G.toArray(new String[0]));
        }
    }

    List<String> m1501G(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            ae.m1488W("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase al = al("Error opening database for peekHitIds.");
        if (al == null) {
            return arrayList;
        }
        try {
            query = al.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    ae.m1488W("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            ae.m1488W("Error in peekHits fetching hitIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.ab> m1502H(int r16) {
        /*
        r15 = this;
        r10 = new java.util.ArrayList;
        r10.<init>();
        r1 = "Error opening database for peekHits";
        r1 = r15.al(r1);
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        r1 = r10;
    L_0x000e:
        return r1;
    L_0x000f:
        r11 = 0;
        r2 = "hits2";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f5 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f5 }
        r4 = 1;
        r5 = "hit_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f5 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f5 }
        r12 = 0;
        r13 = "hit_id";
        r9[r12] = r13;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f5 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f5 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f5 }
        r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f5 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0174, all -> 0x016e }
        r11.<init>();	 Catch:{ SQLiteException -> 0x0174, all -> 0x016e }
        r2 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x017a, all -> 0x016e }
        if (r2 == 0) goto L_0x005f;
    L_0x0044:
        r2 = new com.google.android.gms.analytics.ab;	 Catch:{ SQLiteException -> 0x017a, all -> 0x016e }
        r3 = 0;
        r4 = 0;
        r4 = r12.getLong(r4);	 Catch:{ SQLiteException -> 0x017a, all -> 0x016e }
        r6 = 1;
        r6 = r12.getLong(r6);	 Catch:{ SQLiteException -> 0x017a, all -> 0x016e }
        r8 = "";
        r2.<init>(r3, r4, r6, r8);	 Catch:{ SQLiteException -> 0x017a, all -> 0x016e }
        r11.add(r2);	 Catch:{ SQLiteException -> 0x017a, all -> 0x016e }
        r2 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x017a, all -> 0x016e }
        if (r2 != 0) goto L_0x0044;
    L_0x005f:
        if (r12 == 0) goto L_0x0064;
    L_0x0061:
        r12.close();
    L_0x0064:
        r10 = 0;
        r2 = "hits2";
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x016c }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x016c }
        r4 = 1;
        r5 = "hit_string";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x016c }
        r4 = 2;
        r5 = "hit_url";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x016c }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x016c }
        r13 = 0;
        r14 = "hit_id";
        r9[r13] = r14;	 Catch:{ SQLiteException -> 0x016c }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x016c }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x016c }
        r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x016c }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        if (r1 == 0) goto L_0x00cc;
    L_0x0099:
        r3 = r10;
    L_0x009a:
        r0 = r2;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1 = r0;
        r1 = r1.getWindow();	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1 = r1.getNumRows();	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        if (r1 <= 0) goto L_0x00fc;
    L_0x00a8:
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1 = (com.google.android.gms.analytics.ab) r1;	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r4 = 1;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1.aj(r4);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1 = (com.google.android.gms.analytics.ab) r1;	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r4 = 2;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1.ak(r4);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
    L_0x00c4:
        r1 = r3 + 1;
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        if (r3 != 0) goto L_0x0180;
    L_0x00cc:
        if (r2 == 0) goto L_0x00d1;
    L_0x00ce:
        r2.close();
    L_0x00d1:
        r1 = r11;
        goto L_0x000e;
    L_0x00d4:
        r1 = move-exception;
        r2 = r1;
        r3 = r11;
        r1 = r10;
    L_0x00d8:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0171 }
        r5 = "Error in peekHits fetching hitIds: ";
        r4.<init>(r5);	 Catch:{ all -> 0x0171 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0171 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0171 }
        r2 = r2.toString();	 Catch:{ all -> 0x0171 }
        com.google.android.gms.analytics.ae.m1488W(r2);	 Catch:{ all -> 0x0171 }
        if (r3 == 0) goto L_0x000e;
    L_0x00f0:
        r3.close();
        goto L_0x000e;
    L_0x00f5:
        r1 = move-exception;
    L_0x00f6:
        if (r11 == 0) goto L_0x00fb;
    L_0x00f8:
        r11.close();
    L_0x00fb:
        throw r1;
    L_0x00fc:
        r4 = "HitString for hitId %d too large.  Hit will be deleted.";
        r1 = 1;
        r5 = new java.lang.Object[r1];	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r6 = 0;
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1 = (com.google.android.gms.analytics.ab) r1;	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r7 = r1.fb();	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r5[r6] = r1;	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        r1 = java.lang.String.format(r4, r5);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        com.google.android.gms.analytics.ae.m1488W(r1);	 Catch:{ SQLiteException -> 0x011a, all -> 0x0169 }
        goto L_0x00c4;
    L_0x011a:
        r1 = move-exception;
        r12 = r2;
    L_0x011c:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015a }
        r3 = "Error in peekHits fetching hitString: ";
        r2.<init>(r3);	 Catch:{ all -> 0x015a }
        r1 = r1.getMessage();	 Catch:{ all -> 0x015a }
        r1 = r2.append(r1);	 Catch:{ all -> 0x015a }
        r1 = r1.toString();	 Catch:{ all -> 0x015a }
        com.google.android.gms.analytics.ae.m1488W(r1);	 Catch:{ all -> 0x015a }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x015a }
        r2.<init>();	 Catch:{ all -> 0x015a }
        r1 = 0;
        r4 = r11.iterator();	 Catch:{ all -> 0x015a }
        r3 = r1;
    L_0x013d:
        r1 = r4.hasNext();	 Catch:{ all -> 0x015a }
        if (r1 == 0) goto L_0x0161;
    L_0x0143:
        r1 = r4.next();	 Catch:{ all -> 0x015a }
        r1 = (com.google.android.gms.analytics.ab) r1;	 Catch:{ all -> 0x015a }
        r5 = r1.fa();	 Catch:{ all -> 0x015a }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x015a }
        if (r5 == 0) goto L_0x0156;
    L_0x0153:
        if (r3 != 0) goto L_0x0161;
    L_0x0155:
        r3 = 1;
    L_0x0156:
        r2.add(r1);	 Catch:{ all -> 0x015a }
        goto L_0x013d;
    L_0x015a:
        r1 = move-exception;
    L_0x015b:
        if (r12 == 0) goto L_0x0160;
    L_0x015d:
        r12.close();
    L_0x0160:
        throw r1;
    L_0x0161:
        if (r12 == 0) goto L_0x0166;
    L_0x0163:
        r12.close();
    L_0x0166:
        r1 = r2;
        goto L_0x000e;
    L_0x0169:
        r1 = move-exception;
        r12 = r2;
        goto L_0x015b;
    L_0x016c:
        r1 = move-exception;
        goto L_0x011c;
    L_0x016e:
        r1 = move-exception;
        r11 = r12;
        goto L_0x00f6;
    L_0x0171:
        r1 = move-exception;
        r11 = r3;
        goto L_0x00f6;
    L_0x0174:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r10;
        goto L_0x00d8;
    L_0x017a:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r11;
        goto L_0x00d8;
    L_0x0180:
        r3 = r1;
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.ag.H(int):java.util.List<com.google.android.gms.analytics.ab>");
    }

    public void m1503a(Map<String, String> map, long j, String str, Collection<ha> collection) {
        fi();
        fh();
        m1498a(map, collection);
        m1497a(map, j, str);
    }

    @Deprecated
    void m1504b(Collection<ab> collection) {
        if (collection == null || collection.isEmpty()) {
            ae.m1488W("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (ab fb : collection) {
            int i2 = i + 1;
            strArr[i] = String.valueOf(fb.fb());
            i = i2;
        }
        m1505b(strArr);
    }

    void m1505b(String[] strArr) {
        boolean z = true;
        if (strArr == null || strArr.length == 0) {
            ae.m1488W("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase al = al("Error opening database for deleteHits.");
        if (al != null) {
            try {
                al.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                C0392e c0392e = this.zc;
                if (fj() != 0) {
                    z = false;
                }
                c0392e.m1536B(z);
            } catch (SQLiteException e) {
                ae.m1488W("Error deleting hits " + TextUtils.join(",", strArr));
            }
        }
    }

    public C0396r dV() {
        return this.BU;
    }

    public void dispatch() {
        boolean z = true;
        ae.m1487V("Dispatch running...");
        if (this.BU.ea()) {
            List H = m1502H(20);
            if (H.isEmpty()) {
                ae.m1487V("...nothing to dispatch");
                this.zc.m1536B(true);
                return;
            }
            if (this.BW == null) {
                this.BW = new af("_t=dispatch&_v=ma4.0.4", false);
            }
            if (fj() > H.size()) {
                z = false;
            }
            int a = this.BU.m1539a(H, this.BW, z);
            ae.m1487V("sent " + a + " of " + H.size() + " hits");
            m1504b(H.subList(0, Math.min(a, H.size())));
            if (a != H.size() || fj() <= 0) {
                this.BW = null;
            } else {
                GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            }
        }
    }

    int fi() {
        boolean z = true;
        long currentTimeMillis = this.wb.currentTimeMillis();
        if (currentTimeMillis <= this.BX + 86400000) {
            return 0;
        }
        this.BX = currentTimeMillis;
        SQLiteDatabase al = al("Error opening database for deleteStaleHits.");
        if (al == null) {
            return 0;
        }
        int delete = al.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.wb.currentTimeMillis() - 2592000000L)});
        C0392e c0392e = this.zc;
        if (fj() != 0) {
            z = false;
        }
        c0392e.m1536B(z);
        return delete;
    }

    int fj() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = al("Error opening database for getNumStoredHits.");
        if (al != null) {
            try {
                cursor = al.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                ae.m1488W("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public void m1506l(long j) {
        boolean z = true;
        SQLiteDatabase al = al("Error opening database for clearHits");
        if (al != null) {
            if (j == 0) {
                al.delete("hits2", null, null);
            } else {
                al.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            C0392e c0392e = this.zc;
            if (fj() != 0) {
                z = false;
            }
            c0392e.m1536B(z);
        }
    }

    public void setDryRun(boolean z) {
        this.yt = z;
        if (this.BU != null) {
            this.BU.setDryRun(z);
        }
    }
}
