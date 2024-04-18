package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Creator<OnResourceIdSetResponse> CREATOR;
    private final int CK;
    private final List<String> Po;

    static {
        CREATOR = new av();
    }

    OnResourceIdSetResponse(int i, List<String> list) {
        this.CK = i;
        this.Po = list;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public List<String> iF() {
        return this.Po;
    }

    public void writeToParcel(Parcel parcel, int i) {
        av.m2169a(this, parcel, i);
    }
}
