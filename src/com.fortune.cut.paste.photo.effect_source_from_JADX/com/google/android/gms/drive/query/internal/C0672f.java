package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.C0651b;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.f */
public interface C0672f<F> {
    <T> F m2400b(C0651b<T> c0651b, T t);

    <T> F m2401b(Operator operator, MetadataField<T> metadataField, T t);

    F m2402b(Operator operator, List<F> list);

    F m2403d(MetadataField<?> metadataField);

    <T> F m2404d(MetadataField<T> metadataField, T t);

    F m2405j(F f);

    F jd();
}
