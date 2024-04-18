package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.C0634w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    private final int To;
    private int Tp;
    private final int Tq;
    private final List<DataBuffer<T>> Tr;
    private final LayoutInflater Ts;
    private boolean Tt;
    private final Context mContext;

    public DataBufferAdapter(Context context, int i) {
        this(context, i, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2) {
        this(context, i, i2, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2, List<DataBuffer<T>> list) {
        this.Tt = true;
        this.mContext = context;
        this.Tp = i;
        this.To = i;
        this.Tq = i2;
        this.Tr = list;
        this.Ts = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int i, int i2, DataBuffer<T>... dataBufferArr) {
        this(context, i, i2, Arrays.asList(dataBufferArr));
    }

    public DataBufferAdapter(Context context, int i, List<DataBuffer<T>> list) {
        this(context, i, 0, (List) list);
    }

    public DataBufferAdapter(Context context, int i, DataBuffer<T>... dataBufferArr) {
        this(context, i, 0, Arrays.asList(dataBufferArr));
    }

    private View m2569a(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.Ts.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.Tq == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.Tq);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (Throwable e) {
            C0634w.m2298a("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> dataBuffer) {
        this.Tr.add(dataBuffer);
        if (this.Tt) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer release : this.Tr) {
            release.release();
        }
        this.Tr.clear();
        if (this.Tt) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        for (DataBuffer count : this.Tr) {
            i = count.getCount() + i;
        }
        return i;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return m2569a(i, view, viewGroup, this.Tp);
    }

    public T getItem(int i) throws CursorIndexOutOfBoundsException {
        int i2 = i;
        for (DataBuffer dataBuffer : this.Tr) {
            int count = dataBuffer.getCount();
            if (count <= i2) {
                i2 -= count;
            } else {
                try {
                    return dataBuffer.get(i2);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m2569a(i, view, viewGroup, this.To);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.Tt = true;
    }

    public void setDropDownViewResource(int i) {
        this.Tp = i;
    }

    public void setNotifyOnChange(boolean z) {
        this.Tt = z;
    }
}
