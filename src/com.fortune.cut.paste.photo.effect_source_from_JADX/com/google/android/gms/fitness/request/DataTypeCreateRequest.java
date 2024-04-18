package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Creator<DataTypeCreateRequest> CREATOR;
    private final int CK;
    private final List<Field> Uv;
    private final String mName;

    public static class Builder {
        private List<Field> Uv;
        private String mName;

        public Builder() {
            this.Uv = new ArrayList();
        }

        public Builder addField(Field field) {
            if (!this.Uv.contains(field)) {
                this.Uv.add(field);
            }
            return this;
        }

        public Builder addField(String str, int i) {
            boolean z = (str == null && str.isEmpty()) ? false : true;
            jx.m5221b(z, (Object) "Invalid name specified");
            return addField(new Field(str, i));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            jx.m5217a(this.mName != null, "Must set the name");
            if (this.Uv.isEmpty()) {
                z = false;
            }
            jx.m5217a(z, "Must specify the data fields");
            return new DataTypeCreateRequest();
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }
    }

    static {
        CREATOR = new C0817i();
    }

    DataTypeCreateRequest(int i, String str, List<Field> list) {
        this.CK = i;
        this.mName = str;
        this.Uv = Collections.unmodifiableList(list);
    }

    private DataTypeCreateRequest(Builder builder) {
        this.CK = 1;
        this.mName = builder.mName;
        this.Uv = Collections.unmodifiableList(builder.Uv);
    }

    private boolean m2703a(DataTypeCreateRequest dataTypeCreateRequest) {
        return jv.equal(this.mName, dataTypeCreateRequest.mName) && jv.equal(this.Uv, dataTypeCreateRequest.Uv);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeCreateRequest) && m2703a((DataTypeCreateRequest) obj));
    }

    public List<Field> getFields() {
        return this.Uv;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName, this.Uv);
    }

    public String toString() {
        return jv.m5212h(this).m5211a("name", this.mName).m5211a("fields", this.Uv).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0817i.m2759a(this, parcel, i);
    }
}
