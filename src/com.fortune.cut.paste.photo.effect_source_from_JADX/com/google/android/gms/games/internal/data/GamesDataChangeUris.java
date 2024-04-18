package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

public final class GamesDataChangeUris {
    private static final Uri ach;
    public static final Uri aci;
    public static final Uri acj;

    static {
        Uri build = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
        ach = build;
        aci = build.buildUpon().appendPath("invitations").build();
        acj = ach.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
    }
}
