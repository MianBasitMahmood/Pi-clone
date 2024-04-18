package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.ae.C1897a;

public class bb extends C1897a {
    private final IntentFilter[] axD;
    private DataListener ayl;
    private MessageListener aym;
    private NodeListener ayn;

    private bb(DataListener dataListener, MessageListener messageListener, NodeListener nodeListener, IntentFilter[] intentFilterArr) {
        this.ayl = dataListener;
        this.aym = messageListener;
        this.ayn = nodeListener;
        this.axD = intentFilterArr;
    }

    public static bb m6997a(NodeListener nodeListener) {
        return new bb(null, null, nodeListener, null);
    }

    public static bb m6998b(DataListener dataListener, IntentFilter[] intentFilterArr) {
        return new bb(dataListener, null, null, intentFilterArr);
    }

    public static bb m6999b(MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return new bb(null, messageListener, null, intentFilterArr);
    }

    public void m7000a(ai aiVar) {
        if (this.aym != null) {
            this.aym.onMessageReceived(aiVar);
        }
    }

    public void m7001a(al alVar) {
        if (this.ayn != null) {
            this.ayn.onPeerConnected(alVar);
        }
    }

    public void aa(DataHolder dataHolder) {
        if (this.ayl != null) {
            try {
                this.ayl.onDataChanged(new DataEventBuffer(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public void m7002b(al alVar) {
        if (this.ayn != null) {
            this.ayn.onPeerDisconnected(alVar);
        }
    }

    public void clear() {
        this.ayl = null;
        this.aym = null;
        this.ayn = null;
    }

    public IntentFilter[] rs() {
        return this.axD;
    }
}
