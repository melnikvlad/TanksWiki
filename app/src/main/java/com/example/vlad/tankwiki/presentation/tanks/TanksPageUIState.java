package com.example.vlad.tankwiki.presentation.tanks;

import com.example.vlad.tankwiki.data.model.Tank;
import com.example.vlad.tankwiki.data.common.UIStateType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.vlad.tankwiki.data.common.UIStateType.ERROR;
import static com.example.vlad.tankwiki.data.common.UIStateType.LOADING;
import static com.example.vlad.tankwiki.data.common.UIStateType.SUCCESS;

class TanksPageUIState {
    // TODO: Make it generic
    public final UIStateType state;
    public final List<Tank> data;
    public final Throwable throwable;
    public static Map<String, String> options = new HashMap<>();

    public TanksPageUIState(final UIStateType state, final List<Tank> data, final Throwable throwable) {
        this.state = state;
        this.data = data;
        this.throwable = throwable;
    }

    public static TanksPageUIState loading() {
        return new TanksPageUIState(LOADING, null, null);
    }

    public static TanksPageUIState error(Throwable error) {
        return new TanksPageUIState(ERROR, null, error);
    }

    public static TanksPageUIState success(List<Tank> tanks) {
        return new TanksPageUIState(SUCCESS, tanks, null);
    }
}
