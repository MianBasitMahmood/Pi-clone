package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR;
    final int CK;
    private int Oi;
    private int avV;
    private WalletFragmentStyle aww;
    private int mTheme;

    public final class Builder {
        final /* synthetic */ WalletFragmentOptions awx;

        private Builder(WalletFragmentOptions walletFragmentOptions) {
            this.awx = walletFragmentOptions;
        }

        public final WalletFragmentOptions build() {
            return this.awx;
        }

        public final Builder setEnvironment(int i) {
            this.awx.avV = i;
            return this;
        }

        public final Builder setFragmentStyle(int i) {
            this.awx.aww = new WalletFragmentStyle().setStyleResourceId(i);
            return this;
        }

        public final Builder setFragmentStyle(WalletFragmentStyle walletFragmentStyle) {
            this.awx.aww = walletFragmentStyle;
            return this;
        }

        public final Builder setMode(int i) {
            this.awx.Oi = i;
            return this;
        }

        public final Builder setTheme(int i) {
            this.awx.mTheme = i;
            return this;
        }
    }

    static {
        CREATOR = new C1861b();
    }

    private WalletFragmentOptions() {
        this.CK = 1;
    }

    WalletFragmentOptions(int i, int i2, int i3, WalletFragmentStyle walletFragmentStyle, int i4) {
        this.CK = i;
        this.avV = i2;
        this.mTheme = i3;
        this.aww = walletFragmentStyle;
        this.Oi = i4;
    }

    public static WalletFragmentOptions m6779a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0366R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(C0366R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(C0366R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(C0366R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(C0366R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.avV = i2;
        walletFragmentOptions.aww = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.aww.ab(context);
        walletFragmentOptions.Oi = i3;
        return walletFragmentOptions;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder(null);
    }

    public final void ab(Context context) {
        if (this.aww != null) {
            this.aww.ab(context);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final int getEnvironment() {
        return this.avV;
    }

    public final WalletFragmentStyle getFragmentStyle() {
        return this.aww;
    }

    public final int getMode() {
        return this.Oi;
    }

    public final int getTheme() {
        return this.mTheme;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1861b.m6788a(this, parcel, i);
    }
}
