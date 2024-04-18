package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C0665j;
import java.util.Arrays;
import java.util.Collections;

public class lo extends C0665j<AppVisibleCustomProperties> {
    public lo(int i) {
        super("customProperties", Collections.singleton("customProperties"), Arrays.asList(new String[]{"customPropertiesExtra"}), i);
    }

    protected /* synthetic */ Object m5338c(DataHolder dataHolder, int i, int i2) {
        return m5339l(dataHolder, i, i2);
    }

    protected AppVisibleCustomProperties m5339l(DataHolder dataHolder, int i, int i2) {
        return (AppVisibleCustomProperties) dataHolder.gV().getSparseParcelableArray("customPropertiesExtra").get(i, AppVisibleCustomProperties.Rd);
    }
}
