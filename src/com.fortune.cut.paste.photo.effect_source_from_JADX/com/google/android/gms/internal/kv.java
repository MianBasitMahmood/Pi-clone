package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kr.C1277a;
import java.util.ArrayList;
import java.util.HashMap;

public class kv implements SafeParcelable {
    public static final kw CREATOR;
    private final int CK;
    private final HashMap<String, HashMap<String, C1277a<?, ?>>> NV;
    private final ArrayList<C1278a> NW;
    private final String NX;

    /* renamed from: com.google.android.gms.internal.kv.a */
    public static class C1278a implements SafeParcelable {
        public static final kx CREATOR;
        final ArrayList<C1279b> NY;
        final String className;
        final int versionCode;

        static {
            CREATOR = new kx();
        }

        C1278a(int i, String str, ArrayList<C1279b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.NY = arrayList;
        }

        C1278a(String str, HashMap<String, C1277a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.NY = C1278a.m5288a(hashMap);
        }

        private static ArrayList<C1279b> m5288a(HashMap<String, C1277a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C1279b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C1279b(str, (C1277a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            kx kxVar = CREATOR;
            return 0;
        }

        HashMap<String, C1277a<?, ?>> ib() {
            HashMap<String, C1277a<?, ?>> hashMap = new HashMap();
            int size = this.NY.size();
            for (int i = 0; i < size; i++) {
                C1279b c1279b = (C1279b) this.NY.get(i);
                hashMap.put(c1279b.fv, c1279b.NZ);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel parcel, int i) {
            kx kxVar = CREATOR;
            kx.m5294a(this, parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kv.b */
    public static class C1279b implements SafeParcelable {
        public static final ku CREATOR;
        final C1277a<?, ?> NZ;
        final String fv;
        final int versionCode;

        static {
            CREATOR = new ku();
        }

        C1279b(int i, String str, C1277a<?, ?> c1277a) {
            this.versionCode = i;
            this.fv = str;
            this.NZ = c1277a;
        }

        C1279b(String str, C1277a<?, ?> c1277a) {
            this.versionCode = 1;
            this.fv = str;
            this.NZ = c1277a;
        }

        public int describeContents() {
            ku kuVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            ku kuVar = CREATOR;
            ku.m5286a(this, parcel, i);
        }
    }

    static {
        CREATOR = new kw();
    }

    kv(int i, ArrayList<C1278a> arrayList, String str) {
        this.CK = i;
        this.NW = null;
        this.NV = m5289c(arrayList);
        this.NX = (String) jx.m5223i(str);
        hX();
    }

    public kv(Class<? extends kr> cls) {
        this.CK = 1;
        this.NW = null;
        this.NV = new HashMap();
        this.NX = cls.getCanonicalName();
    }

    private static HashMap<String, HashMap<String, C1277a<?, ?>>> m5289c(ArrayList<C1278a> arrayList) {
        HashMap<String, HashMap<String, C1277a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C1278a c1278a = (C1278a) arrayList.get(i);
            hashMap.put(c1278a.className, c1278a.ib());
        }
        return hashMap;
    }

    public void m5290a(Class<? extends kr> cls, HashMap<String, C1277a<?, ?>> hashMap) {
        this.NV.put(cls.getCanonicalName(), hashMap);
    }

    public boolean m5291b(Class<? extends kr> cls) {
        return this.NV.containsKey(cls.getCanonicalName());
    }

    public HashMap<String, C1277a<?, ?>> bg(String str) {
        return (HashMap) this.NV.get(str);
    }

    public int describeContents() {
        kw kwVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public void hX() {
        for (String str : this.NV.keySet()) {
            HashMap hashMap = (HashMap) this.NV.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C1277a) hashMap.get(str2)).m5278a(this);
            }
        }
    }

    public void hY() {
        for (String str : this.NV.keySet()) {
            HashMap hashMap = (HashMap) this.NV.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C1277a) hashMap.get(str2)).hN());
            }
            this.NV.put(str, hashMap2);
        }
    }

    ArrayList<C1278a> hZ() {
        ArrayList<C1278a> arrayList = new ArrayList();
        for (String str : this.NV.keySet()) {
            arrayList.add(new C1278a(str, (HashMap) this.NV.get(str)));
        }
        return arrayList;
    }

    public String ia() {
        return this.NX;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.NV.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.NV.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        kw kwVar = CREATOR;
        kw.m5292a(this, parcel, i);
    }
}
