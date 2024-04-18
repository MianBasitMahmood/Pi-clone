package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.C0527g;
import com.google.android.gms.common.data.DataHolder;

public final class QuestBuffer extends C0527g<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected final /* synthetic */ Object m4071f(int i, int i2) {
        return m4072n(i, i2);
    }

    protected final String ha() {
        return "external_quest_id";
    }

    protected final Quest m4072n(int i, int i2) {
        return new QuestRef(this.JG, i, i2);
    }
}
