package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;
import com.google.android.gms.internal.jx;

public final class ParticipantResult implements SafeParcelable {
    public static final ParticipantResultCreator CREATOR;
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    private final int CK;
    private final String Zk;
    private final int aec;
    private final int aed;

    static {
        CREATOR = new ParticipantResultCreator();
    }

    public ParticipantResult(int i, String str, int i2, int i3) {
        this.CK = i;
        this.Zk = (String) jx.m5223i(str);
        jx.m5215K(MatchResult.isValid(i2));
        this.aec = i2;
        this.aed = i3;
    }

    public ParticipantResult(String str, int i, int i2) {
        this(MATCH_RESULT_LOSS, str, i, i2);
    }

    public final int describeContents() {
        return MATCH_RESULT_WIN;
    }

    public final String getParticipantId() {
        return this.Zk;
    }

    public final int getPlacing() {
        return this.aed;
    }

    public final int getResult() {
        return this.aec;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ParticipantResultCreator.m4044a(this, parcel, i);
    }
}
