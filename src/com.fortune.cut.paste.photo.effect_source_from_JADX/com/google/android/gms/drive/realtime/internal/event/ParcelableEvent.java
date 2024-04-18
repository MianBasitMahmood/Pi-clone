package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Creator<ParcelableEvent> CREATOR;
    final int CK;
    final String SJ;
    final String SM;
    final List<String> SQ;
    final boolean SR;
    final String SS;
    final TextInsertedDetails ST;
    final TextDeletedDetails SU;
    final ValuesAddedDetails SV;
    final ValuesRemovedDetails SW;
    final ValuesSetDetails SX;
    final ValueChangedDetails SY;
    final ReferenceShiftedDetails SZ;
    final ObjectChangedDetails Ta;
    final String vZ;

    static {
        CREATOR = new C0697b();
    }

    ParcelableEvent(int i, String str, String str2, List<String> list, boolean z, String str3, String str4, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails) {
        this.CK = i;
        this.vZ = str;
        this.SJ = str2;
        this.SQ = list;
        this.SR = z;
        this.SM = str3;
        this.SS = str4;
        this.ST = textInsertedDetails;
        this.SU = textDeletedDetails;
        this.SV = valuesAddedDetails;
        this.SW = valuesRemovedDetails;
        this.SX = valuesSetDetails;
        this.SY = valueChangedDetails;
        this.SZ = referenceShiftedDetails;
        this.Ta = objectChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0697b.m2450a(this, parcel, i);
    }
}
