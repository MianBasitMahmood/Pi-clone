package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR;
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
    private final int CK;
    List<DetectedActivity> afX;
    long afY;
    long afZ;

    static {
        CREATOR = new ActivityRecognitionResultCreator();
    }

    public ActivityRecognitionResult(int i, List<DetectedActivity> list, long j, long j2) {
        this.CK = 1;
        this.afX = list;
        this.afY = j;
        this.afZ = j2;
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2) {
        this(Collections.singletonList(detectedActivity), j, j2);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2) {
        boolean z = false;
        boolean z2 = list != null && list.size() > 0;
        jx.m5221b(z2, (Object) "Must have at least 1 detected activity");
        if (j > 0 && j2 > 0) {
            z = true;
        }
        jx.m5221b(z, (Object) "Must set times");
        this.CK = 1;
        this.afX = list;
        this.afY = j;
        this.afZ = j2;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get(EXTRA_ACTIVITY_RESULT);
        if (!(obj instanceof byte[])) {
            return obj instanceof ActivityRecognitionResult ? (ActivityRecognitionResult) obj : null;
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall((byte[]) obj, 0, ((byte[]) obj).length);
            obtain.setDataPosition(0);
            return CREATOR.createFromParcel(obtain);
        }
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra(EXTRA_ACTIVITY_RESULT);
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int i) {
        for (DetectedActivity detectedActivity : this.afX) {
            if (detectedActivity.getType() == i) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.afZ;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.afX.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.afX;
    }

    public long getTime() {
        return this.afY;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.afX + ", timeMillis=" + this.afY + ", elapsedRealtimeMillis=" + this.afZ + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        ActivityRecognitionResultCreator.m6082a(this, parcel, i);
    }
}
