package com.example.vlad.tankwiki.domain.interactors;

import com.example.vlad.tankwiki.data.model.detail.DetailResponse;
import com.example.vlad.tankwiki.data.model.detail.beans.Ammo;
import com.example.vlad.tankwiki.data.model.detail.beans.Profile;
import com.example.vlad.tankwiki.data.model.detail.state.MainInfo;
import com.example.vlad.tankwiki.data.model.detail.state.ProfileData;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.example.vlad.tankwiki.data.repository.ProfileRepository;
import com.example.vlad.tankwiki.domain.use_cases.LoadProfileUseCase;

import io.reactivex.Single;

public class LoadProfileInteractor implements LoadProfileUseCase {
    private final ProfileRepository _repository;

    public LoadProfileInteractor(ProfileRepository profileRepository) {
        _repository = profileRepository;
    }

    @Override
    public Single<ProfileData> fetchTankProfile(final Tank tank) {
        return _repository.execute(tank.getTankId())
                .map(data -> mapResponse(data, tank));
    }

    private ProfileData mapResponse(final DetailResponse response, final Tank tank) {
        if (response == null) return null;

        ProfileData profileData = new ProfileData();
        if (response.getData() != null) {
            Profile profile = response.getData().get(String.valueOf(tank.getTankId()));
            if (profile != null) {
                ProfileData.setDefaultConfig(profile.modules);
                profileData.setMainInfo(
                        new MainInfo(
                                tank.getName(),
                                tank.getDescription(),
                                tank.getTier(),
                                tank.getType(),
                                tank.getPriceGold(),
                                tank.getPriceCredit(),
                                tank.getImage().getBig()
                        ));
                profileData.setAmmo(new Ammo(profile.ammo));
                profileData.setArmor(profile.armor);
                profileData.setGun(profile.gun);
                profileData.setTurret(profile.turret);
                profileData.setEngine(profile.engine);
                profileData.setSuspension(profile.suspension);
                profileData.setRadio(profile.radio);
            }
        }
        return profileData;
    }
}
