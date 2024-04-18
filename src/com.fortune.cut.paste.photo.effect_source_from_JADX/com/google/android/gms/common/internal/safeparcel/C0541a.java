package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.games.request.GameRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C0541a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a.a */
    public static class C0540a extends RuntimeException {
        public C0540a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static String[] m1914A(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList<Integer> m1915B(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a);
        return arrayList;
    }

    public static ArrayList<String> m1916C(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    public static Parcel m1917D(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    public static Parcel[] m1918E(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }

    public static int m1919F(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m1920G(Parcel parcel) {
        int F = C0541a.m1919F(parcel);
        int a = C0541a.m1921a(parcel, F);
        int dataPosition = parcel.dataPosition();
        if (C0541a.aH(F) != 20293) {
            throw new C0540a("Expected object header. Got 0x" + Integer.toHexString(F), parcel);
        }
        F = dataPosition + a;
        if (F >= dataPosition && F <= parcel.dataSize()) {
            return F;
        }
        throw new C0540a("Size read is invalid start=" + dataPosition + " end=" + F, parcel);
    }

    public static int m1921a(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != SupportMenu.CATEGORY_MASK ? (i >> 16) & GameRequest.TYPE_ALL : parcel.readInt();
    }

    public static <T extends Parcelable> T m1922a(Parcel parcel, int i, Creator<T> creator) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m1923a(Parcel parcel, int i, int i2) {
        int a = C0541a.m1921a(parcel, i);
        if (a != i2) {
            throw new C0540a("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    private static void m1924a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C0540a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    public static void m1925a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    public static int aH(int i) {
        return GameRequest.TYPE_ALL & i;
    }

    public static void m1926b(Parcel parcel, int i) {
        parcel.setDataPosition(C0541a.m1921a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m1927b(Parcel parcel, int i, Creator<T> creator) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m1928c(Parcel parcel, int i, Creator<T> creator) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m1929c(Parcel parcel, int i) {
        C0541a.m1923a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean m1930d(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0541a.m1924a(parcel, i, a, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte m1931e(Parcel parcel, int i) {
        C0541a.m1923a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static short m1932f(Parcel parcel, int i) {
        C0541a.m1923a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int m1933g(Parcel parcel, int i) {
        C0541a.m1923a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m1934h(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0541a.m1924a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m1935i(Parcel parcel, int i) {
        C0541a.m1923a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m1936j(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0541a.m1924a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static BigInteger m1937k(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float m1938l(Parcel parcel, int i) {
        C0541a.m1923a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static double m1939m(Parcel parcel, int i) {
        C0541a.m1923a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static BigDecimal m1940n(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String m1941o(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m1942p(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m1943q(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m1944r(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static byte[][] m1945s(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a);
        return bArr;
    }

    public static boolean[] m1946t(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    public static int[] m1947u(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static long[] m1948v(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] m1949w(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    public static float[] m1950x(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    public static double[] m1951y(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] m1952z(Parcel parcel, int i) {
        int a = C0541a.m1921a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }
}
