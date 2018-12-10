package com.example.vlad.tankwiki.data.common;

import com.example.vlad.tankwiki.data.model.detail.state.ProfileData;

public class UIProfileState {
    private UIStateType _state;
    private ProfileData _data;
    private Throwable _throwable;

    public UIProfileState(UIStateType state, ProfileData data, Throwable throwable) {
        _state = state;
        _data = data;
        _throwable = throwable;
    }

    public static UIProfileState loading() {
        return new UIProfileState(UIStateType.LOADING, null, null);
    }

    public static UIProfileState success(ProfileData data) {
        return new UIProfileState(UIStateType.SUCCESS, data, null);
    }

    public static UIProfileState error(Throwable throwable) {
        return new UIProfileState(UIStateType.ERROR, null, throwable);
    }

    public static UIProfileState loaded() {
        return new UIProfileState(UIStateType.LOADED, null, null);
    }

    public UIStateType getState() {
        return _state;
    }

    public void setState(UIStateType _state) {
        this._state = _state;
    }

    public ProfileData getData() {
        return _data;
    }

    public void setData(ProfileData _data) {
        this._data = _data;
    }

    public Throwable getThrowable() {
        return _throwable;
    }

    public void setThrowable(Throwable _throwable) {
        this._throwable = _throwable;
    }
}
