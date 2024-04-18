package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0752d.C0754a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.e */
public final class C0755e<T> extends C0754a {
    private final T TH;

    private C0755e(T t) {
        this.TH = t;
    }

    public static <T> T m2593f(C0752d c0752d) {
        if (c0752d instanceof C0755e) {
            return ((C0755e) c0752d).TH;
        }
        IBinder asBinder = c0752d.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    public static <T> C0752d m2594k(T t) {
        return new C0755e(t);
    }
}
