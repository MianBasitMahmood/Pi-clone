package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR;
    final int CK;
    private String DZ;
    private MaskedWalletRequest awg;
    private MaskedWallet awh;
    private int awu;

    public final class Builder {
        final /* synthetic */ WalletFragmentInitParams awv;

        private Builder(WalletFragmentInitParams walletFragmentInitParams) {
            this.awv = walletFragmentInitParams;
        }

        public final WalletFragmentInitParams build() {
            boolean z = true;
            boolean z2 = (this.awv.awh != null && this.awv.awg == null) || (this.awv.awh == null && this.awv.awg != null);
            jx.m5217a(z2, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (this.awv.awu < 0) {
                z = false;
            }
            jx.m5217a(z, "masked wallet request code is required and must be non-negative");
            return this.awv;
        }

        public final Builder setAccountName(String str) {
            this.awv.DZ = str;
            return this;
        }

        public final Builder setMaskedWallet(MaskedWallet maskedWallet) {
            this.awv.awh = maskedWallet;
            return this;
        }

        public final Builder setMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            this.awv.awg = maskedWalletRequest;
            return this;
        }

        public final Builder setMaskedWalletRequestCode(int i) {
            this.awv.awu = i;
            return this;
        }
    }

    static {
        CREATOR = new C1860a();
    }

    private WalletFragmentInitParams() {
        this.CK = 1;
        this.awu = -1;
    }

    WalletFragmentInitParams(int i, String str, MaskedWalletRequest maskedWalletRequest, int i2, MaskedWallet maskedWallet) {
        this.CK = i;
        this.DZ = str;
        this.awg = maskedWalletRequest;
        this.awu = i2;
        this.awh = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final String getAccountName() {
        return this.DZ;
    }

    public final MaskedWallet getMaskedWallet() {
        return this.awh;
    }

    public final MaskedWalletRequest getMaskedWalletRequest() {
        return this.awg;
    }

    public final int getMaskedWalletRequestCode() {
        return this.awu;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1860a.m6787a(this, parcel, i);
    }
}
