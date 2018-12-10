package com.example.vlad.tankwiki.domain.interactors;

import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.data.model.filter.Type;
import com.example.vlad.tankwiki.data.repository.FilterRepository;
import com.example.vlad.tankwiki.domain.use_cases.FilterUseCase;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Single;

public class FilterInteractor implements FilterUseCase {
    public static final String NATION = "nation";
    public static final String TIER = "tier";
    public static final String TYPE = "type";
    private final FilterRepository _filterRepository;

    @Inject
    public FilterInteractor(FilterRepository filterRepository) {
        _filterRepository = filterRepository;
    }

    @Override
    public Single<Map<String, Set<IFilterItem>>> changeSelectedOptions(final Map<String, Set<IFilterItem>> sharedOptions, final IFilterItem item) {
        if (item instanceof Tier) {
            return _filterRepository.change(sharedOptions, item, TIER);
        } else if (item instanceof Type) {
            return _filterRepository.change(sharedOptions, item, TYPE);
        } else {
            return _filterRepository.change(sharedOptions, item, NATION);
        }
    }
}
