package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.d */
public class C0562d {
    public static boolean m2022a(int i, DriveId driveId) {
        return driveId != null || C0562d.bi(i);
    }

    public static boolean bi(int i) {
        return (2 & ((long) (1 << i))) != 0;
    }
}
