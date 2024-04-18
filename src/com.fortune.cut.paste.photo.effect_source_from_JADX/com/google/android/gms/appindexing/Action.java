package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.jx;
import com.google.android.gms.plus.PlusShare;

public final class Action extends Thing {
    public static final String TYPE_ADD = "http://schema.org/AddAction";
    public static final String TYPE_BOOKMARK = "http://schema.org/BookmarkAction";
    public static final String TYPE_LIKE = "http://schema.org/LikeAction";
    public static final String TYPE_LISTEN = "http://schema.org/ListenAction";
    public static final String TYPE_VIEW = "http://schema.org/ViewAction";
    public static final String TYPE_WANT = "http://schema.org/WantAction";
    public static final String TYPE_WATCH = "http://schema.org/WatchAction";

    public static final class Builder extends com.google.android.gms.appindexing.Thing.Builder {
        public Builder(String str) {
            jx.m5223i(str);
            super.put("type", str);
        }

        public final Action build() {
            jx.m5219b(this.DJ.get("object"), (Object) "setObject is required before calling build().");
            jx.m5219b(this.DJ.get("type"), (Object) "setType is required before calling build().");
            Bundle bundle = (Bundle) this.DJ.getParcelable("object");
            jx.m5219b(bundle.get("name"), (Object) "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            jx.m5219b(bundle.get(PlusShare.KEY_CALL_TO_ACTION_URL), (Object) "Must call setObject() with a valid app url. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            return new Action(null);
        }

        public final Builder put(String str, Thing thing) {
            return (Builder) super.put(str, thing);
        }

        public final Builder put(String str, String str2) {
            return (Builder) super.put(str, str2);
        }

        public final Builder setName(String str) {
            return (Builder) super.put("name", str);
        }

        public final Builder setObject(Thing thing) {
            jx.m5223i(thing);
            return (Builder) super.put("object", thing);
        }

        public final Builder setUrl(Uri uri) {
            if (uri != null) {
                super.put(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            }
            return this;
        }
    }

    private Action(Bundle bundle) {
        super(bundle);
    }

    public static Action newAction(String str, String str2, Uri uri) {
        return newAction(str, str2, null, uri);
    }

    public static Action newAction(String str, String str2, Uri uri, Uri uri2) {
        return new Builder(str).setObject(new com.google.android.gms.appindexing.Thing.Builder().setName(str2).setId(uri == null ? null : uri.toString()).setUrl(uri2).build()).build();
    }
}
