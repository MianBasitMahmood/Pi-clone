package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.nn;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR;
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int CK;
    private final List<nn> ago;
    private final int agp;

    public static final class Builder {
        private final List<nn> ago;
        private int agp;

        public Builder() {
            this.ago = new ArrayList();
            this.agp = 5;
        }

        public static int ew(int i) {
            return i & 7;
        }

        public final Builder addGeofence(Geofence geofence) {
            jx.m5219b((Object) geofence, (Object) "geofence can't be null.");
            jx.m5221b(geofence instanceof nn, (Object) "Geofence must be created using Geofence.Builder.");
            this.ago.add((nn) geofence);
            return this;
        }

        public final Builder addGeofences(List<Geofence> list) {
            if (!(list == null || list.isEmpty())) {
                for (Geofence geofence : list) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public final GeofencingRequest build() {
            jx.m5221b(!this.ago.isEmpty(), (Object) "No geofence has been added to this request.");
            return new GeofencingRequest(this.agp, null);
        }

        public final Builder setInitialTrigger(int i) {
            this.agp = ew(i);
            return this;
        }
    }

    static {
        CREATOR = new C1505a();
    }

    GeofencingRequest(int i, List<nn> list, int i2) {
        this.CK = i;
        this.ago = list;
        this.agp = i2;
    }

    private GeofencingRequest(List<nn> list, int i) {
        this((int) INITIAL_TRIGGER_ENTER, (List) list, i);
    }

    public int describeContents() {
        return 0;
    }

    public List<Geofence> getGeofences() {
        List<Geofence> arrayList = new ArrayList();
        arrayList.addAll(this.ago);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.agp;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public List<nn> ng() {
        return this.ago;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1505a.m6092a(this, parcel, i);
    }
}
