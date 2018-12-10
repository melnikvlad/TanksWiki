package com.example.vlad.tankwiki.domain.use_cases;

import com.example.vlad.tankwiki.data.model.filter.IFilterItem;

import java.util.Map;
import java.util.Set;

import io.reactivex.Single;

public interface FilterUseCase {

    Single<Map<String, Set<IFilterItem>>> changeSelectedOptions(Map<String, Set<IFilterItem>> sharedOptions, IFilterItem item);

}
