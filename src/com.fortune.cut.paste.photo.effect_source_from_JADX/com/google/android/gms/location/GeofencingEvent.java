package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.nn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent {
    private final int agl;
    private final List<Geofence> agm;
    private final Location agn;
    private final int tq;

    private GeofencingEvent(int i, int i2, List<Geofence> list, Location location) {
        this.tq = i;
        this.agl = i2;
        this.agm = list;
        this.agn = location;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        return intent == null ? null : new GeofencingEvent(intent.getIntExtra("gms_error_code", -1), m6085k(intent), m6086l(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int m6085k(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        return intExtra == -1 ? -1 : (intExtra == 1 || intExtra == 2 || intExtra == 4) ? intExtra : -1;
    }

    private static List<Geofence> m6086l(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(nn.m5677h((byte[]) it.next()));
        }
        return arrayList2;
    }

    public int getErrorCode() {
        return this.tq;
    }

    public int getGeofenceTransition() {
        return this.agl;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.agm;
    }

    public Location getTriggeringLocation() {
        return this.agn;
    }

    public boolean hasError() {
        return this.tq != -1;
    }
}
