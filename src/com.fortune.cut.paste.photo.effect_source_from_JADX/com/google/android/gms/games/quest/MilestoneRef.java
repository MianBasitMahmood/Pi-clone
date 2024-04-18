package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wallet.fragment.WalletFragmentState;
import com.google.android.gms.wearable.DataEvent;

public final class MilestoneRef extends C0451d implements Milestone {
    MilestoneRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private long mP() {
        return getLong("initial_value");
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return MilestoneEntity.m4068a(this, obj);
    }

    public final Milestone freeze() {
        return new MilestoneEntity(this);
    }

    public final byte[] getCompletionRewardData() {
        return getByteArray("completion_reward_data");
    }

    public final long getCurrentProgress() {
        switch (getState()) {
            case DataEvent.TYPE_DELETED /*2*/:
                return getLong("current_value") - mP();
            case WalletFragmentState.PROCESSING /*3*/:
            case WalletFragmentState.WALLET_UNAVAILABLE /*4*/:
                return getTargetProgress();
            default:
                return 0;
        }
    }

    public final String getEventId() {
        return getString("external_event_id");
    }

    public final String getMilestoneId() {
        return getString("external_milestone_id");
    }

    public final int getState() {
        return getInteger("milestone_state");
    }

    public final long getTargetProgress() {
        return getLong("target_value");
    }

    public final int hashCode() {
        return MilestoneEntity.m4067a(this);
    }

    public final String toString() {
        return MilestoneEntity.m4069b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((MilestoneEntity) freeze()).writeToParcel(parcel, i);
    }
}
