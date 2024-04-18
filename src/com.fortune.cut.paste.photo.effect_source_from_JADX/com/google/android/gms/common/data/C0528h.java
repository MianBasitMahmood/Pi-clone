package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.h */
public class C0528h<T> extends C0524c<T> {
    private T Lt;

    public C0528h(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            this.KX++;
            if (this.KX == 0) {
                this.Lt = this.KW.get(0);
                if (!(this.Lt instanceof C0451d)) {
                    throw new IllegalStateException("DataBuffer reference of type " + this.Lt.getClass() + " is not movable");
                }
            }
            ((C0451d) this.Lt).as(this.KX);
            return this.Lt;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.KX);
    }
}
