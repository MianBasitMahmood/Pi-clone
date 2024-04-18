package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder implements SafeParcelable {
    public static final Creator<SortOrder> CREATOR;
    final int CK;
    final List<FieldWithSortOrder> Sf;
    final boolean Sg;

    public static class Builder {
        private final List<FieldWithSortOrder> Sf;
        private boolean Sg;

        public Builder() {
            this.Sf = new ArrayList();
            this.Sg = false;
        }

        public Builder addSortAscending(SortableMetadataField sortableMetadataField) {
            this.Sf.add(new FieldWithSortOrder(sortableMetadataField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortableMetadataField) {
            this.Sf.add(new FieldWithSortOrder(sortableMetadataField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(this.Sg, null);
        }
    }

    static {
        CREATOR = new C0671b();
    }

    SortOrder(int i, List<FieldWithSortOrder> list, boolean z) {
        this.CK = i;
        this.Sf = list;
        this.Sg = z;
    }

    private SortOrder(List<FieldWithSortOrder> list, boolean z) {
        this(1, (List) list, z);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.Sf), Boolean.valueOf(this.Sg)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0671b.m2399a(this, parcel, i);
    }
}
