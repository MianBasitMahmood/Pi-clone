package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.tagmanager.db.C1767a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class cb implements at {
    private static final String BS;
    private final String BV;
    private long BX;
    private final int BY;
    private final C1769b asf;
    private volatile ab asg;
    private final au ash;
    private final Context mContext;
    private ld wb;

    /* renamed from: com.google.android.gms.tagmanager.cb.a */
    class C1768a implements C1767a {
        final /* synthetic */ cb asi;

        C1768a(cb cbVar) {
            this.asi = cbVar;
        }

        public void m6490a(ap apVar) {
            this.asi.m6502y(apVar.fb());
        }

        public void m6491b(ap apVar) {
            this.asi.m6502y(apVar.fb());
            bh.m6460V("Permanent failure dispatching hitId: " + apVar.fb());
        }

        public void m6492c(ap apVar) {
            long pK = apVar.pK();
            if (pK == 0) {
                this.asi.m6500c(apVar.fb(), this.asi.wb.currentTimeMillis());
            } else if (pK + 14400000 < this.asi.wb.currentTimeMillis()) {
                this.asi.m6502y(apVar.fb());
                bh.m6460V("Giving up on failed hitId: " + apVar.fb());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cb.b */
    class C1769b extends SQLiteOpenHelper {
        private boolean BZ;
        private long Ca;
        final /* synthetic */ cb asi;

        C1769b(cb cbVar, Context context, String str) {
            this.asi = cbVar;
            super(context, str, null, 1);
            this.Ca = 0;
        }

        private void m6493a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m6494a(String str, SQLiteDatabase sQLiteDatabase) {
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
                        bh.m6461W("Error querying for table " + str);
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
                bh.m6461W("Error querying for table " + str);
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
            if (!this.BZ || this.Ca + 3600000 <= this.asi.wb.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.BZ = true;
                this.Ca = this.asi.wb.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.asi.mContext.getDatabasePath(this.asi.BV).delete();
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
            ak.ag(sQLiteDatabase.getPath());
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
            if (m6494a("gtm_hits", sQLiteDatabase)) {
                m6493a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(cb.BS);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        BS = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    }

    cb(au auVar, Context context) {
        this(auVar, context, "gtm_urls.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS);
    }

    cb(au auVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.BV = str;
        this.ash = auVar;
        this.wb = lf.m5325if();
        this.asf = new C1769b(this, this.mContext, this.BV);
        this.asg = new db(new DefaultHttpClient(), this.mContext, new C1768a(this));
        this.BX = 0;
        this.BY = i;
    }

    private SQLiteDatabase al(String str) {
        try {
            return this.asf.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m6461W(str);
            return null;
        }
    }

    private void m6500c(long j, long j2) {
        SQLiteDatabase al = al("Error opening database for getNumStoredHits.");
        if (al != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                al.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                bh.m6461W("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                m6502y(j);
            }
        }
    }

    private void fh() {
        int fj = (fj() - this.BY) + 1;
        if (fj > 0) {
            List G = m6503G(fj);
            bh.m6460V("Store full, deleting " + G.size() + " hits to make room.");
            m6505b((String[]) G.toArray(new String[0]));
        }
    }

    private void m6501g(long j, String str) {
        SQLiteDatabase al = al("Error opening database for putHit");
        if (al != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                al.insert("gtm_hits", null, contentValues);
                this.ash.m6432B(false);
            } catch (SQLiteException e) {
                bh.m6461W("Error storing hit");
            }
        }
    }

    private void m6502y(long j) {
        m6505b(new String[]{String.valueOf(j)});
    }

    List<String> m6503G(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m6461W("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase al = al("Error opening database for peekHitIds.");
        if (al == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = al.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
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
                    bh.m6461W("Error in peekHits fetching hitIds: " + e.getMessage());
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
            bh.m6461W("Error in peekHits fetching hitIds: " + e.getMessage());
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
    public java.util.List<com.google.android.gms.tagmanager.ap> m6504H(int r16) {
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
        r2 = "gtm_hits";
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r4 = 1;
        r5 = "hit_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r4 = 2;
        r5 = "hit_first_send_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r12 = 0;
        r13 = "hit_id";
        r9[r12] = r13;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00e9 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0168, all -> 0x0162 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x0168, all -> 0x0162 }
        r2 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x016e, all -> 0x0162 }
        if (r2 == 0) goto L_0x0066;
    L_0x0049:
        r2 = new com.google.android.gms.tagmanager.ap;	 Catch:{ SQLiteException -> 0x016e, all -> 0x0162 }
        r3 = 0;
        r3 = r12.getLong(r3);	 Catch:{ SQLiteException -> 0x016e, all -> 0x0162 }
        r5 = 1;
        r5 = r12.getLong(r5);	 Catch:{ SQLiteException -> 0x016e, all -> 0x0162 }
        r7 = 2;
        r7 = r12.getLong(r7);	 Catch:{ SQLiteException -> 0x016e, all -> 0x0162 }
        r2.<init>(r3, r5, r7);	 Catch:{ SQLiteException -> 0x016e, all -> 0x0162 }
        r11.add(r2);	 Catch:{ SQLiteException -> 0x016e, all -> 0x0162 }
        r2 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x016e, all -> 0x0162 }
        if (r2 != 0) goto L_0x0049;
    L_0x0066:
        if (r12 == 0) goto L_0x006b;
    L_0x0068:
        r12.close();
    L_0x006b:
        r10 = 0;
        r2 = "gtm_hits";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0160 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0160 }
        r4 = 1;
        r5 = "hit_url";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0160 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x0160 }
        r13 = 0;
        r14 = "hit_id";
        r9[r13] = r14;	 Catch:{ SQLiteException -> 0x0160 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x0160 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x0160 }
        r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x0160 }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        if (r1 == 0) goto L_0x00c0;
    L_0x009b:
        r3 = r10;
    L_0x009c:
        r0 = r2;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r1 = r0;
        r1 = r1.getWindow();	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r1 = r1.getNumRows();	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        if (r1 <= 0) goto L_0x00f0;
    L_0x00aa:
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r4 = 1;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r1.ak(r4);	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
    L_0x00b8:
        r1 = r3 + 1;
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        if (r3 != 0) goto L_0x0174;
    L_0x00c0:
        if (r2 == 0) goto L_0x00c5;
    L_0x00c2:
        r2.close();
    L_0x00c5:
        r1 = r11;
        goto L_0x000e;
    L_0x00c8:
        r1 = move-exception;
        r2 = r1;
        r3 = r11;
        r1 = r10;
    L_0x00cc:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0165 }
        r5 = "Error in peekHits fetching hitIds: ";
        r4.<init>(r5);	 Catch:{ all -> 0x0165 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0165 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0165 }
        r2 = r2.toString();	 Catch:{ all -> 0x0165 }
        com.google.android.gms.tagmanager.bh.m6461W(r2);	 Catch:{ all -> 0x0165 }
        if (r3 == 0) goto L_0x000e;
    L_0x00e4:
        r3.close();
        goto L_0x000e;
    L_0x00e9:
        r1 = move-exception;
    L_0x00ea:
        if (r11 == 0) goto L_0x00ef;
    L_0x00ec:
        r11.close();
    L_0x00ef:
        throw r1;
    L_0x00f0:
        r4 = "HitString for hitId %d too large.  Hit will be deleted.";
        r1 = 1;
        r5 = new java.lang.Object[r1];	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r6 = 0;
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r7 = r1.fb();	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r1 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r5[r6] = r1;	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        r1 = java.lang.String.format(r4, r5);	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        com.google.android.gms.tagmanager.bh.m6461W(r1);	 Catch:{ SQLiteException -> 0x010e, all -> 0x015d }
        goto L_0x00b8;
    L_0x010e:
        r1 = move-exception;
        r12 = r2;
    L_0x0110:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014e }
        r3 = "Error in peekHits fetching hit url: ";
        r2.<init>(r3);	 Catch:{ all -> 0x014e }
        r1 = r1.getMessage();	 Catch:{ all -> 0x014e }
        r1 = r2.append(r1);	 Catch:{ all -> 0x014e }
        r1 = r1.toString();	 Catch:{ all -> 0x014e }
        com.google.android.gms.tagmanager.bh.m6461W(r1);	 Catch:{ all -> 0x014e }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x014e }
        r2.<init>();	 Catch:{ all -> 0x014e }
        r1 = 0;
        r4 = r11.iterator();	 Catch:{ all -> 0x014e }
        r3 = r1;
    L_0x0131:
        r1 = r4.hasNext();	 Catch:{ all -> 0x014e }
        if (r1 == 0) goto L_0x0155;
    L_0x0137:
        r1 = r4.next();	 Catch:{ all -> 0x014e }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ all -> 0x014e }
        r5 = r1.pL();	 Catch:{ all -> 0x014e }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x014e }
        if (r5 == 0) goto L_0x014a;
    L_0x0147:
        if (r3 != 0) goto L_0x0155;
    L_0x0149:
        r3 = 1;
    L_0x014a:
        r2.add(r1);	 Catch:{ all -> 0x014e }
        goto L_0x0131;
    L_0x014e:
        r1 = move-exception;
    L_0x014f:
        if (r12 == 0) goto L_0x0154;
    L_0x0151:
        r12.close();
    L_0x0154:
        throw r1;
    L_0x0155:
        if (r12 == 0) goto L_0x015a;
    L_0x0157:
        r12.close();
    L_0x015a:
        r1 = r2;
        goto L_0x000e;
    L_0x015d:
        r1 = move-exception;
        r12 = r2;
        goto L_0x014f;
    L_0x0160:
        r1 = move-exception;
        goto L_0x0110;
    L_0x0162:
        r1 = move-exception;
        r11 = r12;
        goto L_0x00ea;
    L_0x0165:
        r1 = move-exception;
        r11 = r3;
        goto L_0x00ea;
    L_0x0168:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r10;
        goto L_0x00cc;
    L_0x016e:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r11;
        goto L_0x00cc;
    L_0x0174:
        r3 = r1;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cb.H(int):java.util.List<com.google.android.gms.tagmanager.ap>");
    }

    void m6505b(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase al = al("Error opening database for deleteHits.");
            if (al != null) {
                try {
                    al.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    au auVar = this.ash;
                    if (fj() != 0) {
                        z = false;
                    }
                    auVar.m6432B(z);
                } catch (SQLiteException e) {
                    bh.m6461W("Error deleting hits");
                }
            }
        }
    }

    public void dispatch() {
        bh.m6460V("GTM Dispatch running...");
        if (this.asg.ea()) {
            List H = m6504H(40);
            if (H.isEmpty()) {
                bh.m6460V("...nothing to dispatch");
                this.ash.m6432B(true);
                return;
            }
            this.asg.m6402k(H);
            if (pY() > 0) {
                cy.qN().dispatch();
            }
        }
    }

    public void m6506f(long j, String str) {
        fi();
        fh();
        m6501g(j, str);
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
        int delete = al.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.wb.currentTimeMillis() - 2592000000L)});
        au auVar = this.ash;
        if (fj() != 0) {
            z = false;
        }
        auVar.m6432B(z);
        return delete;
    }

    int fj() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = al("Error opening database for getNumStoredHits.");
        if (al != null) {
            try {
                cursor = al.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m6461W("Error getting numStoredHits");
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

    int pY() {
        int count;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        SQLiteDatabase al = al("Error opening database for getNumStoredHits.");
        if (al == null) {
            return 0;
        }
        try {
            Cursor query = al.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = query.getCount();
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e) {
                cursor = query;
                try {
                    bh.m6461W("Error getting num untried hits");
                    if (cursor == null) {
                        count = 0;
                    } else {
                        cursor.close();
                        count = 0;
                    }
                    return count;
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
            bh.m6461W("Error getting num untried hits");
            if (cursor == null) {
                cursor.close();
                count = 0;
            } else {
                count = 0;
            }
            return count;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return count;
    }
}
