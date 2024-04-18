package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    AppContentAnnotationRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 2, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return AppContentAnnotationEntity.m2845a(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return kM();
    }

    public final String getDescription() {
        return getString("annotation_description");
    }

    public final String getTitle() {
        return getString("annotation_title");
    }

    public final String getType() {
        return getString("annotation_type");
    }

    public final int hashCode() {
        return AppContentAnnotationEntity.m2844a(this);
    }

    public final Uri kL() {
        return aR("annotation_image_uri");
    }

    public final AppContentAnnotation kM() {
        return new AppContentAnnotationEntity(this);
    }

    public final String toString() {
        return AppContentAnnotationEntity.m2846b(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentAnnotationEntity) kM()).writeToParcel(parcel, i);
    }
}
