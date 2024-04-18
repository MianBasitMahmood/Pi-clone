package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final C0526f CREATOR;
    private static final C0519a Ll;
    private final int CK;
    private final int Iv;
    private final String[] Ld;
    Bundle Le;
    private final CursorWindow[] Lf;
    private final Bundle Lg;
    int[] Lh;
    int Li;
    private Object Lj;
    private boolean Lk;
    boolean mClosed;

    /* renamed from: com.google.android.gms.common.data.DataHolder.a */
    public static class C0519a {
        private final String[] Ld;
        private final ArrayList<HashMap<String, Object>> Lm;
        private final String Ln;
        private final HashMap<Object, Integer> Lo;
        private boolean Lp;
        private String Lq;

        private C0519a(String[] strArr, String str) {
            this.Ld = (String[]) jx.m5223i(strArr);
            this.Lm = new ArrayList();
            this.Ln = str;
            this.Lo = new HashMap();
            this.Lp = false;
            this.Lq = null;
        }
    }

    /* renamed from: com.google.android.gms.common.data.DataHolder.1 */
    static class C05201 extends C0519a {
        C05201(String[] strArr, String str) {
            super(str, null);
        }
    }

    /* renamed from: com.google.android.gms.common.data.DataHolder.b */
    public static class C0521b extends RuntimeException {
        public C0521b(String str) {
            super(str);
        }
    }

    static {
        CREATOR = new C0526f();
        Ll = new C05201(new String[0], null);
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.Lk = true;
        this.CK = i;
        this.Ld = strArr;
        this.Lf = cursorWindowArr;
        this.Iv = i2;
        this.Lg = bundle;
    }

    private DataHolder(C0519a c0519a, int i, Bundle bundle) {
        this(c0519a.Ld, m1860a(c0519a, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.Lk = true;
        this.CK = 1;
        this.Ld = (String[]) jx.m5223i(strArr);
        this.Lf = (CursorWindow[]) jx.m5223i(cursorWindowArr);
        this.Iv = i;
        this.Lg = bundle;
        gX();
    }

    public static DataHolder m1859a(int i, Bundle bundle) {
        return new DataHolder(Ll, i, bundle);
    }

    private static CursorWindow[] m1860a(C0519a c0519a, int i) {
        int size;
        int i2 = 0;
        if (c0519a.Ld.length == 0) {
            return new CursorWindow[0];
        }
        List b = (i < 0 || i >= c0519a.Lm.size()) ? c0519a.Lm : c0519a.Lm.subList(0, i);
        int size2 = b.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(c0519a.Ld.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            if (!cursorWindow.allocRow()) {
                Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                cursorWindow = new CursorWindow(false);
                cursorWindow.setStartPosition(i3);
                cursorWindow.setNumColumns(c0519a.Ld.length);
                arrayList.add(cursorWindow);
                if (!cursorWindow.allocRow()) {
                    Log.e("DataHolder", "Unable to allocate row to hold data.");
                    arrayList.remove(cursorWindow);
                    return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                }
            }
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                Map map = (Map) b.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < c0519a.Ld.length && z; i7++) {
                    String str = c0519a.Ld[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new C0521b("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(c0519a.Ld.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                size = arrayList.size();
                while (i2 < size) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder av(int i) {
        return m1859a(i, null);
    }

    private void m1861g(String str, int i) {
        if (this.Le == null || !this.Le.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.Li) {
            throw new CursorIndexOutOfBoundsException(i, this.Li);
        }
    }

    public final long m1862a(String str, int i, int i2) {
        m1861g(str, i);
        return this.Lf[i2].getLong(i, this.Le.getInt(str));
    }

    public final void m1863a(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m1861g(str, i);
        this.Lf[i2].copyStringToBuffer(i, this.Le.getInt(str), charArrayBuffer);
    }

    public final boolean aQ(String str) {
        return this.Le.containsKey(str);
    }

    public final int au(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.Li;
        jx.m5215K(z);
        while (i2 < this.Lh.length) {
            if (i < this.Lh[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.Lh.length ? i2 - 1 : i2;
    }

    public final int m1864b(String str, int i, int i2) {
        m1861g(str, i);
        return this.Lf[i2].getInt(i, this.Le.getInt(str));
    }

    public final String m1865c(String str, int i, int i2) {
        m1861g(str, i);
        return this.Lf[i2].getString(i, this.Le.getInt(str));
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.Lf) {
                    close.close();
                }
            }
        }
    }

    public final boolean m1866d(String str, int i, int i2) {
        m1861g(str, i);
        return Long.valueOf(this.Lf[i2].getLong(i, this.Le.getInt(str))).longValue() == 1;
    }

    public final int describeContents() {
        return 0;
    }

    public final float m1867e(String str, int i, int i2) {
        m1861g(str, i);
        return this.Lf[i2].getFloat(i, this.Le.getInt(str));
    }

    public final void m1868e(Object obj) {
        this.Lj = obj;
    }

    public final byte[] m1869f(String str, int i, int i2) {
        m1861g(str, i);
        return this.Lf[i2].getBlob(i, this.Le.getInt(str));
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.Lk && this.Lf.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.Lj == null ? "internal object: " + toString() : this.Lj.toString()) + ")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final Uri m1870g(String str, int i, int i2) {
        String c = m1865c(str, i, i2);
        return c == null ? null : Uri.parse(c);
    }

    public final Bundle gV() {
        return this.Lg;
    }

    public final void gX() {
        int i;
        int i2 = 0;
        this.Le = new Bundle();
        for (i = 0; i < this.Ld.length; i++) {
            this.Le.putInt(this.Ld[i], i);
        }
        this.Lh = new int[this.Lf.length];
        i = 0;
        while (i2 < this.Lf.length) {
            this.Lh[i2] = i;
            i += this.Lf[i2].getNumRows() - (i - this.Lf[i2].getStartPosition());
            i2++;
        }
        this.Li = i;
    }

    final String[] gY() {
        return this.Ld;
    }

    final CursorWindow[] gZ() {
        return this.Lf;
    }

    public final int getCount() {
        return this.Li;
    }

    public final int getStatusCode() {
        return this.Iv;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final boolean m1871h(String str, int i, int i2) {
        m1861g(str, i);
        return this.Lf[i2].isNull(i, this.Le.getInt(str));
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0526f.m1876a(this, parcel, i);
    }
}
