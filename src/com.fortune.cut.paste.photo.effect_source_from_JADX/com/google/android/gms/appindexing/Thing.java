package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.jx;
import com.google.android.gms.plus.PlusShare;

public class Thing {
    final Bundle DI;

    public static class Builder {
        final Bundle DJ;

        public Builder() {
            this.DJ = new Bundle();
        }

        public Thing build() {
            return new Thing(this.DJ);
        }

        public Builder put(String str, Thing thing) {
            jx.m5223i(str);
            if (thing != null) {
                this.DJ.putParcelable(str, thing.DI);
            }
            return this;
        }

        public Builder put(String str, String str2) {
            jx.m5223i(str);
            if (str2 != null) {
                this.DJ.putString(str, str2);
            }
            return this;
        }

        public Builder setDescription(String str) {
            put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str);
            return this;
        }

        public Builder setId(String str) {
            if (str != null) {
                put("id", str);
            }
            return this;
        }

        public Builder setName(String str) {
            jx.m5223i(str);
            put("name", str);
            return this;
        }

        public Builder setType(String str) {
            put("type", str);
            return this;
        }

        public Builder setUrl(Uri uri) {
            jx.m5223i(uri);
            put(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            return this;
        }
    }

    Thing(Bundle bundle) {
        this.DI = bundle;
    }

    public Bundle fI() {
        return this.DI;
    }
}
