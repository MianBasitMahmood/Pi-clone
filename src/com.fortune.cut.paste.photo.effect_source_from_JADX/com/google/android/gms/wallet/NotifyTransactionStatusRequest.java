package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Creator<NotifyTransactionStatusRequest> CREATOR;
    final int CK;
    String auL;
    String avL;
    int status;

    public final class Builder {
        final /* synthetic */ NotifyTransactionStatusRequest avM;

        private Builder(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.avM = notifyTransactionStatusRequest;
        }

        public final NotifyTransactionStatusRequest build() {
            boolean z = true;
            jx.m5221b(!TextUtils.isEmpty(this.avM.auL), (Object) "googleTransactionId is required");
            if (this.avM.status <= 0 || this.avM.status > 8) {
                z = false;
            }
            jx.m5221b(z, (Object) "status is an unrecognized value");
            return this.avM;
        }

        public final Builder setDetailedReason(String str) {
            this.avM.avL = str;
            return this;
        }

        public final Builder setGoogleTransactionId(String str) {
            this.avM.auL = str;
            return this;
        }

        public final Builder setStatus(int i) {
            this.avM.status = i;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    static {
        CREATOR = new C1869m();
    }

    NotifyTransactionStatusRequest() {
        this.CK = 1;
    }

    NotifyTransactionStatusRequest(int i, String str, int i2, String str2) {
        this.CK = i;
        this.auL = str;
        this.status = i2;
        this.avL = str2;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final String getDetailedReason() {
        return this.avL;
    }

    public final String getGoogleTransactionId() {
        return this.auL;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1869m.m6796a(this, parcel, i);
    }
}
