package com.example.vlad.tankwiki.presentation.filter.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.vlad.tankwiki.data.model.filter.FilterItem;
import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.presentation.filter.OnFilterItemClick;

import java.util.List;
import java.util.Set;

public abstract class BaseFilterAdapter<T extends FilterItem, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<T> _list;
    protected OnFilterItemClick<T> _listener;

    BaseFilterAdapter(List<T> list, OnFilterItemClick<T> listener) {
        _list = list;
        _listener = listener;
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int pos) {
        ((IViewHolder) vh).bind(pos);
    }

    void updateList(final Set<IFilterItem> selectedItems) {
        if (selectedItems != null) {
            for (IFilterItem item : selectedItems) {
                _list.set(item.getPosition(), (T)item);
                notifyItemChanged(item.getPosition());
            }
        }
    }

    void switchSelectState(int pos) {
        _list.get(pos).setSelected(!_list.get(pos).isSelected());
        notifyItemChanged(pos);
    }

}
