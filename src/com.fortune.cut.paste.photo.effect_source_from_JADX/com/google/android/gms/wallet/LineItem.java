package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR;
    private final int CK;
    String auF;
    String auG;
    String auZ;
    String ava;
    int avb;
    String description;

    public final class Builder {
        final /* synthetic */ LineItem avc;

        private Builder(LineItem lineItem) {
            this.avc = lineItem;
        }

        public final LineItem build() {
            return this.avc;
        }

        public final Builder setCurrencyCode(String str) {
            this.avc.auG = str;
            return this;
        }

        public final Builder setDescription(String str) {
            this.avc.description = str;
            return this;
        }

        public final Builder setQuantity(String str) {
            this.avc.auZ = str;
            return this;
        }

        public final Builder setRole(int i) {
            this.avc.avb = i;
            return this;
        }

        public final Builder setTotalPrice(String str) {
            this.avc.auF = str;
            return this;
        }

        public final Builder setUnitPrice(String str) {
            this.avc.ava = str;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    static {
        CREATOR = new C1865i();
    }

    LineItem() {
        this.CK = 1;
        this.avb = 0;
    }

    LineItem(int i, String str, String str2, String str3, String str4, int i2, String str5) {
        this.CK = i;
        this.description = str;
        this.auZ = str2;
        this.ava = str3;
        this.auF = str4;
        this.avb = i2;
        this.auG = str5;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final String getCurrencyCode() {
        return this.auG;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getQuantity() {
        return this.auZ;
    }

    public final int getRole() {
        return this.avb;
    }

    public final String getTotalPrice() {
        return this.auF;
    }

    public final String getUnitPrice() {
        return this.ava;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1865i.m6792a(this, parcel, i);
    }
}
