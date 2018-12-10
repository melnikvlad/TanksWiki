package com.example.vlad.tankwiki.domain.use_cases;

import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.data.model.filter.Type;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.example.vlad.tankwiki.data.model.tanks.TanksResponse;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Single;

public interface LoadDataUseCase {

    Single<List<Tank>> execute(int page, Map<String, Set<IFilterItem>> options);
}
