package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    private final Date f1071d;
    private final Gender f1072e;
    private final Set<String> f1073f;
    private final boolean f1074g;
    private final Location f1075h;

    public MediationAdRequest(Date date, Gender gender, Set<String> set, boolean z, Location location) {
        this.f1071d = date;
        this.f1072e = gender;
        this.f1073f = set;
        this.f1074g = z;
        this.f1075h = location;
    }

    public final Integer getAgeInYears() {
        if (this.f1071d == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f1071d);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public final Date getBirthday() {
        return this.f1071d;
    }

    public final Gender getGender() {
        return this.f1072e;
    }

    public final Set<String> getKeywords() {
        return this.f1073f;
    }

    public final Location getLocation() {
        return this.f1075h;
    }

    public final boolean isTesting() {
        return this.f1074g;
    }
}
