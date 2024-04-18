package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0543c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;
import com.google.android.gms.wallet.fragment.WalletFragmentState;

public class DataSource implements SafeParcelable {
    public static final Creator<DataSource> CREATOR;
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final int CK;
    private final int Gt;
    private final DataType TM;
    private final Device Ul;
    private final C0766a Um;
    private final String Un;
    private final boolean Uo;
    private final String Up;
    private final String mName;

    public static final class Builder {
        private int Gt;
        private DataType TM;
        private Device Ul;
        private C0766a Um;
        private String Un;
        private boolean Uo;
        private String mName;

        public Builder() {
            this.Gt = -1;
            this.Un = "";
            this.Uo = false;
        }

        public final DataSource build() {
            boolean z = true;
            jx.m5217a(this.TM != null, "Must set data type");
            if (this.Gt < 0) {
                z = false;
            }
            jx.m5217a(z, "Must set data source type");
            return new DataSource();
        }

        public final Builder setAppPackageName(Context context) {
            return setAppPackageName(context.getPackageName());
        }

        public final Builder setAppPackageName(String str) {
            this.Um = new C0766a(str, null, null);
            return this;
        }

        public final Builder setDataType(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public final Builder setDevice(Device device) {
            this.Ul = device;
            return this;
        }

        public final Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public final Builder setObfuscated(boolean z) {
            this.Uo = z;
            return this;
        }

        public final Builder setStreamName(String str) {
            jx.m5221b(str != null, (Object) "Must specify a valid stream name");
            this.Un = str;
            return this;
        }

        public final Builder setType(int i) {
            this.Gt = i;
            return this;
        }
    }

    static {
        CREATOR = new C0772g();
    }

    DataSource(int i, DataType dataType, String str, int i2, Device device, C0766a c0766a, String str2, boolean z) {
        this.CK = i;
        this.TM = dataType;
        this.Gt = i2;
        this.mName = str;
        this.Ul = device;
        this.Um = c0766a;
        this.Un = str2;
        this.Uo = z;
        this.Up = jy();
    }

    private DataSource(Builder builder) {
        this.CK = 3;
        this.TM = builder.TM;
        this.Gt = builder.Gt;
        this.mName = builder.mName;
        this.Ul = builder.Ul;
        this.Um = builder.Um;
        this.Un = builder.Un;
        this.Uo = builder.Uo;
        this.Up = jy();
    }

    private boolean m2623a(DataSource dataSource) {
        return this.Up.equals(dataSource.Up);
    }

    public static DataSource extract(Intent intent) {
        return intent == null ? null : (DataSource) C0543c.m1983a(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.Gt) {
            case WalletFragmentState.UNKNOWN /*0*/:
                return "raw";
            case TYPE_DERIVED /*1*/:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    private String jy() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTypeString());
        stringBuilder.append(":").append(this.TM.getName());
        if (this.Um != null) {
            stringBuilder.append(":").append(this.Um.getPackageName());
        }
        if (this.Ul != null) {
            stringBuilder.append(":").append(this.Ul.getStreamIdentifier());
        }
        if (this.Un != null) {
            stringBuilder.append(":").append(this.Un);
        }
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSource) && m2623a((DataSource) obj));
    }

    public String getAppPackageName() {
        return this.Um == null ? null : this.Um.getPackageName();
    }

    public DataType getDataType() {
        return this.TM;
    }

    public Device getDevice() {
        return this.Ul;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.Up;
    }

    public String getStreamName() {
        return this.Un;
    }

    public int getType() {
        return this.Gt;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return this.Up.hashCode();
    }

    public DataSource jA() {
        return new DataSource(3, this.TM, this.mName, this.Gt, this.Ul == null ? null : this.Ul.jE(), this.Um == null ? null : this.Um.jl(), mg.bw(this.Un), this.Uo);
    }

    public C0766a jx() {
        return this.Um;
    }

    public boolean jz() {
        return this.Uo;
    }

    public String toDebugString() {
        StringBuilder append = new StringBuilder().append(this.Gt == 0 ? "r" : "d").append(":").append(this.TM.jB());
        String str = this.Um == null ? "" : this.Um.equals(C0766a.TT) ? ":gms" : ":" + this.Um.getPackageName();
        return append.append(str).append(this.Ul != null ? ":" + this.Ul.getModel() + ":" + this.Ul.getUid() : "").append(this.Un != null ? ":" + this.Un : "").toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(getTypeString());
        if (this.mName != null) {
            stringBuilder.append(":").append(this.mName);
        }
        if (this.Um != null) {
            stringBuilder.append(":").append(this.Um);
        }
        if (this.Ul != null) {
            stringBuilder.append(":").append(this.Ul);
        }
        if (this.Un != null) {
            stringBuilder.append(":").append(this.Un);
        }
        stringBuilder.append(":").append(this.TM);
        return stringBuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0772g.m2658a(mg.m5416c(this), parcel, i);
    }
}
