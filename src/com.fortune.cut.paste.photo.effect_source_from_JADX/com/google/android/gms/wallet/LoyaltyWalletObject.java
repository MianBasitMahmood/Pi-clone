package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.C1877d;
import com.google.android.gms.wallet.wobs.C1879f;
import com.google.android.gms.wallet.wobs.C1883j;
import com.google.android.gms.wallet.wobs.C1885l;
import com.google.android.gms.wallet.wobs.C1887n;
import com.google.android.gms.wallet.wobs.C1889p;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR;
    private final int CK;
    String aki;
    String avd;
    String ave;
    String avf;
    String avg;
    String avh;
    String avi;
    String avj;
    String avk;
    ArrayList<C1889p> avl;
    C1885l avm;
    ArrayList<LatLng> avn;
    String avo;
    String avp;
    ArrayList<C1877d> avq;
    boolean avr;
    ArrayList<C1887n> avs;
    ArrayList<C1883j> avt;
    ArrayList<C1887n> avu;
    C1879f avv;
    String fl;
    int state;

    static {
        CREATOR = new C1866j();
    }

    LoyaltyWalletObject() {
        this.CK = 4;
        this.avl = la.ie();
        this.avn = la.ie();
        this.avq = la.ie();
        this.avs = la.ie();
        this.avt = la.ie();
        this.avu = la.ie();
    }

    LoyaltyWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, ArrayList<C1889p> arrayList, C1885l c1885l, ArrayList<LatLng> arrayList2, String str11, String str12, ArrayList<C1877d> arrayList3, boolean z, ArrayList<C1887n> arrayList4, ArrayList<C1883j> arrayList5, ArrayList<C1887n> arrayList6, C1879f c1879f) {
        this.CK = i;
        this.fl = str;
        this.avd = str2;
        this.ave = str3;
        this.avf = str4;
        this.aki = str5;
        this.avg = str6;
        this.avh = str7;
        this.avi = str8;
        this.avj = str9;
        this.avk = str10;
        this.state = i2;
        this.avl = arrayList;
        this.avm = c1885l;
        this.avn = arrayList2;
        this.avo = str11;
        this.avp = str12;
        this.avq = arrayList3;
        this.avr = z;
        this.avs = arrayList4;
        this.avt = arrayList5;
        this.avu = arrayList6;
        this.avv = c1879f;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getAccountId() {
        return this.avd;
    }

    public final String getAccountName() {
        return this.aki;
    }

    public final String getBarcodeAlternateText() {
        return this.avg;
    }

    public final String getBarcodeType() {
        return this.avh;
    }

    public final String getBarcodeValue() {
        return this.avi;
    }

    public final String getId() {
        return this.fl;
    }

    public final String getIssuerName() {
        return this.ave;
    }

    public final String getProgramName() {
        return this.avf;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1866j.m6793a(this, parcel, i);
    }
}
