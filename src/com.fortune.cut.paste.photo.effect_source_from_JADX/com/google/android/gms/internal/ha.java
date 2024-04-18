package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ha implements Parcelable {
    @Deprecated
    public static final Creator<ha> CREATOR;
    private String CE;
    private String CF;
    private String mValue;

    /* renamed from: com.google.android.gms.internal.ha.1 */
    static class C11831 implements Creator<ha> {
        C11831() {
        }

        @Deprecated
        public final ha[] m4825I(int i) {
            return new ha[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m4826k(parcel);
        }

        @Deprecated
        public final ha m4826k(Parcel parcel) {
            return new ha(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return m4825I(i);
        }
    }

    static {
        CREATOR = new C11831();
    }

    @Deprecated
    ha(Parcel parcel) {
        readFromParcel(parcel);
    }

    public ha(String str, String str2, String str3) {
        this.CE = str;
        this.CF = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel parcel) {
        this.CE = parcel.readString();
        this.CF = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.CE;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.CE);
        parcel.writeString(this.CF);
        parcel.writeString(this.mValue);
    }
}
