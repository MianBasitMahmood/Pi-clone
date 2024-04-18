package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPropertyKey implements SafeParcelable {
    public static final Creator<CustomPropertyKey> CREATOR;
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;
    private static final Pattern Rc;
    final int CK;
    final String KP;
    final int mVisibility;

    static {
        CREATOR = new C0652c();
        Rc = Pattern.compile("[\\w.!@$%^&*()/-]+");
    }

    CustomPropertyKey(int i, String str, int i2) {
        boolean z = true;
        jx.m5219b((Object) str, (Object) "key");
        jx.m5221b(Rc.matcher(str).matches(), (Object) "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        if (!(i2 == 0 || i2 == PRIVATE)) {
            z = false;
        }
        jx.m5221b(z, (Object) "visibility must be either PUBLIC or PRIVATE");
        this.CK = i;
        this.KP = str;
        this.mVisibility = i2;
    }

    public CustomPropertyKey(String str, int i) {
        this(PRIVATE, str, i);
    }

    public static CustomPropertyKey fromJson(JSONObject jSONObject) throws JSONException {
        return new CustomPropertyKey(jSONObject.getString("key"), jSONObject.getInt("visibility"));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPropertyKey)) {
            return false;
        }
        CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
        return customPropertyKey.getKey().equals(this.KP) && customPropertyKey.getVisibility() == this.mVisibility;
    }

    public String getKey() {
        return this.KP;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int hashCode() {
        return (this.KP + this.mVisibility).hashCode();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", getKey());
        jSONObject.put("visibility", getVisibility());
        return jSONObject;
    }

    public String toString() {
        return "CustomPropertyKey(" + this.KP + "," + this.mVisibility + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0652c.m2339a(this, parcel, i);
    }
}
