package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0657b;
import com.google.android.gms.drive.metadata.internal.C0661f;

public class lr {
    public static final MetadataField<Integer> RW;
    public static final MetadataField<Boolean> RX;

    static {
        RW = new C0661f("contentAvailability", 4300000);
        RX = new C0657b("isPinnable", 4300000);
    }
}
