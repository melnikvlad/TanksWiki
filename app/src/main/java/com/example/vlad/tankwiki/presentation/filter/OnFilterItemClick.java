package com.example.vlad.tankwiki.presentation.filter;

import com.example.vlad.tankwiki.data.model.filter.Tier;

public interface OnFilterItemClick<T> {
    void onSelect(T item);
}
