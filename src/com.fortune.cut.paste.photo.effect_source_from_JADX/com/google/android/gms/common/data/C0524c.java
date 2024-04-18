package com.google.android.gms.common.data;

import com.google.android.gms.internal.jx;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.c */
public class C0524c<T> implements Iterator<T> {
    protected final DataBuffer<T> KW;
    protected int KX;

    public C0524c(DataBuffer<T> dataBuffer) {
        this.KW = (DataBuffer) jx.m5223i(dataBuffer);
        this.KX = -1;
    }

    public boolean hasNext() {
        return this.KX < this.KW.getCount() + -1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.KW;
            int i = this.KX + 1;
            this.KX = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.KX);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
