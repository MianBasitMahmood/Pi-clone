package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR;
    private final int CK;
    private final Uri LU;
    private final int li;
    private final int lj;

    static {
        CREATOR = new C0539b();
    }

    WebImage(int i, Uri uri, int i2, int i3) {
        this.CK = i;
        this.LU = uri;
        this.li = i2;
        this.lj = i3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(m1900d(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri m1900d(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            try {
                uri = Uri.parse(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return jv.equal(this.LU, webImage.LU) && this.li == webImage.li && this.lj == webImage.lj;
    }

    public final int getHeight() {
        return this.lj;
    }

    public final Uri getUrl() {
        return this.LU;
    }

    final int getVersionCode() {
        return this.CK;
    }

    public final int getWidth() {
        return this.li;
    }

    public final int hashCode() {
        return jv.hashCode(this.LU, Integer.valueOf(this.li), Integer.valueOf(this.lj));
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, this.LU.toString());
            jSONObject.put("width", this.li);
            jSONObject.put("height", this.lj);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.li), Integer.valueOf(this.lj), this.LU.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C0539b.m1912a(this, parcel, i);
    }
}
