package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0433b;
import com.google.android.gms.common.api.Status;

public class bg extends C0577c {
    private final C0433b<Status> Ea;

    public bg(C0433b<Status> c0433b) {
        this.Ea = c0433b;
    }

    public void m2196n(Status status) throws RemoteException {
        this.Ea.m1609b(status);
    }

    public void onSuccess() throws RemoteException {
        this.Ea.m1609b(Status.Kw);
    }
}
