package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0543c;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public interface HistoryApi {

    public static class ViewIntentBuilder {
        private long LW;
        private final DataType TM;
        private DataSource TN;
        private long TO;
        private String TP;
        private final Context mContext;

        public ViewIntentBuilder(Context context, DataType dataType) {
            this.mContext = context;
            this.TM = dataType;
        }

        private Intent m2602i(Intent intent) {
            if (this.TP == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.TP);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.TP, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            boolean z = true;
            jx.m5217a(this.LW > 0, "Start time must be set");
            if (this.TO <= this.LW) {
                z = false;
            }
            jx.m5217a(z, "End time must be set and after start time");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(DataType.getMimeType(this.TN.getDataType()));
            intent.putExtra(Fitness.EXTRA_START_TIME, this.LW);
            intent.putExtra(Fitness.EXTRA_END_TIME, this.TO);
            C0543c.m1985a(this.TN, intent, DataSource.EXTRA_DATA_SOURCE);
            return m2602i(intent);
        }

        public ViewIntentBuilder setDataSource(DataSource dataSource) {
            jx.m5222b(dataSource.getDataType().equals(this.TM), "Data source %s is not for the data type %s", dataSource, this.TM);
            this.TN = dataSource;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String str) {
            this.TP = str;
            return this;
        }

        public ViewIntentBuilder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.LW = timeUnit.toMillis(j);
            this.TO = timeUnit.toMillis(j2);
            return this;
        }
    }

    PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest);

    PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet);

    PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest);
}
