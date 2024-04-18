package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR;
    private final int CK;
    String auF;
    String auG;
    ArrayList<LineItem> auH;

    public final class Builder {
        final /* synthetic */ Cart auI;

        private Builder(Cart cart) {
            this.auI = cart;
        }

        public final Builder addLineItem(LineItem lineItem) {
            this.auI.auH.add(lineItem);
            return this;
        }

        public final Cart build() {
            return this.auI;
        }

        public final Builder setCurrencyCode(String str) {
            this.auI.auG = str;
            return this;
        }

        public final Builder setLineItems(List<LineItem> list) {
            this.auI.auH.clear();
            this.auI.auH.addAll(list);
            return this;
        }

        public final Builder setTotalPrice(String str) {
            this.auI.auF = str;
            return this;
        }
    }

    static {
        CREATOR = new C1845b();
    }

    Cart() {
        this.CK = 1;
        this.auH = new ArrayList();
    }

    Cart(int i, String str, String str2, ArrayList<LineItem> arrayList) {
        this.CK = i;
        this.auF = str;
        this.auG = str2;
        this.auH = arrayList;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final String getCurrencyCode() {
        return this.auG;
    }

    public final ArrayList<LineItem> getLineItems() {
        return this.auH;
    }

    public final String getTotalPrice() {
        return this.auF;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1845b.m6711a(this, parcel, i);
    }
}
