package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR;
    private final String CE;
    final int CK;
    private final String KP;

    static {
        CREATOR = new C1957j();
    }

    DataItemAssetParcelable(int i, String str, String str2) {
        this.CK = i;
        this.CE = str;
        this.KP = str2;
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        this.CK = 1;
        this.CE = (String) jx.m5223i(dataItemAsset.getId());
        this.KP = (String) jx.m5223i(dataItemAsset.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return ro();
    }

    public String getDataItemKey() {
        return this.KP;
    }

    public String getId() {
        return this.CE;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataItemAsset ro() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.CE == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.CE);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.KP);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1957j.m7035a(this, parcel, i);
    }
}
