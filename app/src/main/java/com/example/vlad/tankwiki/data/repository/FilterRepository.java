package com.example.vlad.tankwiki.data.repository;

import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.data.model.filter.Type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.reactivex.Single;

public class FilterRepository {

    public Single<Map<String, Set<IFilterItem>>> change(final Map<String, Set<IFilterItem>> sharedOptions, final IFilterItem value, final String key) {
        if(sharedOptions == null) return null;

        Set<IFilterItem> set;

        if (sharedOptions.get(key) == null) {
            set = new HashSet<>();
        } else {
            set = sharedOptions.get(key);
        }

        boolean hasAdded = set.add(value);
        if (!hasAdded) {
            set.remove(value);
        }

        sharedOptions.put(key, set);

        return Single.just(sharedOptions);
    }
}
