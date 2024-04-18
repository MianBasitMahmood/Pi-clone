package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.DataBuffer;

public class DeviceFeatureBuffer extends DataBuffer<DeviceFeature> {
    public DeviceFeature get(int i) {
        return new C0544a(this.JG, i);
    }
}
