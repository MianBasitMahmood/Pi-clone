package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final MilestoneEntityCreator CREATOR;
    private final int CK;
    private final String Ye;
    private final String Zn;
    private final long aeH;
    private final long aeI;
    private final byte[] aeJ;
    private final int mState;

    static {
        CREATOR = new MilestoneEntityCreator();
    }

    MilestoneEntity(int i, String str, long j, long j2, byte[] bArr, int i2, String str2) {
        this.CK = i;
        this.Zn = str;
        this.aeH = j;
        this.aeI = j2;
        this.aeJ = bArr;
        this.mState = i2;
        this.Ye = str2;
    }

    public MilestoneEntity(Milestone milestone) {
        this.CK = 4;
        this.Zn = milestone.getMilestoneId();
        this.aeH = milestone.getCurrentProgress();
        this.aeI = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.Ye = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.aeJ = null;
            return;
        }
        this.aeJ = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.aeJ, 0, completionRewardData.length);
    }

    static int m4067a(Milestone milestone) {
        return jv.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean m4068a(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return jv.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && jv.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && jv.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && jv.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && jv.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String m4069b(Milestone milestone) {
        return jv.m5212h(milestone).m5211a("MilestoneId", milestone.getMilestoneId()).m5211a("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).m5211a("TargetProgress", Long.valueOf(milestone.getTargetProgress())).m5211a("State", Integer.valueOf(milestone.getState())).m5211a("CompletionRewardData", milestone.getCompletionRewardData()).m5211a("EventId", milestone.getEventId()).toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return m4068a(this, obj);
    }

    public final Milestone freeze() {
        return this;
    }

    public final byte[] getCompletionRewardData() {
        return this.aeJ;
    }

    public final long getCurrentProgress() {
        return this.aeH;
    }

    public final String getEventId() {
        return this.Ye;
    }

    public final String getMilestoneId() {
        return this.Zn;
    }

    public final int getState() {
        return this.mState;
    }

    public final long getTargetProgress() {
        return this.aeI;
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return m4067a(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return m4069b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        MilestoneEntityCreator.m4070a(this, parcel, i);
    }
}
