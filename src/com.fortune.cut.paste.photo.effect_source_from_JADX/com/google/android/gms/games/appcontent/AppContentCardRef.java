package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 0, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return AppContentCardEntity.m2849a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return kS();
    }

    public final List<AppContentAction> getActions() {
        return AppContentUtils.m2871a(this.JG, this.XX, "card_actions", this.KZ);
    }

    public final String getDescription() {
        return getString("card_description");
    }

    public final Uri getIconImageUri() {
        return aR("card_icon_image_uri");
    }

    public final String getTitle() {
        return getString("card_title");
    }

    public final String getType() {
        return getString("card_type");
    }

    public final int hashCode() {
        return AppContentCardEntity.m2848a(this);
    }

    public final List<AppContentCondition> kH() {
        return AppContentUtils.m2874c(this.JG, this.XX, "card_conditions", this.KZ);
    }

    public final String kI() {
        return getString("card_content_description");
    }

    public final Uri kL() {
        return aR("card_image_uri");
    }

    public final List<AppContentAnnotation> kN() {
        return AppContentUtils.m2873b(this.JG, this.XX, "card_annotations", this.KZ);
    }

    public final int kO() {
        return getInteger("card_current_steps");
    }

    public final Bundle kP() {
        return AppContentUtils.m2875d(this.JG, this.XX, "card_data", this.KZ);
    }

    public final String kQ() {
        return getString("card_subtitle");
    }

    public final int kR() {
        return getInteger("card_total_steps");
    }

    public final AppContentCard kS() {
        return new AppContentCardEntity(this);
    }

    public final String toString() {
        return AppContentCardEntity.m2850b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentCardEntity) kS()).writeToParcel(parcel, i);
    }
}
