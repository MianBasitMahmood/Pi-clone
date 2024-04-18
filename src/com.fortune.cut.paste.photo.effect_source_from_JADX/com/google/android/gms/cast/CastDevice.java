package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final Creator<CastDevice> CREATOR;
    private final int CK;
    private String FG;
    String FH;
    private Inet4Address FI;
    private String FJ;
    private String FK;
    private String FL;
    private int FM;
    private List<WebImage> FN;
    private int FO;
    private int FP;

    static {
        CREATOR = new C0485b();
    }

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int i, String str, String str2, String str3, String str4, String str5, int i2, List<WebImage> list, int i3, int i4) {
        this.CK = i;
        this.FG = str;
        this.FH = str2;
        if (this.FH != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.FH);
                if (byName instanceof Inet4Address) {
                    this.FI = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.FI = null;
            }
        }
        this.FJ = str3;
        this.FK = str4;
        this.FL = str5;
        this.FM = i2;
        this.FN = list;
        this.FO = i3;
        this.FP = i4;
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : in.m5027a(this.FG, castDevice.FG) && in.m5027a(this.FI, castDevice.FI) && in.m5027a(this.FK, castDevice.FK) && in.m5027a(this.FJ, castDevice.FJ) && in.m5027a(this.FL, castDevice.FL) && this.FM == castDevice.FM && in.m5027a(this.FN, castDevice.FN) && this.FO == castDevice.FO && this.FP == castDevice.FP;
    }

    public int getCapabilities() {
        return this.FO;
    }

    public String getDeviceId() {
        return this.FG;
    }

    public String getDeviceVersion() {
        return this.FL;
    }

    public String getFriendlyName() {
        return this.FJ;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.common.images.WebImage getIcon(int r9, int r10) {
        /*
        r8 = this;
        r7 = 0;
        r1 = 0;
        r0 = r8.FN;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        if (r9 <= 0) goto L_0x000f;
    L_0x000d:
        if (r10 > 0) goto L_0x0019;
    L_0x000f:
        r0 = r8.FN;
        r0 = r0.get(r7);
        r0 = (com.google.android.gms.common.images.WebImage) r0;
        r1 = r0;
        goto L_0x000a;
    L_0x0019:
        r0 = r8.FN;
        r3 = r0.iterator();
        r2 = r1;
    L_0x0020:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x005c;
    L_0x0026:
        r0 = r3.next();
        r0 = (com.google.android.gms.common.images.WebImage) r0;
        r4 = r0.getWidth();
        r5 = r0.getHeight();
        if (r4 < r9) goto L_0x0048;
    L_0x0036:
        if (r5 < r10) goto L_0x0048;
    L_0x0038:
        if (r2 == 0) goto L_0x0046;
    L_0x003a:
        r6 = r2.getWidth();
        if (r6 <= r4) goto L_0x006e;
    L_0x0040:
        r4 = r2.getHeight();
        if (r4 <= r5) goto L_0x006e;
    L_0x0046:
        r2 = r0;
        goto L_0x0020;
    L_0x0048:
        if (r4 >= r9) goto L_0x006e;
    L_0x004a:
        if (r5 >= r10) goto L_0x006e;
    L_0x004c:
        if (r1 == 0) goto L_0x005a;
    L_0x004e:
        r6 = r1.getWidth();
        if (r6 >= r4) goto L_0x006e;
    L_0x0054:
        r4 = r1.getHeight();
        if (r4 >= r5) goto L_0x006e;
    L_0x005a:
        r1 = r0;
        goto L_0x0020;
    L_0x005c:
        if (r2 == 0) goto L_0x0060;
    L_0x005e:
        r1 = r2;
        goto L_0x000a;
    L_0x0060:
        if (r1 == 0) goto L_0x0064;
    L_0x0062:
        r2 = r1;
        goto L_0x005e;
    L_0x0064:
        r0 = r8.FN;
        r0 = r0.get(r7);
        r0 = (com.google.android.gms.common.images.WebImage) r0;
        r2 = r0;
        goto L_0x005e;
    L_0x006e:
        r0 = r1;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastDevice.getIcon(int, int):com.google.android.gms.common.images.WebImage");
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.FN);
    }

    public Inet4Address getIpAddress() {
        return this.FI;
    }

    public String getModelName() {
        return this.FK;
    }

    public int getServicePort() {
        return this.FM;
    }

    public int getStatus() {
        return this.FP;
    }

    int getVersionCode() {
        return this.CK;
    }

    public boolean hasIcons() {
        return !this.FN.isEmpty();
    }

    public int hashCode() {
        return this.FG == null ? 0 : this.FG.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.FG.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        return castDevice == null ? false : getDeviceId() == null ? castDevice.getDeviceId() == null : in.m5027a(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.FJ, this.FG});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0485b.m1762a(this, parcel, i);
    }
}
