package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.fitness.request.y */
public class C0839y implements SafeParcelable {
    public static final Creator<C0839y> CREATOR;
    private final int CK;
    private final String UN;
    private final String mName;

    /* renamed from: com.google.android.gms.fitness.request.y.a */
    public static class C0838a {
        private String UN;
        private String mName;

        public C0838a bx(String str) {
            this.mName = str;
            return this;
        }

        public C0838a by(String str) {
            this.UN = str;
            return this;
        }

        public C0839y kl() {
            return new C0839y();
        }
    }

    static {
        CREATOR = new C0840z();
    }

    C0839y(int i, String str, String str2) {
        this.CK = i;
        this.mName = str;
        this.UN = str2;
    }

    private C0839y(C0838a c0838a) {
        this.CK = 1;
        this.mName = c0838a.mName;
        this.UN = c0838a.UN;
    }

    private boolean m2779a(C0839y c0839y) {
        return jv.equal(this.mName, c0839y.mName) && jv.equal(this.UN, c0839y.UN);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0839y) && m2779a((C0839y) obj));
    }

    public String getIdentifier() {
        return this.UN;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName, this.UN);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("name", this.mName).m5211a("identifier", this.UN).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0840z.m2780a(this, parcel, i);
    }
}
