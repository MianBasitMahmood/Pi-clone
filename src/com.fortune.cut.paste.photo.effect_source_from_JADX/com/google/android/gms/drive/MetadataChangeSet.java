package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.C0655a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet OE;
    private final MetadataBundle OF;

    public static class Builder {
        private final MetadataBundle OF;
        private C0655a OG;

        public Builder() {
            this.OF = MetadataBundle.iZ();
        }

        private int bk(String str) {
            return str == null ? 0 : str.getBytes().length;
        }

        private String m1999i(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        private C0655a iA() {
            if (this.OG == null) {
                this.OG = new C0655a();
            }
            return this.OG;
        }

        private void m2000j(String str, int i, int i2) {
            jx.m5221b(i2 <= i, m1999i(str, i, i2));
        }

        public MetadataChangeSet build() {
            if (this.OG != null) {
                this.OF.m2344b(ln.Rl, this.OG.iW());
            }
            return new MetadataChangeSet(this.OF);
        }

        public Builder deleteCustomProperty(CustomPropertyKey customPropertyKey) {
            jx.m5219b((Object) customPropertyKey, (Object) "key");
            iA().m2340a(customPropertyKey, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey customPropertyKey, String str) {
            jx.m5219b((Object) customPropertyKey, (Object) "key");
            jx.m5219b((Object) str, (Object) "value");
            m2000j("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, bk(customPropertyKey.getKey()) + bk(str));
            iA().m2340a(customPropertyKey, str);
            return this;
        }

        public Builder setDescription(String str) {
            this.OF.m2344b(ln.Rm, str);
            return this;
        }

        public Builder setIndexableText(String str) {
            m2000j("Indexable text size", MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES, bk(str));
            this.OF.m2344b(ln.Rr, str);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.OF.m2344b(lp.RR, date);
            return this;
        }

        public Builder setMimeType(String str) {
            this.OF.m2344b(ln.RA, str);
            return this;
        }

        public Builder setPinned(boolean z) {
            this.OF.m2344b(ln.Rv, Boolean.valueOf(z));
            return this;
        }

        public Builder setStarred(boolean z) {
            this.OF.m2344b(ln.RH, Boolean.valueOf(z));
            return this;
        }

        public Builder setTitle(String str) {
            this.OF.m2344b(ln.RJ, str);
            return this;
        }

        public Builder setViewed(boolean z) {
            this.OF.m2344b(ln.Rz, Boolean.valueOf(z));
            return this;
        }
    }

    static {
        OE = new MetadataChangeSet(MetadataBundle.iZ());
    }

    public MetadataChangeSet(MetadataBundle metadataBundle) {
        this.OF = MetadataBundle.m2342a(metadataBundle);
    }

    public final Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.OF.m2343a(ln.Rl);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.iV();
    }

    public final String getDescription() {
        return (String) this.OF.m2343a(ln.Rm);
    }

    public final String getIndexableText() {
        return (String) this.OF.m2343a(ln.Rr);
    }

    public final Date getLastViewedByMeDate() {
        return (Date) this.OF.m2343a(lp.RR);
    }

    public final String getMimeType() {
        return (String) this.OF.m2343a(ln.RA);
    }

    public final String getTitle() {
        return (String) this.OF.m2343a(ln.RJ);
    }

    public final Boolean isPinned() {
        return (Boolean) this.OF.m2343a(ln.Rv);
    }

    public final Boolean isStarred() {
        return (Boolean) this.OF.m2343a(ln.RH);
    }

    public final Boolean isViewed() {
        return (Boolean) this.OF.m2343a(ln.Rz);
    }

    public final MetadataBundle iz() {
        return this.OF;
    }
}
