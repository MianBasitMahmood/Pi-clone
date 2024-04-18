package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@ey
public final class db implements MediationAdRequest {
    private final Date f1132d;
    private final Set<String> f1133f;
    private final boolean f1134g;
    private final Location f1135h;
    private final int ow;
    private final int qU;

    public db(Date date, int i, Set<String> set, Location location, boolean z, int i2) {
        this.f1132d = date;
        this.ow = i;
        this.f1133f = set;
        this.f1135h = location;
        this.f1134g = z;
        this.qU = i2;
    }

    public final Date getBirthday() {
        return this.f1132d;
    }

    public final int getGender() {
        return this.ow;
    }

    public final Set<String> getKeywords() {
        return this.f1133f;
    }

    public final Location getLocation() {
        return this.f1135h;
    }

    public final boolean isTesting() {
        return this.f1134g;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.qU;
    }
}
