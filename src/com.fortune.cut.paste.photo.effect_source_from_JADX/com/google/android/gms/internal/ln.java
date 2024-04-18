package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0522a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.C0651b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C0657b;
import com.google.android.gms.drive.metadata.internal.C0662g;
import com.google.android.gms.drive.metadata.internal.C0664i;
import com.google.android.gms.drive.metadata.internal.C0665j;
import com.google.android.gms.drive.metadata.internal.C0666k;
import com.google.android.gms.drive.metadata.internal.C0667l;
import com.google.android.gms.drive.metadata.internal.C0668m;
import com.google.android.gms.plus.PlusShare;
import java.util.Collection;
import java.util.Collections;

public class ln {
    public static final C1284c RA;
    public static final MetadataField<String> RB;
    public static final C0651b<String> RC;
    public static final C0668m RD;
    public static final C0668m RE;
    public static final C1285d RF;
    public static final C1286e RG;
    public static final C1287f RH;
    public static final MetadataField<C0522a> RI;
    public static final C1288g RJ;
    public static final C1289h RK;
    public static final MetadataField<String> RL;
    public static final MetadataField<String> RM;
    public static final MetadataField<String> RN;
    public static final C0657b RO;
    public static final MetadataField<String> RP;
    public static final MetadataField<DriveId> Rj;
    public static final MetadataField<String> Rk;
    public static final C1282a Rl;
    public static final MetadataField<String> Rm;
    public static final MetadataField<String> Rn;
    public static final MetadataField<String> Ro;
    public static final MetadataField<Long> Rp;
    public static final MetadataField<Boolean> Rq;
    public static final MetadataField<String> Rr;
    public static final MetadataField<Boolean> Rs;
    public static final MetadataField<Boolean> Rt;
    public static final MetadataField<Boolean> Ru;
    public static final C1283b Rv;
    public static final MetadataField<Boolean> Rw;
    public static final MetadataField<Boolean> Rx;
    public static final MetadataField<Boolean> Ry;
    public static final MetadataField<Boolean> Rz;

    /* renamed from: com.google.android.gms.internal.ln.1 */
    static class C12811 extends C0665j<C0522a> {
        C12811(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected final /* synthetic */ Object m5336c(DataHolder dataHolder, int i, int i2) {
            return m5337k(dataHolder, i, i2);
        }

        protected final C0522a m5337k(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    }

    /* renamed from: com.google.android.gms.internal.ln.a */
    public static class C1282a extends lo implements SearchableMetadataField<AppVisibleCustomProperties> {
        public C1282a(int i) {
            super(i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln.b */
    public static class C1283b extends C0657b implements SearchableMetadataField<Boolean> {
        public C1283b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln.c */
    public static class C1284c extends C0667l implements SearchableMetadataField<String> {
        public C1284c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln.d */
    public static class C1285d extends C0664i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public C1285d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln.e */
    public static class C1286e extends C0662g implements SortableMetadataField<Long> {
        public C1286e(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln.f */
    public static class C1287f extends C0657b implements SearchableMetadataField<Boolean> {
        public C1287f(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln.g */
    public static class C1288g extends C0667l implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public C1288g(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln.h */
    public static class C1289h extends C0657b implements SearchableMetadataField<Boolean> {
        public C1289h(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object m5340c(DataHolder dataHolder, int i, int i2) {
            return m5341e(dataHolder, i, i2);
        }

        protected Boolean m5341e(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.m1864b(getName(), i, i2) != 0);
        }
    }

    static {
        Rj = lq.RV;
        Rk = new C0667l("alternateLink", 4300000);
        Rl = new C1282a(5000000);
        Rm = new C0667l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
        Rn = new C0667l("embedLink", 4300000);
        Ro = new C0667l("fileExtension", 4300000);
        Rp = new C0662g("fileSize", 4300000);
        Rq = new C0657b("hasThumbnail", 4300000);
        Rr = new C0667l("indexableText", 4300000);
        Rs = new C0657b("isAppData", 4300000);
        Rt = new C0657b("isCopyable", 4300000);
        Ru = new C0657b("isEditable", 4100000);
        Rv = new C1283b("isPinned", 4100000);
        Rw = new C0657b("isRestricted", 4300000);
        Rx = new C0657b("isShared", 4300000);
        Ry = new C0657b("isTrashable", 4400000);
        Rz = new C0657b("isViewed", 4300000);
        RA = new C1284c("mimeType", 4100000);
        RB = new C0667l("originalFilename", 4300000);
        RC = new C0666k("ownerNames", 4300000);
        RD = new C0668m("lastModifyingUser", 6000000);
        RE = new C0668m("sharingUser", 6000000);
        RF = new C1285d("parents", 4100000);
        RG = new C1286e("quotaBytesUsed", 4300000);
        RH = new C1287f("starred", 4100000);
        RI = new C12811("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000);
        RJ = new C1288g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
        RK = new C1289h("trashed", 4100000);
        RL = new C0667l("webContentLink", 4300000);
        RM = new C0667l("webViewLink", 4300000);
        RN = new C0667l("uniqueIdentifier", 5000000);
        RO = new C0657b("writersCanShare", 6000000);
        RP = new C0667l("role", 6000000);
    }
}
