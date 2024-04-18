package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C0659d;
import java.util.Date;

public class lp {
    public static final C1290a RQ;
    public static final C1291b RR;
    public static final C1293d RS;
    public static final C1292c RT;
    public static final C1294e RU;

    /* renamed from: com.google.android.gms.internal.lp.a */
    public static class C1290a extends C0659d implements SortableMetadataField<Date> {
        public C1290a(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.lp.b */
    public static class C1291b extends C0659d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1291b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.lp.c */
    public static class C1292c extends C0659d implements SortableMetadataField<Date> {
        public C1292c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.lp.d */
    public static class C1293d extends C0659d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1293d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.lp.e */
    public static class C1294e extends C0659d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1294e(String str, int i) {
            super(str, i);
        }
    }

    static {
        RQ = new C1290a("created", 4100000);
        RR = new C1291b("lastOpenedTime", 4300000);
        RS = new C1293d("modified", 4100000);
        RT = new C1292c("modifiedByMe", 4100000);
        RU = new C1294e("sharedWithMe", 4100000);
    }
}
