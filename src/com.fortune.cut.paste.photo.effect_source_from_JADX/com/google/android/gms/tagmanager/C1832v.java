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
import com.google.android.gms.tagmanager.DataLayer.C1741c;
import com.google.android.gms.tagmanager.DataLayer.C1741c.C1743a;
import com.google.android.gms.tagmanager.DataLayer.C1745a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.v */
class C1832v implements C1741c {
    private static final String ara;
    private final Executor arb;
    private C1830a arc;
    private int ard;
    private final Context mContext;
    private ld wb;

    /* renamed from: com.google.android.gms.tagmanager.v.1 */
    class C18271 implements Runnable {
        final /* synthetic */ List are;
        final /* synthetic */ long arf;
        final /* synthetic */ C1832v arg;

        C18271(C1832v c1832v, List list, long j) {
            this.arg = c1832v;
            this.are = list;
            this.arf = j;
        }

        public void run() {
            this.arg.m6683b(this.are, this.arf);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.2 */
    class C18282 implements Runnable {
        final /* synthetic */ C1832v arg;
        final /* synthetic */ C1743a arh;

        C18282(C1832v c1832v, C1743a c1743a) {
            this.arg = c1832v;
            this.arh = c1743a;
        }

        public void run() {
            this.arh.m6370h(this.arg.pz());
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.3 */
    class C18293 implements Runnable {
        final /* synthetic */ C1832v arg;
        final /* synthetic */ String ari;

        C18293(C1832v c1832v, String str) {
            this.arg = c1832v;
            this.ari = str;
        }

        public void run() {
            this.arg.cA(this.ari);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.a */
    class C1830a extends SQLiteOpenHelper {
        final /* synthetic */ C1832v arg;

        C1830a(C1832v c1832v, Context context, String str) {
            this.arg = c1832v;
            super(context, str, null, 1);
        }

        private void m6677a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m6678a(String str, SQLiteDatabase sQLiteDatabase) {
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
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.arg.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
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
            if (m6678a("datalayer", sQLiteDatabase)) {
                m6677a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(C1832v.ara);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.b */
    private static class C1831b {
        final String KP;
        final byte[] arj;

        C1831b(String str, byte[] bArr) {
            this.KP = str;
            this.arj = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.KP + " serialized hash = " + Arrays.hashCode(this.arj);
        }
    }

    static {
        ara = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    }

    public C1832v(Context context) {
        this(context, lf.m5325if(), "google_tagmanager.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS, Executors.newSingleThreadExecutor());
    }

    C1832v(Context context, ld ldVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.wb = ldVar;
        this.ard = i;
        this.arb = executor;
        this.arc = new C1830a(this, this.mContext, str);
    }

    private SQLiteDatabase al(String str) {
        try {
            return this.arc.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m6461W(str);
            return null;
        }
    }

    private synchronized void m6683b(List<C1831b> list, long j) {
        try {
            long currentTimeMillis = this.wb.currentTimeMillis();
            m6690x(currentTimeMillis);
            fI(list.size());
            m6684c(list, currentTimeMillis + j);
            pC();
        } catch (Throwable th) {
            pC();
        }
    }

    private void m6684c(List<C1831b> list, long j) {
        SQLiteDatabase al = al("Error opening database for writeEntryToDatabase.");
        if (al != null) {
            for (C1831b c1831b : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", c1831b.KP);
                contentValues.put("value", c1831b.arj);
                al.insert("datalayer", null, contentValues);
            }
        }
    }

    private void cA(String str) {
        SQLiteDatabase al = al("Error opening database for clearKeysWithPrefix.");
        if (al != null) {
            try {
                bh.m6460V("Cleared " + al.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.m6461W("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                pC();
            }
        }
    }

    private void fI(int i) {
        int pB = (pB() - this.ard) + i;
        if (pB > 0) {
            List fJ = fJ(pB);
            bh.m6459U("DataLayer store full, deleting " + fJ.size() + " entries to make room.");
            m6685h((String[]) fJ.toArray(new String[0]));
        }
    }

    private List<String> fJ(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m6461W("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase al = al("Error opening database for peekEntryIds.");
        if (al == null) {
            return arrayList;
        }
        try {
            query = al.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
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
                    bh.m6461W("Error in peekEntries fetching entryIds: " + e.getMessage());
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
            bh.m6461W("Error in peekEntries fetching entryIds: " + e.getMessage());
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

    private void m6685h(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase al = al("Error opening database for deleteEntries.");
            if (al != null) {
                try {
                    al.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.m6461W("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private List<C1745a> m6686i(List<C1831b> list) {
        List<C1745a> arrayList = new ArrayList();
        for (C1831b c1831b : list) {
            arrayList.add(new C1745a(c1831b.KP, m6687j(c1831b.arj)));
        }
        return arrayList;
    }

    private Object m6687j(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private List<C1831b> m6688j(List<C1745a> list) {
        List<C1831b> arrayList = new ArrayList();
        for (C1745a c1745a : list) {
            arrayList.add(new C1831b(c1745a.KP, m6689m(c1745a.wF)));
        }
        return arrayList;
    }

    private byte[] m6689m(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List<C1831b> pA() {
        SQLiteDatabase al = al("Error opening database for loadSerialized.");
        List<C1831b> arrayList = new ArrayList();
        if (al == null) {
            return arrayList;
        }
        Cursor query = al.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C1831b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int pB() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = al("Error opening database for getNumStoredEntries.");
        if (al != null) {
            try {
                cursor = al.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m6461W("Error getting numStoredEntries");
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

    private void pC() {
        try {
            this.arc.close();
        } catch (SQLiteException e) {
        }
    }

    private List<C1745a> pz() {
        try {
            m6690x(this.wb.currentTimeMillis());
            List<C1745a> i = m6686i(pA());
            return i;
        } finally {
            pC();
        }
    }

    private void m6690x(long j) {
        SQLiteDatabase al = al("Error opening database for deleteOlderThan.");
        if (al != null) {
            try {
                bh.m6460V("Deleted " + al.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.m6461W("Error deleting old entries.");
            }
        }
    }

    public void m6691a(C1743a c1743a) {
        this.arb.execute(new C18282(this, c1743a));
    }

    public void m6692a(List<C1745a> list, long j) {
        this.arb.execute(new C18271(this, m6688j((List) list), j));
    }

    public void cz(String str) {
        this.arb.execute(new C18293(this, str));
    }
}
