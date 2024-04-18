package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.games.request.GameRequest;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C0542b {
    private static int m1953F(Parcel parcel, int i) {
        parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m1954G(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static int m1955H(Parcel parcel) {
        return C0542b.m1953F(parcel, 20293);
    }

    public static void m1956H(Parcel parcel, int i) {
        C0542b.m1954G(parcel, i);
    }

    public static void m1957a(Parcel parcel, int i, byte b) {
        C0542b.m1978b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m1958a(Parcel parcel, int i, double d) {
        C0542b.m1978b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m1959a(Parcel parcel, int i, float f) {
        C0542b.m1978b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m1960a(Parcel parcel, int i, long j) {
        C0542b.m1978b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m1961a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeBundle(bundle);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1962a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1963a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1964a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int F = C0542b.m1953F(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1965a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            C0542b.m1978b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1966a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C0542b.m1978b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1967a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            C0542b.m1978b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1968a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeString(str);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1969a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int F = C0542b.m1953F(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1970a(Parcel parcel, int i, short s) {
        C0542b.m1978b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void m1971a(Parcel parcel, int i, boolean z) {
        C0542b.m1978b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m1972a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeByteArray(bArr);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1973a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeIntArray(iArr);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m1974a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0542b.m1977a(parcel, parcelable, i2);
                }
            }
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1975a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeStringArray(strArr);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1976a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int F = C0542b.m1953F(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m1977a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void m1978b(Parcel parcel, int i, int i2) {
        if (i2 >= GameRequest.TYPE_ALL) {
            parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void m1979b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeStringList(list);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1980c(Parcel parcel, int i, int i2) {
        C0542b.m1978b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static <T extends Parcelable> void m1981c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int F = C0542b.m1953F(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0542b.m1977a(parcel, parcelable, 0);
                }
            }
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }

    public static void m1982d(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int F = C0542b.m1953F(parcel, i);
            parcel.writeList(list);
            C0542b.m1954G(parcel, F);
        } else if (z) {
            C0542b.m1978b(parcel, i, 0);
        }
    }
}
