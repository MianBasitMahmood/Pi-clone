package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.deviceconnection.features.a */
public final class C0544a extends C0451d implements DeviceFeature {
    public C0544a(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final String getFeatureName() {
        return getString("feature_name");
    }

    public final long getLastConnectionTimestampMillis() {
        return getLong("last_connection_timestamp");
    }

    public final String toString() {
        return jv.m5212h(this).m5211a("FeatureName", getFeatureName()).m5211a("Timestamp", Long.valueOf(getLastConnectionTimestampMillis())).toString();
    }
}
