package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR;
    private final int CK;
    private boolean FQ;
    private String FR;

    public static final class Builder {
        private LaunchOptions FS;

        public Builder() {
            this.FS = new LaunchOptions();
        }

        public final LaunchOptions build() {
            return this.FS;
        }

        public final Builder setLocale(Locale locale) {
            this.FS.setLanguage(in.m5029b(locale));
            return this;
        }

        public final Builder setRelaunchIfRunning(boolean z) {
            this.FS.setRelaunchIfRunning(z);
            return this;
        }
    }

    static {
        CREATOR = new C0486c();
    }

    public LaunchOptions() {
        this(1, false, in.m5029b(Locale.getDefault()));
    }

    LaunchOptions(int i, boolean z, String str) {
        this.CK = i;
        this.FQ = z;
        this.FR = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.FQ == launchOptions.FQ && in.m5027a(this.FR, launchOptions.FR);
    }

    public String getLanguage() {
        return this.FR;
    }

    public boolean getRelaunchIfRunning() {
        return this.FQ;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Boolean.valueOf(this.FQ), this.FR);
    }

    public void setLanguage(String str) {
        this.FR = str;
    }

    public void setRelaunchIfRunning(boolean z) {
        this.FQ = z;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.FQ), this.FR});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0486c.m1765a(this, parcel, i);
    }
}
