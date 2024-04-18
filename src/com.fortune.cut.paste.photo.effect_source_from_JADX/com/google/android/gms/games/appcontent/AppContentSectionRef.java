package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int Ya;

    AppContentSectionRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super(arrayList, 0, i);
        this.Ya = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return AppContentSectionEntity.m2859a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return la();
    }

    public final /* synthetic */ List getActions() {
        return lb();
    }

    public final String getTitle() {
        return getString("section_title");
    }

    public final String getType() {
        return getString("section_type");
    }

    public final int hashCode() {
        return AppContentSectionEntity.m2858a(this);
    }

    public final String kI() {
        return getString("section_content_description");
    }

    public final Bundle kP() {
        return AppContentUtils.m2875d(this.JG, this.XX, "section_data", this.KZ);
    }

    public final String kQ() {
        return getString("section_subtitle");
    }

    public final Uri kY() {
        return aR("section_background_image_uri");
    }

    public final /* synthetic */ List kZ() {
        return lc();
    }

    public final AppContentSection la() {
        return new AppContentSectionEntity(this);
    }

    public final ArrayList<AppContentAction> lb() {
        return AppContentUtils.m2871a(this.JG, this.XX, "section_actions", this.KZ);
    }

    public final ArrayList<AppContentCard> lc() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new AppContentCardRef(this.XX, this.KZ + i));
        }
        return arrayList;
    }

    public final String toString() {
        return AppContentSectionEntity.m2860b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentSectionEntity) la()).writeToParcel(parcel, i);
    }
}
