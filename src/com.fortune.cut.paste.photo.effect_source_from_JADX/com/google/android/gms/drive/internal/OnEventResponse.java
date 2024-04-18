package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.wearable.DataEvent;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR;
    final int CK;
    final int Pm;
    final ChangeEvent QO;
    final CompletionEvent QP;

    static {
        CREATOR = new aq();
    }

    OnEventResponse(int i, int i2, ChangeEvent changeEvent, CompletionEvent completionEvent) {
        this.CK = i;
        this.Pm = i2;
        this.QO = changeEvent;
        this.QP = completionEvent;
    }

    public int describeContents() {
        return 0;
    }

    public DriveEvent iQ() {
        switch (this.Pm) {
            case DataEvent.TYPE_CHANGED /*1*/:
                return this.QO;
            case DataEvent.TYPE_DELETED /*2*/:
                return this.QP;
            default:
                throw new IllegalStateException("Unexpected event type " + this.Pm);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        aq.m2164a(this, parcel, i);
    }
}
