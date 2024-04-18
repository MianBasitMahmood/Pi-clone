package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.C1265a;
import com.google.android.gms.internal.jx;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] adl;
    private int Iv;
    private String Xh;
    private HashMap<Integer, Result> adR;
    private String adn;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long j, String str, String str2, boolean z) {
            this.rawScore = j;
            this.formattedScore = str;
            this.scoreTag = str2;
            this.newBest = z;
        }

        public final String toString() {
            return jv.m5212h(this).m5211a("RawScore", Long.valueOf(this.rawScore)).m5211a("FormattedScore", this.formattedScore).m5211a("ScoreTag", this.scoreTag).m5211a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    static {
        adl = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.Iv = dataHolder.getStatusCode();
        this.adR = new HashMap();
        int count = dataHolder.getCount();
        jx.m5216L(count == 3);
        for (int i = 0; i < count; i++) {
            int au = dataHolder.au(i);
            if (i == 0) {
                this.adn = dataHolder.m1865c("leaderboardId", i, au);
                this.Xh = dataHolder.m1865c("playerId", i, au);
            }
            if (dataHolder.m1866d("hasResult", i, au)) {
                m4031a(new Result(dataHolder.m1862a("rawScore", i, au), dataHolder.m1865c("formattedScore", i, au), dataHolder.m1865c("scoreTag", i, au), dataHolder.m1866d("newBest", i, au)), dataHolder.m1864b("timeSpan", i, au));
            }
        }
    }

    private void m4031a(Result result, int i) {
        this.adR.put(Integer.valueOf(i), result);
    }

    public final String getLeaderboardId() {
        return this.adn;
    }

    public final String getPlayerId() {
        return this.Xh;
    }

    public final Result getScoreResult(int i) {
        return (Result) this.adR.get(Integer.valueOf(i));
    }

    public final String toString() {
        C1265a a = jv.m5212h(this).m5211a("PlayerId", this.Xh).m5211a("StatusCode", Integer.valueOf(this.Iv));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.adR.get(Integer.valueOf(i));
            a.m5211a("TimesSpan", TimeSpan.dZ(i));
            a.m5211a("Result", result == null ? "null" : result.toString());
        }
        return a.toString();
    }
}
