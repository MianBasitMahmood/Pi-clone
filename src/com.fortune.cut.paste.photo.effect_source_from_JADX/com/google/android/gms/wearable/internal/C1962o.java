package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.wearable.internal.o */
public final class C1962o extends C0451d implements DataItem {
    private final int Ya;

    public C1962o(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.Ya = i2;
    }

    public final /* synthetic */ Object freeze() {
        return rp();
    }

    public final Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            C1958k c1958k = new C1958k(this.JG, this.KZ + i);
            if (c1958k.getDataItemKey() != null) {
                hashMap.put(c1958k.getDataItemKey(), c1958k);
            }
        }
        return hashMap;
    }

    public final byte[] getData() {
        return getByteArray("data");
    }

    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public final DataItem rp() {
        return new C1959l(this);
    }

    public final DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
