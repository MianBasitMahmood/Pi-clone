package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR;
    private final int CK;
    private final ArrayList<InvitationEntity> acE;

    static {
        CREATOR = new InvitationClusterCreator();
    }

    ZInvitationCluster(int i, ArrayList<InvitationEntity> arrayList) {
        this.CK = i;
        this.acE = arrayList;
        mp();
    }

    private void mp() {
        je.m5079K(!this.acE.isEmpty());
        Invitation invitation = (Invitation) this.acE.get(0);
        int size = this.acE.size();
        for (int i = 1; i < size; i++) {
            je.m5080a(invitation.getInviter().equals(((Invitation) this.acE.get(i)).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.acE.size() != this.acE.size()) {
            return false;
        }
        int size = this.acE.size();
        for (int i = 0; i < size; i++) {
            if (!((Invitation) this.acE.get(i)).equals((Invitation) zInvitationCluster.acE.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final Invitation freeze() {
        return this;
    }

    public final int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final String getInvitationId() {
        return ((InvitationEntity) this.acE.get(0)).getInvitationId();
    }

    public final int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final Participant getInviter() {
        return ((InvitationEntity) this.acE.get(0)).getInviter();
    }

    public final ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final int getVersionCode() {
        return this.CK;
    }

    public final int hashCode() {
        return jv.hashCode(this.acE.toArray());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final ArrayList<Invitation> mq() {
        return new ArrayList(this.acE);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        InvitationClusterCreator.m4012a(this, parcel, i);
    }
}
