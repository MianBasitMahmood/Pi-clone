package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.C0366R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle implements SafeParcelable {
    public static final Creator<WalletFragmentStyle> CREATOR;
    final int CK;
    Bundle awy;
    int awz;

    static {
        CREATOR = new C1862c();
    }

    public WalletFragmentStyle() {
        this.CK = 1;
        this.awy = new Bundle();
    }

    WalletFragmentStyle(int i, Bundle bundle, int i2) {
        this.CK = i;
        this.awy = bundle;
        this.awz = i2;
    }

    private void m6783a(TypedArray typedArray, int i, String str) {
        if (!this.awy.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.awy.putLong(str, Dimension.m6717a(peekValue));
            }
        }
    }

    private void m6784a(TypedArray typedArray, int i, String str, String str2) {
        if (!this.awy.containsKey(str) && !this.awy.containsKey(str2)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue == null) {
                return;
            }
            if (peekValue.type < 28 || peekValue.type > 31) {
                this.awy.putInt(str2, peekValue.resourceId);
            } else {
                this.awy.putInt(str, peekValue.data);
            }
        }
    }

    private void m6785b(TypedArray typedArray, int i, String str) {
        if (!this.awy.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.awy.putInt(str, peekValue.data);
            }
        }
    }

    public final int m6786a(String str, DisplayMetrics displayMetrics, int i) {
        return this.awy.containsKey(str) ? Dimension.m6715a(this.awy.getLong(str), displayMetrics) : i;
    }

    public final void ab(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.awz <= 0 ? C0366R.style.WalletFragmentDefaultStyle : this.awz, C0366R.styleable.WalletFragmentStyle);
        m6783a(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        m6783a(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        m6785b(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        m6785b(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        m6785b(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        m6785b(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        m6784a(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        m6785b(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        m6784a(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        m6785b(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        m6785b(obtainStyledAttributes, C0366R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }

    public final int describeContents() {
        return 0;
    }

    public final WalletFragmentStyle setBuyButtonAppearance(int i) {
        this.awy.putInt("buyButtonAppearance", i);
        return this;
    }

    public final WalletFragmentStyle setBuyButtonHeight(int i) {
        this.awy.putLong("buyButtonHeight", Dimension.gg(i));
        return this;
    }

    public final WalletFragmentStyle setBuyButtonHeight(int i, float f) {
        this.awy.putLong("buyButtonHeight", Dimension.m6716a(i, f));
        return this;
    }

    public final WalletFragmentStyle setBuyButtonText(int i) {
        this.awy.putInt("buyButtonText", i);
        return this;
    }

    public final WalletFragmentStyle setBuyButtonWidth(int i) {
        this.awy.putLong("buyButtonWidth", Dimension.gg(i));
        return this;
    }

    public final WalletFragmentStyle setBuyButtonWidth(int i, float f) {
        this.awy.putLong("buyButtonWidth", Dimension.m6716a(i, f));
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int i) {
        this.awy.remove("maskedWalletDetailsBackgroundResource");
        this.awy.putInt("maskedWalletDetailsBackgroundColor", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int i) {
        this.awy.remove("maskedWalletDetailsBackgroundColor");
        this.awy.putInt("maskedWalletDetailsBackgroundResource", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int i) {
        this.awy.remove("maskedWalletDetailsButtonBackgroundResource");
        this.awy.putInt("maskedWalletDetailsButtonBackgroundColor", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int i) {
        this.awy.remove("maskedWalletDetailsButtonBackgroundColor");
        this.awy.putInt("maskedWalletDetailsButtonBackgroundResource", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int i) {
        this.awy.putInt("maskedWalletDetailsButtonTextAppearance", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int i) {
        this.awy.putInt("maskedWalletDetailsHeaderTextAppearance", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int i) {
        this.awy.putInt("maskedWalletDetailsLogoImageType", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int i) {
        this.awy.putInt("maskedWalletDetailsLogoTextColor", i);
        return this;
    }

    public final WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int i) {
        this.awy.putInt("maskedWalletDetailsTextAppearance", i);
        return this;
    }

    public final WalletFragmentStyle setStyleResourceId(int i) {
        this.awz = i;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1862c.m6789a(this, parcel, i);
    }
}
