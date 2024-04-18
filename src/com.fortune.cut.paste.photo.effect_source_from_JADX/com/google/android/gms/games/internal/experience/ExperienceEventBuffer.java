package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer extends DataBuffer<ExperienceEvent> {
    public ExperienceEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public final ExperienceEvent ea(int i) {
        return new ExperienceEventRef(this.JG, i);
    }

    public final /* synthetic */ Object get(int i) {
        return ea(i);
    }
}
