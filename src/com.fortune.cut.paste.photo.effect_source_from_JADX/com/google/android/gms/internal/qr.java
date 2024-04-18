package com.google.android.gms.internal;

import com.google.android.gms.common.api.CommonStatusCodes;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class qr<M extends qq<M>, T> {
    protected final Class<T> ayX;
    protected final boolean ayY;
    public final int tag;
    protected final int type;

    private qr(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.ayX = cls;
        this.tag = i2;
        this.ayY = z;
    }

    public static <M extends qq<M>, T extends qw> qr<M, T> m5983a(int i, Class<T> cls, int i2) {
        return new qr(i, cls, i2, false);
    }

    private T m5984n(List<qy> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            qy qyVar = (qy) list.get(i);
            if (qyVar.azi.length != 0) {
                m5989a(qyVar, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.ayX.cast(Array.newInstance(this.ayX.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    private T m5985o(List<qy> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.ayX.cast(m5994x(qo.m5932p(((qy) list.get(list.size() - 1)).azi)));
    }

    int m5986B(Object obj) {
        return this.ayY ? m5987C(obj) : m5988D(obj);
    }

    protected int m5987C(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m5988D(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int m5988D(Object obj) {
        int hl = qz.hl(this.tag);
        switch (this.type) {
            case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                return qp.m5942b(hl, (qw) obj);
            case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                return qp.m5946c(hl, (qw) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void m5989a(qy qyVar, List<Object> list) {
        list.add(m5994x(qo.m5932p(qyVar.azi)));
    }

    void m5990a(Object obj, qp qpVar) throws IOException {
        if (this.ayY) {
            m5992c(obj, qpVar);
        } else {
            m5991b(obj, qpVar);
        }
    }

    protected void m5991b(Object obj, qp qpVar) {
        try {
            qpVar.hd(this.tag);
            switch (this.type) {
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    qw qwVar = (qw) obj;
                    int hl = qz.hl(this.tag);
                    qpVar.m5972b(qwVar);
                    qpVar.m5982x(hl, 4);
                    return;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    qpVar.m5974c((qw) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected void m5992c(Object obj, qp qpVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m5991b(obj2, qpVar);
            }
        }
    }

    final T m5993m(List<qy> list) {
        return list == null ? null : this.ayY ? m5984n(list) : m5985o(list);
    }

    protected Object m5994x(qo qoVar) {
        Class componentType = this.ayY ? this.ayX.getComponentType() : this.ayX;
        try {
            qw qwVar;
            switch (this.type) {
                case CommonStatusCodes.DEVELOPER_ERROR /*10*/:
                    qwVar = (qw) componentType.newInstance();
                    qoVar.m5934a(qwVar, qz.hl(this.tag));
                    return qwVar;
                case CommonStatusCodes.LICENSE_CHECK_FAILED /*11*/:
                    qwVar = (qw) componentType.newInstance();
                    qoVar.m5933a(qwVar);
                    return qwVar;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }
}
