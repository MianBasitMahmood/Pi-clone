package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR;
    private final int CK;
    String ave;
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
    String fl;
    String name;
    int state;

    /* renamed from: com.google.android.gms.wallet.wobs.CommonWalletObject.a */
    public final class C1873a {
        final /* synthetic */ CommonWalletObject awI;

        private C1873a(CommonWalletObject commonWalletObject) {
            this.awI = commonWalletObject;
        }

        public final C1873a dh(String str) {
            this.awI.fl = str;
            return this;
        }

        public final CommonWalletObject ri() {
            return this.awI;
        }
    }

    static {
        CREATOR = new C1874a();
    }

    CommonWalletObject() {
        this.CK = 1;
        this.avl = la.ie();
        this.avn = la.ie();
        this.avq = la.ie();
        this.avs = la.ie();
        this.avt = la.ie();
        this.avu = la.ie();
    }

    CommonWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, ArrayList<C1889p> arrayList, C1885l c1885l, ArrayList<LatLng> arrayList2, String str9, String str10, ArrayList<C1877d> arrayList3, boolean z, ArrayList<C1887n> arrayList4, ArrayList<C1883j> arrayList5, ArrayList<C1887n> arrayList6) {
        this.CK = i;
        this.fl = str;
        this.avk = str2;
        this.name = str3;
        this.ave = str4;
        this.avg = str5;
        this.avh = str6;
        this.avi = str7;
        this.avj = str8;
        this.state = i2;
        this.avl = arrayList;
        this.avm = c1885l;
        this.avn = arrayList2;
        this.avo = str9;
        this.avp = str10;
        this.avq = arrayList3;
        this.avr = z;
        this.avs = arrayList4;
        this.avt = arrayList5;
        this.avu = arrayList6;
    }

    public static C1873a rh() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new C1873a(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.fl;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1874a.m6799a(this, parcel, i);
    }
}
