package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import java.util.LinkedList;
import java.util.List;

@ey
public class eh {
    private static final Object mH;
    private static final String sZ;
    private static eh tb;
    private final C1107a ta;

    /* renamed from: com.google.android.gms.internal.eh.a */
    public class C1107a extends SQLiteOpenHelper {
        final /* synthetic */ eh tc;

        public C1107a(eh ehVar, Context context, String str) {
            this.tc = ehVar;
            super(context, str, null, 4);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(eh.sZ);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            gr.m4771U("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    static {
        sZ = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
        mH = new Object();
    }

    private eh(Context context) {
        this.ta = new C1107a(this, context, "google_inapp_purchase.db");
    }

    public static eh m4506j(Context context) {
        eh ehVar;
        synchronized (mH) {
            if (tb == null) {
                tb = new eh(context);
            }
            ehVar = tb;
        }
        return ehVar;
    }

    public ef m4507a(Cursor cursor) {
        return cursor == null ? null : new ef(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void m4508a(ef efVar) {
        if (efVar != null) {
            synchronized (mH) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                writableDatabase.delete("InAppPurchase", String.format("%s = %d", new Object[]{"purchase_id", Long.valueOf(efVar.sT)}), null);
            }
        }
    }

    public void m4509b(ef efVar) {
        if (efVar != null) {
            synchronized (mH) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("product_id", efVar.sV);
                contentValues.put("developer_payload", efVar.sU);
                contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
                efVar.sT = writableDatabase.insert("InAppPurchase", null, contentValues);
                if (((long) getRecordCount()) > 20000) {
                    cA();
                }
            }
        }
    }

    public void cA() {
        Cursor query;
        SQLiteException e;
        synchronized (mH) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                query = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            m4508a(m4507a(query));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            gr.m4773W("Error remove oldest record" + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                gr.m4773W("Error remove oldest record" + e.getMessage());
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th2 = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        }
    }

    public List<ef> m4510d(long j) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        synchronized (mH) {
            List<ef> linkedList = new LinkedList();
            if (j <= 0) {
                return linkedList;
            }
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return linkedList;
            }
            try {
                query = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", String.valueOf(j));
                try {
                    if (query.moveToFirst()) {
                        do {
                            linkedList.add(m4507a(query));
                        } while (query.moveToNext());
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        gr.m4773W("Error extracing purchase info: " + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
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
                gr.m4773W("Error extracing purchase info: " + e.getMessage());
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
            return linkedList;
        }
    }

    public int getRecordCount() {
        Cursor cursor = null;
        int i = 0;
        synchronized (mH) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
            } else {
                try {
                    cursor = writableDatabase.rawQuery("select count(*) from InAppPurchase", null);
                    if (cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (SQLiteException e) {
                    gr.m4773W("Error getting record count" + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.ta.getWritableDatabase();
        } catch (SQLiteException e) {
            gr.m4773W("Error opening writable conversion tracking database");
            return null;
        }
    }
}
