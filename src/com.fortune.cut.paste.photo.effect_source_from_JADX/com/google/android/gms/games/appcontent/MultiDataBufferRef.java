package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.C0451d;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class MultiDataBufferRef extends C0451d {
    protected final ArrayList<DataHolder> XX;

    protected MultiDataBufferRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super((DataHolder) arrayList.get(i), i2);
        this.XX = arrayList;
    }
}
