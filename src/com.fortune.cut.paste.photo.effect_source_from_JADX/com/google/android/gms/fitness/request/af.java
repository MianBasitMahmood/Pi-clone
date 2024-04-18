package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class af implements SafeParcelable {
    public static final Creator<af> CREATOR;
    private final int CK;
    private final Subscription Wo;
    private final boolean Wp;

    /* renamed from: com.google.android.gms.fitness.request.af.a */
    public static class C0805a {
        private Subscription Wo;
        private boolean Wp;

        public C0805a() {
            this.Wp = false;
        }

        public C0805a m2742b(Subscription subscription) {
            this.Wo = subscription;
            return this;
        }

        public af kp() {
            jx.m5217a(this.Wo != null, "Must call setSubscription()");
            return new af();
        }
    }

    static {
        CREATOR = new ag();
    }

    af(int i, Subscription subscription, boolean z) {
        this.CK = i;
        this.Wo = subscription;
        this.Wp = z;
    }

    private af(C0805a c0805a) {
        this.CK = 1;
        this.Wo = c0805a.Wo;
        this.Wp = c0805a.Wp;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public Subscription kn() {
        return this.Wo;
    }

    public boolean ko() {
        return this.Wp;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("subscription", this.Wo).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ag.m2743a(this, parcel, i);
    }
}
