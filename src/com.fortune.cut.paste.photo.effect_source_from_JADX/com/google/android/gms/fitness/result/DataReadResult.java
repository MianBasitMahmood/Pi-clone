package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.chartboost.sdk.CBLocation;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
    public static final Creator<DataReadResult> CREATOR;
    private final int CK;
    private final Status Eb;
    private final List<DataSet> Ua;
    private final List<DataSource> Uk;
    private final List<Bucket> Wr;
    private int Ws;
    private final List<DataType> Wt;

    static {
        CREATOR = new C0842b();
    }

    DataReadResult(int i, List<RawDataSet> list, Status status, List<RawBucket> list2, int i2, List<DataSource> list3, List<DataType> list4) {
        this.CK = i;
        this.Eb = status;
        this.Ws = i2;
        this.Uk = list3;
        this.Wt = list4;
        this.Ua = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            this.Ua.add(new DataSet(dataSet, list3, list4));
        }
        this.Wr = new ArrayList(list2.size());
        for (RawBucket bucket : list2) {
            this.Wr.add(new Bucket(bucket, list3, list4));
        }
    }

    public DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.CK = 5;
        this.Ua = list;
        this.Eb = status;
        this.Wr = list2;
        this.Ws = 1;
        this.Uk = new ArrayList();
        this.Wt = new ArrayList();
    }

    public static DataReadResult m2783a(Status status, DataReadRequest dataReadRequest) {
        List arrayList = new ArrayList();
        for (DataSource create : dataReadRequest.getDataSources()) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : dataReadRequest.getDataTypes()) {
            arrayList.add(DataSet.create(new Builder().setDataType(dataType).setType(1).setName(CBLocation.LOCATION_DEFAULT).build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void m2784a(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.m2608b(bucket)) {
                for (DataSet a : bucket.getDataSets()) {
                    m2785a(a, bucket2.getDataSets());
                }
                return;
            }
        }
        this.Wr.add(bucket);
    }

    private void m2785a(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.m2613a(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean m2786c(DataReadResult dataReadResult) {
        return this.Eb.equals(dataReadResult.Eb) && jv.equal(this.Ua, dataReadResult.Ua) && jv.equal(this.Wr, dataReadResult.Wr);
    }

    public void m2787b(DataReadResult dataReadResult) {
        for (DataSet a : dataReadResult.getDataSets()) {
            m2785a(a, this.Ua);
        }
        for (Bucket a2 : dataReadResult.getBuckets()) {
            m2784a(a2, this.Wr);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadResult) && m2786c((DataReadResult) obj));
    }

    public List<Bucket> getBuckets() {
        return this.Wr;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.Ua) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataSource.getStreamIdentifier()}));
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.Ua) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataType.getName()}));
    }

    public List<DataSet> getDataSets() {
        return this.Ua;
    }

    public Status getStatus() {
        return this.Eb;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.Ua, this.Wr);
    }

    List<DataSource> jw() {
        return this.Uk;
    }

    public int kr() {
        return this.Ws;
    }

    List<RawBucket> ks() {
        List<RawBucket> arrayList = new ArrayList(this.Wr.size());
        for (Bucket rawBucket : this.Wr) {
            arrayList.add(new RawBucket(rawBucket, this.Uk, this.Wt));
        }
        return arrayList;
    }

    List<RawDataSet> kt() {
        List<RawDataSet> arrayList = new ArrayList(this.Ua.size());
        for (DataSet rawDataSet : this.Ua) {
            arrayList.add(new RawDataSet(rawDataSet, this.Uk, this.Wt));
        }
        return arrayList;
    }

    List<DataType> ku() {
        return this.Wt;
    }

    public String toString() {
        return jv.m5212h(this).m5211a("status", this.Eb).m5211a("dataSets", this.Ua.size() > 5 ? this.Ua.size() + " data sets" : this.Ua).m5211a("buckets", this.Wr.size() > 5 ? this.Wr.size() + " buckets" : this.Wr).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0842b.m2799a(this, parcel, i);
    }
}
