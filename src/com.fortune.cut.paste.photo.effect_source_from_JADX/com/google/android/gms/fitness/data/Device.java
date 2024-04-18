package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest.Status.Error;

public final class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR;
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int CK;
    private final int Gt;
    private final String TU;
    private final String Uw;
    private final String Ux;
    private final String Uy;
    private final int Uz;

    static {
        CREATOR = new C0774i();
    }

    Device(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.CK = i;
        this.Uw = (String) jx.m5223i(str);
        this.Ux = (String) jx.m5223i(str2);
        this.TU = "";
        this.Uy = (String) jx.m5223i(str4);
        this.Gt = i2;
        this.Uz = i3;
    }

    public Device(String str, String str2, String str3, int i) {
        this(str, str2, "", str3, i, TYPE_UNKNOWN);
    }

    public Device(String str, String str2, String str3, String str4, int i) {
        this(str, str2, str4, i);
    }

    public Device(String str, String str2, String str3, String str4, int i, int i2) {
        this(TYPE_PHONE, str, str2, "", str4, i, i2);
    }

    private static String m2625M(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    private static int m2626N(Context context) {
        switch (m2628P(context)) {
            case Error.FRAUD_DECLINE /*8*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                return TYPE_UNKNOWN;
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                return m2627O(context) ? TYPE_WATCH : TYPE_UNKNOWN;
            default:
                return m2630R(context) ? TYPE_PHONE : TYPE_TABLET;
        }
    }

    public static boolean m2627O(Context context) {
        return (context.getResources().getConfiguration().uiMode & 15) == 6;
    }

    private static int m2628P(Context context) {
        return ((m2629Q(context) % LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) / 100) + TYPE_SCALE;
    }

    private static int m2629Q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, TYPE_UNKNOWN).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    private static boolean m2630R(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }

    private boolean m2631a(Device device) {
        return jv.equal(this.Uw, device.Uw) && jv.equal(this.Ux, device.Ux) && jv.equal(this.TU, device.TU) && jv.equal(this.Uy, device.Uy) && this.Gt == device.Gt && this.Uz == device.Uz;
    }

    public static Device getLocalDevice(Context context) {
        int N = m2626N(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, m2625M(context), N, TYPE_TABLET);
    }

    private boolean jD() {
        return jC() == TYPE_PHONE;
    }

    public final int describeContents() {
        return TYPE_UNKNOWN;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof Device) && m2631a((Device) obj));
    }

    public final String getManufacturer() {
        return this.Uw;
    }

    public final String getModel() {
        return this.Ux;
    }

    final String getStreamIdentifier() {
        Object[] objArr = new Object[TYPE_WATCH];
        objArr[TYPE_UNKNOWN] = this.Uw;
        objArr[TYPE_PHONE] = this.Ux;
        objArr[TYPE_TABLET] = this.Uy;
        return String.format("%s:%s:%s", objArr);
    }

    public final int getType() {
        return this.Gt;
    }

    public final String getUid() {
        return this.Uy;
    }

    public final String getVersion() {
        return this.TU;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        Object[] objArr = new Object[TYPE_SCALE];
        objArr[TYPE_UNKNOWN] = this.Uw;
        objArr[TYPE_PHONE] = this.Ux;
        objArr[TYPE_TABLET] = this.TU;
        objArr[TYPE_WATCH] = this.Uy;
        objArr[TYPE_CHEST_STRAP] = Integer.valueOf(this.Gt);
        return jv.hashCode(objArr);
    }

    public final int jC() {
        return this.Uz;
    }

    final Device jE() {
        return new Device(mg.bw(this.Uw), mg.bw(this.Ux), mg.bw(this.TU), this.Uy, this.Gt);
    }

    public final String jF() {
        return (mg.jN() || jD()) ? this.Uy : mg.bw(this.Uy);
    }

    public final String toString() {
        Object[] objArr = new Object[TYPE_CHEST_STRAP];
        objArr[TYPE_UNKNOWN] = getStreamIdentifier();
        objArr[TYPE_PHONE] = this.TU;
        objArr[TYPE_TABLET] = Integer.valueOf(this.Gt);
        objArr[TYPE_WATCH] = Integer.valueOf(this.Uz);
        return String.format("Device{%s:%s:%s:%s}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0774i.m2660a(this, parcel, i);
    }
}
