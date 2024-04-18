package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kr.C1276b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class ko implements SafeParcelable, C1276b<String, Integer> {
    public static final kp CREATOR;
    private final int CK;
    private final HashMap<String, Integer> NG;
    private final HashMap<Integer, String> NH;
    private final ArrayList<C1275a> NI;

    /* renamed from: com.google.android.gms.internal.ko.a */
    public static final class C1275a implements SafeParcelable {
        public static final kq CREATOR;
        final String NJ;
        final int NK;
        final int versionCode;

        static {
            CREATOR = new kq();
        }

        C1275a(int i, String str, int i2) {
            this.versionCode = i;
            this.NJ = str;
            this.NK = i2;
        }

        C1275a(String str, int i) {
            this.versionCode = 1;
            this.NJ = str;
            this.NK = i;
        }

        public final int describeContents() {
            kq kqVar = CREATOR;
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            kq kqVar = CREATOR;
            kq.m5267a(this, parcel, i);
        }
    }

    static {
        CREATOR = new kp();
    }

    public ko() {
        this.CK = 1;
        this.NG = new HashMap();
        this.NH = new HashMap();
        this.NI = null;
    }

    ko(int i, ArrayList<C1275a> arrayList) {
        this.CK = i;
        this.NG = new HashMap();
        this.NH = new HashMap();
        this.NI = null;
        m5262b(arrayList);
    }

    private void m5262b(ArrayList<C1275a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1275a c1275a = (C1275a) it.next();
            m5264h(c1275a.NJ, c1275a.NK);
        }
    }

    public final String m5263a(Integer num) {
        String str = (String) this.NH.get(num);
        return (str == null && this.NG.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final /* synthetic */ Object convertBack(Object obj) {
        return m5263a((Integer) obj);
    }

    public final int describeContents() {
        kp kpVar = CREATOR;
        return 0;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final ko m5264h(String str, int i) {
        this.NG.put(str, Integer.valueOf(i));
        this.NH.put(Integer.valueOf(i), str);
        return this;
    }

    final ArrayList<C1275a> hH() {
        ArrayList<C1275a> arrayList = new ArrayList();
        for (String str : this.NG.keySet()) {
            arrayList.add(new C1275a(str, ((Integer) this.NG.get(str)).intValue()));
        }
        return arrayList;
    }

    public final int hI() {
        return 7;
    }

    public final int hJ() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        kp kpVar = CREATOR;
        kp.m5265a(this, parcel, i);
    }
}
