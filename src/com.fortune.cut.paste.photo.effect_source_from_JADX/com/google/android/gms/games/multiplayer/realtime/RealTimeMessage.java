package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.jx;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR;
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String aee;
    private final byte[] aef;
    private final int aeg;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.1 */
    static class C09861 implements Creator<RealTimeMessage> {
        C09861() {
        }

        public final RealTimeMessage cB(Parcel parcel) {
            return new RealTimeMessage(null);
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return cB(parcel);
        }

        public final RealTimeMessage[] en(int i) {
            return new RealTimeMessage[i];
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return en(i);
        }
    }

    static {
        CREATOR = new C09861();
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String str, byte[] bArr, int i) {
        this.aee = (String) jx.m5223i(str);
        this.aef = (byte[]) ((byte[]) jx.m5223i(bArr)).clone();
        this.aeg = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final byte[] getMessageData() {
        return this.aef;
    }

    public final String getSenderParticipantId() {
        return this.aee;
    }

    public final boolean isReliable() {
        return this.aeg == RELIABLE;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aee);
        parcel.writeByteArray(this.aef);
        parcel.writeInt(this.aeg);
    }
}
