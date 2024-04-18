package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import java.util.Date;

public class SortableField {
    public static final SortableMetadataField<Date> CREATED_DATE;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
    public static final SortableMetadataField<Date> MODIFIED_DATE;
    public static final SortableMetadataField<Long> QUOTA_USED;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
    public static final SortableMetadataField<String> TITLE;

    static {
        TITLE = ln.RJ;
        CREATED_DATE = lp.RQ;
        MODIFIED_DATE = lp.RS;
        MODIFIED_BY_ME_DATE = lp.RT;
        LAST_VIEWED_BY_ME = lp.RR;
        SHARED_WITH_ME_DATE = lp.RU;
        QUOTA_USED = ln.RG;
    }
}
