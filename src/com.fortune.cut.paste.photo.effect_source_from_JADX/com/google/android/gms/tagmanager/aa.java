package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C0997a;
import com.google.android.gms.internal.C1071d.C1070a;
import java.util.Map;

class aa extends aj {
    private static final String ID;

    static {
        ID = C0997a.DEVICE_NAME.toString();
    }

    public aa() {
        super(ID, new String[0]);
    }

    public C1070a m6401B(Map<String, C1070a> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals(FitnessActivities.UNKNOWN))) {
            obj = str + " " + obj;
        }
        return di.m6618u(obj);
    }

    public boolean pe() {
        return true;
    }
}
