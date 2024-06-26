package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.internal.ql;
import com.google.android.gms.internal.ql.C1471a;
import com.google.android.gms.internal.qm;
import com.google.android.gms.internal.qv;
import java.util.ArrayList;
import java.util.List;

public class DataMapItem {
    private final DataMap axh;
    private final Uri mUri;

    private DataMapItem(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.axh = m6819a((DataItem) dataItem.freeze());
    }

    private DataMap m6819a(DataItem dataItem) {
        if (dataItem.getData() == null && dataItem.getAssets().size() > 0) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        } else if (dataItem.getData() == null) {
            return new DataMap();
        } else {
            try {
                List arrayList = new ArrayList();
                int size = dataItem.getAssets().size();
                for (int i = 0; i < size; i++) {
                    DataItemAsset dataItemAsset = (DataItemAsset) dataItem.getAssets().get(Integer.toString(i));
                    if (dataItemAsset == null) {
                        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + dataItem);
                    }
                    arrayList.add(Asset.createFromRef(dataItemAsset.getId()));
                }
                return ql.m5908a(new C1471a(qm.m5924n(dataItem.getData()), arrayList));
            } catch (qv e) {
                throw new IllegalStateException("Unable to parse. Not a DataItem.");
            }
        }
    }

    public static DataMapItem fromDataItem(DataItem dataItem) {
        if (dataItem != null) {
            return new DataMapItem(dataItem);
        }
        throw new IllegalStateException("provided dataItem is null");
    }

    public DataMap getDataMap() {
        return this.axh;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
