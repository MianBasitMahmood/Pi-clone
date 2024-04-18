package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends C0527g<AppContentSection> {
    private final ArrayList<DataHolder> XX;

    protected final /* synthetic */ Object m2856f(int i, int i2) {
        return m2857h(i, i2);
    }

    protected final AppContentSection m2857h(int i, int i2) {
        return new AppContentSectionRef(this.XX, i, i2);
    }

    protected final String ha() {
        return "section_id";
    }

    protected final String hc() {
        return "card_id";
    }

    public final void release() {
        super.release();
        int size = this.XX.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = (DataHolder) this.XX.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }
}
