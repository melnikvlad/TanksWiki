package com.example.vlad.tankwiki.domain.use_cases;

import com.example.vlad.tankwiki.data.model.detail.state.ProfileData;
import com.example.vlad.tankwiki.data.model.tanks.Tank;

import io.reactivex.Single;

public interface LoadProfileUseCase {
    Single<ProfileData> fetchTankProfile(Tank tankId);

}
