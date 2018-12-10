package com.example.vlad.tankwiki.domain.interactors;

import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.example.vlad.tankwiki.data.model.tanks.TanksResponse;
import com.example.vlad.tankwiki.data.repository.TanksRepository;
import com.example.vlad.tankwiki.domain.use_cases.LoadDataUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoadDataInteractor implements LoadDataUseCase {
    private TanksRepository _tanksRepository;

    @Inject
    public LoadDataInteractor(TanksRepository tanksRepository) {
        _tanksRepository = tanksRepository;
    }

    @Override
    public Single<List<Tank>> execute(final int page, final Map<String, Set<IFilterItem>> options) {
        return _tanksRepository.fetchTanksWith(page, options)
                .map(this::tankResponseMapper);
    }

    private List<Tank> tankResponseMapper(final TanksResponse response) {
        List<Tank> tankList = new ArrayList<>();
        if (response != null) {
            Map<String, Tank> map = response.getData();
            if (map != null) {
                for (String key : map.keySet()) {
                    tankList.add(map.get(key));
                }
            }
        }
        return tankList;
    }
}
