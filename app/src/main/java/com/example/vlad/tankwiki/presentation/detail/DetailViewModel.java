package com.example.vlad.tankwiki.presentation.detail;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.vlad.tankwiki.data.common.UIProfileState;
import com.example.vlad.tankwiki.data.model.detail.beans.Ammo;
import com.example.vlad.tankwiki.data.model.detail.beans.AmmoType;
import com.example.vlad.tankwiki.data.model.detail.beans.Armor;
import com.example.vlad.tankwiki.data.model.detail.beans.Engine;
import com.example.vlad.tankwiki.data.model.detail.beans.Gun;
import com.example.vlad.tankwiki.data.model.detail.beans.Radio;
import com.example.vlad.tankwiki.data.model.detail.beans.Suspension;
import com.example.vlad.tankwiki.data.model.detail.state.MainInfo;
import com.example.vlad.tankwiki.data.model.tanks.Module;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.example.vlad.tankwiki.data.rx.SchedulersFacade;
import com.example.vlad.tankwiki.domain.interactors.LoadProfileInteractor;

import java.util.List;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;

public class DetailViewModel extends ViewModel {
    private final LoadProfileInteractor _interactor;
    private final SchedulersFacade _scheduler;
    private final CompositeDisposable _disposable;

    private final MutableLiveData<UIProfileState> _state = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _descriptionState = new MutableLiveData<>();

    private final MutableLiveData<MainInfo> _main = new MutableLiveData<>();
    private final MutableLiveData<Map<String, Module>> _modulesTree = new MutableLiveData<>();
    private final MutableLiveData<Armor> _armor = new MutableLiveData<>();
    private final MutableLiveData<Gun> _gun = new MutableLiveData<>();
    private final MutableLiveData<Ammo> _ammo = new MutableLiveData<>();
    private final MutableLiveData<Engine> _engine = new MutableLiveData<>();
    private final MutableLiveData<Suspension> _suspension = new MutableLiveData<>();
    private final MutableLiveData<Radio> _radio = new MutableLiveData<>();

    DetailViewModel(LoadProfileInteractor interactor, SchedulersFacade scheduler) {
        _interactor = interactor;
        _scheduler = scheduler;
        _disposable = new CompositeDisposable();
        _descriptionState.setValue(false);
    }

    void loadData(final Tank tank) {
        _disposable.add(
                _interactor.fetchTankProfile(tank)
                        .subscribeOn(_scheduler.io())
                        .doOnSubscribe(__ -> _state.setValue(UIProfileState.loading()))
                        .observeOn(_scheduler.ui())
                        .subscribe(
                                profile -> {
                                    _modulesTree.setValue(tank.getModules());
                                    _main.setValue(profile.getMainInfo());
                                    _armor.setValue(profile.getArmor());
                                    _gun.setValue(profile.getGun());
                                    _ammo.setValue(profile.getAmmo());
                                    _engine.setValue(profile.getEngine());
                                    _suspension.setValue(profile.getSuspension());
                                    _radio.setValue(profile.getRadio());
                                    _state.setValue(UIProfileState.loaded());
                                },
                                throwable -> _state.setValue(UIProfileState.error(throwable))
                        )
        );
    }

    MutableLiveData<UIProfileState> state() {
        return _state;
    }

    MutableLiveData<MainInfo> main() {
        return _main;
    }

    MutableLiveData<Boolean> descriptionState() {
        return _descriptionState;
    }

    public MutableLiveData<Armor> armor() {
        return _armor;
    }

    public MutableLiveData<Gun> gun() {
        return _gun;
    }

    public MutableLiveData<Ammo> ammo() {
        return _ammo;
    }

    public MutableLiveData<Engine> engine() {
        return _engine;
    }

    public MutableLiveData<Suspension> suspension() {
        return _suspension;
    }

    public MutableLiveData<Radio> radio() {
        return _radio;
    }

    public MutableLiveData<Map<String, Module>> modulesTree() {
        return _modulesTree;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        _disposable.clear();
    }

    void onDescriptionClick(Boolean show) {
        _descriptionState.postValue(!show);
    }
}
