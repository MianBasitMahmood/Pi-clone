package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.ix;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    private static final String[] Gc;
    private static final C0468a Gd;
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private final List<WebImage> Fp;
    private final Bundle Ge;
    private int Gf;

    /* renamed from: com.google.android.gms.cast.MediaMetadata.a */
    private static class C0468a {
        private final Map<String, String> Gg;
        private final Map<String, String> Gh;
        private final Map<String, Integer> Gi;

        public C0468a() {
            this.Gg = new HashMap();
            this.Gh = new HashMap();
            this.Gi = new HashMap();
        }

        public C0468a m1695a(String str, String str2, int i) {
            this.Gg.put(str, str2);
            this.Gh.put(str2, str);
            this.Gi.put(str, Integer.valueOf(i));
            return this;
        }

        public String aA(String str) {
            return (String) this.Gh.get(str);
        }

        public int aB(String str) {
            Integer num = (Integer) this.Gi.get(str);
            return num != null ? num.intValue() : MediaMetadata.MEDIA_TYPE_GENERIC;
        }

        public String az(String str) {
            return (String) this.Gg.get(str);
        }
    }

    static {
        Gc = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
        Gd = new C0468a().m1695a(KEY_CREATION_DATE, "creationDateTime", MEDIA_TYPE_PHOTO).m1695a(KEY_RELEASE_DATE, "releaseDate", MEDIA_TYPE_PHOTO).m1695a(KEY_BROADCAST_DATE, "originalAirdate", MEDIA_TYPE_PHOTO).m1695a(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, MEDIA_TYPE_MOVIE).m1695a(KEY_SUBTITLE, "subtitle", MEDIA_TYPE_MOVIE).m1695a(KEY_ARTIST, "artist", MEDIA_TYPE_MOVIE).m1695a(KEY_ALBUM_ARTIST, "albumArtist", MEDIA_TYPE_MOVIE).m1695a(KEY_ALBUM_TITLE, "albumName", MEDIA_TYPE_MOVIE).m1695a(KEY_COMPOSER, "composer", MEDIA_TYPE_MOVIE).m1695a(KEY_DISC_NUMBER, "discNumber", MEDIA_TYPE_TV_SHOW).m1695a(KEY_TRACK_NUMBER, "trackNumber", MEDIA_TYPE_TV_SHOW).m1695a(KEY_SEASON_NUMBER, "season", MEDIA_TYPE_TV_SHOW).m1695a(KEY_EPISODE_NUMBER, "episode", MEDIA_TYPE_TV_SHOW).m1695a(KEY_SERIES_TITLE, "seriesTitle", MEDIA_TYPE_MOVIE).m1695a(KEY_STUDIO, "studio", MEDIA_TYPE_MOVIE).m1695a(KEY_WIDTH, "width", MEDIA_TYPE_TV_SHOW).m1695a(KEY_HEIGHT, "height", MEDIA_TYPE_TV_SHOW).m1695a(KEY_LOCATION_NAME, "location", MEDIA_TYPE_MOVIE).m1695a(KEY_LOCATION_LATITUDE, "latitude", MEDIA_TYPE_MUSIC_TRACK).m1695a(KEY_LOCATION_LONGITUDE, "longitude", MEDIA_TYPE_MUSIC_TRACK);
    }

    public MediaMetadata() {
        this(MEDIA_TYPE_GENERIC);
    }

    public MediaMetadata(int i) {
        this.Fp = new ArrayList();
        this.Ge = new Bundle();
        this.Gf = i;
    }

    private void m1696a(JSONObject jSONObject, String... strArr) {
        try {
            int length = strArr.length;
            for (int i = MEDIA_TYPE_GENERIC; i < length; i += MEDIA_TYPE_MOVIE) {
                String str = strArr[i];
                if (this.Ge.containsKey(str)) {
                    switch (Gd.aB(str)) {
                        case MEDIA_TYPE_MOVIE /*1*/:
                        case MEDIA_TYPE_PHOTO /*4*/:
                            jSONObject.put(Gd.az(str), this.Ge.getString(str));
                            break;
                        case MEDIA_TYPE_TV_SHOW /*2*/:
                            jSONObject.put(Gd.az(str), this.Ge.getInt(str));
                            break;
                        case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                            jSONObject.put(Gd.az(str), this.Ge.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.Ge.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.Ge.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private boolean m1697a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !m1697a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void m1698b(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String aA = Gd.aA(str);
                    if (aA == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.Ge.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.Ge.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.Ge.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(aA)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (Gd.aB(aA)) {
                                    case MEDIA_TYPE_MOVIE /*1*/:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.Ge.putString(aA, (String) obj2);
                                        break;
                                    case MEDIA_TYPE_TV_SHOW /*2*/:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.Ge.putInt(aA, ((Integer) obj2).intValue());
                                        break;
                                    case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.Ge.putDouble(aA, ((Double) obj2).doubleValue());
                                        break;
                                    case MEDIA_TYPE_PHOTO /*4*/:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        if (ix.aL((String) obj2) == null) {
                                            break;
                                        }
                                        this.Ge.putString(aA, (String) obj2);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private void m1699f(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int aB = Gd.aB(str);
        if (aB != i && aB != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + Gc[i]);
        }
    }

    public void addImage(WebImage webImage) {
        this.Fp.add(webImage);
    }

    public void m1700c(JSONObject jSONObject) {
        clear();
        this.Gf = MEDIA_TYPE_GENERIC;
        try {
            this.Gf = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        ix.m5060a(this.Fp, jSONObject);
        String[] strArr;
        switch (this.Gf) {
            case MEDIA_TYPE_GENERIC /*0*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_ARTIST;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                m1698b(jSONObject, strArr);
            case MEDIA_TYPE_MOVIE /*1*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_STUDIO;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                m1698b(jSONObject, strArr);
            case MEDIA_TYPE_TV_SHOW /*2*/:
                m1698b(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
            case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                m1698b(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
            case MEDIA_TYPE_PHOTO /*4*/:
                m1698b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
            default:
                m1698b(jSONObject, new String[MEDIA_TYPE_GENERIC]);
        }
    }

    public void clear() {
        this.Ge.clear();
        this.Fp.clear();
    }

    public void clearImages() {
        this.Fp.clear();
    }

    public boolean containsKey(String str) {
        return this.Ge.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return m1697a(this.Ge, mediaMetadata.Ge) && this.Fp.equals(mediaMetadata.Fp);
    }

    public Calendar getDate(String str) {
        m1699f(str, MEDIA_TYPE_PHOTO);
        String string = this.Ge.getString(str);
        return string != null ? ix.aL(string) : null;
    }

    public String getDateAsString(String str) {
        m1699f(str, MEDIA_TYPE_PHOTO);
        return this.Ge.getString(str);
    }

    public double getDouble(String str) {
        m1699f(str, MEDIA_TYPE_MUSIC_TRACK);
        return this.Ge.getDouble(str);
    }

    public List<WebImage> getImages() {
        return this.Fp;
    }

    public int getInt(String str) {
        m1699f(str, MEDIA_TYPE_TV_SHOW);
        return this.Ge.getInt(str);
    }

    public int getMediaType() {
        return this.Gf;
    }

    public String getString(String str) {
        m1699f(str, MEDIA_TYPE_MOVIE);
        return this.Ge.getString(str);
    }

    public boolean hasImages() {
        return (this.Fp == null || this.Fp.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.Ge.keySet()) {
            i *= 31;
            i = this.Ge.get(str).hashCode() + i;
        }
        return (i * 31) + this.Fp.hashCode();
    }

    public Set<String> keySet() {
        return this.Ge.keySet();
    }

    public void putDate(String str, Calendar calendar) {
        m1699f(str, MEDIA_TYPE_PHOTO);
        this.Ge.putString(str, ix.m5059a(calendar));
    }

    public void putDouble(String str, double d) {
        m1699f(str, MEDIA_TYPE_MUSIC_TRACK);
        this.Ge.putDouble(str, d);
    }

    public void putInt(String str, int i) {
        m1699f(str, MEDIA_TYPE_TV_SHOW);
        this.Ge.putInt(str, i);
    }

    public void putString(String str, String str2) {
        m1699f(str, MEDIA_TYPE_MOVIE);
        this.Ge.putString(str, str2);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.Gf);
        } catch (JSONException e) {
        }
        ix.m5061a(jSONObject, this.Fp);
        String[] strArr;
        switch (this.Gf) {
            case MEDIA_TYPE_GENERIC /*0*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_ARTIST;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                m1696a(jSONObject, strArr);
                break;
            case MEDIA_TYPE_MOVIE /*1*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_STUDIO;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                m1696a(jSONObject, strArr);
                break;
            case MEDIA_TYPE_TV_SHOW /*2*/:
                m1696a(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                m1696a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case MEDIA_TYPE_PHOTO /*4*/:
                m1696a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                m1696a(jSONObject, new String[MEDIA_TYPE_GENERIC]);
                break;
        }
        return jSONObject;
    }
}
