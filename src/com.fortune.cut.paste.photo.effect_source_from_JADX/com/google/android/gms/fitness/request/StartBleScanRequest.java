package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.C0801l.C0802a;
import com.google.android.gms.fitness.request.C0803a.C0800a;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.la;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR;
    private final int CK;
    private final List<DataType> TY;
    private final C0801l Wm;
    private final int Wn;

    public static class Builder {
        private DataType[] VU;
        private C0801l Wm;
        private int Wn;

        public Builder() {
            this.VU = new DataType[0];
            this.Wn = 10;
        }

        public Builder m2733a(C0801l c0801l) {
            this.Wm = c0801l;
            return this;
        }

        public StartBleScanRequest build() {
            jx.m5217a(this.Wm != null, "Must set BleScanCallback");
            return new StartBleScanRequest();
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            m2733a(C0800a.jP().m2734a(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.VU = dataTypeArr;
            return this;
        }

        public Builder setTimeoutSecs(int i) {
            boolean z = true;
            jx.m5221b(i > 0, (Object) "Stop time must be greater than zero");
            if (i > 60) {
                z = false;
            }
            jx.m5221b(z, (Object) "Stop time must be less than 1 minute");
            this.Wn = i;
            return this;
        }
    }

    static {
        CREATOR = new ac();
    }

    StartBleScanRequest(int i, List<DataType> list, IBinder iBinder, int i2) {
        this.CK = i;
        this.TY = list;
        this.Wm = C0802a.aB(iBinder);
        this.Wn = i2;
    }

    private StartBleScanRequest(Builder builder) {
        this.CK = 2;
        this.TY = la.m5319b(builder.VU);
        this.Wm = builder.Wm;
        this.Wn = builder.Wn;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.TY);
    }

    public int getTimeoutSecs() {
        return this.Wn;
    }

    int getVersionCode() {
        return this.CK;
    }

    public IBinder km() {
        return this.Wm.asBinder();
    }

    public String toString() {
        return jv.m5212h(this).m5211a("dataTypes", this.TY).m5211a("timeoutSecs", Integer.valueOf(this.Wn)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ac.m2738a(this, parcel, i);
    }
}
