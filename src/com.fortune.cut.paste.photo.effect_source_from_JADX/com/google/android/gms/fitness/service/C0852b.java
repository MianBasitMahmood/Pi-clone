package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.C0776k;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.internal.jx;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.service.b */
class C0852b implements SensorEventDispatcher {
    private final C0776k VW;

    C0852b(C0776k c0776k) {
        this.VW = (C0776k) jx.m5223i(c0776k);
    }

    public void publish(DataPoint dataPoint) throws RemoteException {
        this.VW.m2662c(dataPoint);
    }

    public void publish(List<DataPoint> list) throws RemoteException {
        for (DataPoint publish : list) {
            publish(publish);
        }
    }
}
