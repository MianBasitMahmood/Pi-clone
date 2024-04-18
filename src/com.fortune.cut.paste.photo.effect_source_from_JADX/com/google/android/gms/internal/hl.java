package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class hl {

    /* renamed from: com.google.android.gms.internal.hl.a */
    public static class C1188a implements SafeParcelable {
        public static final hm CREATOR;
        final int CK;
        public final Account Dc;

        static {
            CREATOR = new hm();
        }

        public C1188a() {
            this(null);
        }

        C1188a(int i, Account account) {
            this.CK = i;
            this.Dc = account;
        }

        public C1188a(Account account) {
            this(1, account);
        }

        public int describeContents() {
            hm hmVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            hm hmVar = CREATOR;
            hm.m4846a(this, parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.hl.b */
    public static class C1189b implements Result, SafeParcelable {
        public static final hn CREATOR;
        final int CK;
        public Status Dd;
        public List<hr> De;

        static {
            CREATOR = new hn();
        }

        public C1189b() {
            this.CK = 1;
        }

        C1189b(int i, Status status, List<hr> list) {
            this.CK = i;
            this.Dd = status;
            this.De = list;
        }

        public int describeContents() {
            hn hnVar = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.Dd;
        }

        public void writeToParcel(Parcel parcel, int i) {
            hn hnVar = CREATOR;
            hn.m4849a(this, parcel, i);
        }
    }
}
