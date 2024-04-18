package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.C0651b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.C0672f;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.c */
public class C0673c implements C0672f<String> {
    public <T> String m2406a(C0651b<T> c0651b, T t) {
        return String.format("contains(%s,%s)", new Object[]{c0651b.getName(), t});
    }

    public <T> String m2407a(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", new Object[]{operator.getTag(), metadataField.getName(), t});
    }

    public String m2408a(Operator operator, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder(operator.getTag() + "(");
        String str = "";
        for (String str2 : list) {
            stringBuilder.append(str);
            stringBuilder.append(str2);
            str = ",";
        }
        return stringBuilder.append(")").toString();
    }

    public /* synthetic */ Object m2409b(C0651b c0651b, Object obj) {
        return m2406a(c0651b, obj);
    }

    public /* synthetic */ Object m2410b(Operator operator, MetadataField metadataField, Object obj) {
        return m2407a(operator, metadataField, obj);
    }

    public /* synthetic */ Object m2411b(Operator operator, List list) {
        return m2408a(operator, list);
    }

    public String bq(String str) {
        return String.format("not(%s)", new Object[]{str});
    }

    public String m2412c(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    public <T> String m2413c(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), t});
    }

    public /* synthetic */ Object m2414d(MetadataField metadataField) {
        return m2412c(metadataField);
    }

    public /* synthetic */ Object m2415d(MetadataField metadataField, Object obj) {
        return m2413c(metadataField, obj);
    }

    public /* synthetic */ Object m2416j(Object obj) {
        return bq((String) obj);
    }

    public String jc() {
        return "all()";
    }

    public /* synthetic */ Object jd() {
        return jc();
    }
}
