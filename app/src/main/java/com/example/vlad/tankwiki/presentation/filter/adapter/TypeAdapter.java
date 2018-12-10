package com.example.vlad.tankwiki.presentation.filter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.filter.IFilterItem;
import com.example.vlad.tankwiki.data.model.filter.Type;
import com.example.vlad.tankwiki.presentation.filter.OnFilterItemClick;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.example.vlad.tankwiki.domain.interactors.FilterInteractor.TIER;
import static com.example.vlad.tankwiki.domain.interactors.FilterInteractor.TYPE;

public class TypeAdapter extends BaseFilterAdapter<Type, TypeAdapter.TypeViewHolder>{
    private Context _context;

    public TypeAdapter(Context context, OnFilterItemClick<Type> listener) {
        super(Type.getSet(), listener);
        _context = context;
    }

    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(_context).inflate(R.layout.holder_type, viewGroup, false);
        return new TypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int pos) {
        super.onBindViewHolder(holder, pos);
        holder.text_type.setOnClickListener((v) -> {
            _listener.onSelect(_list.get(pos));
            switchSelectState(pos);
        });
    }

    public void update(Map<String,Set<IFilterItem>> selectedOptions) {
        Set<IFilterItem> set = selectedOptions.get(TYPE);
        updateList(set);
    }

    public class TypeViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
        View line;
        TextView text_type;


        public TypeViewHolder(@NonNull View v) {
            super(v);
            line = v.findViewById(R.id.view_underline);
            text_type = v.findViewById(R.id.text_type);
        }

        @Override
        public void bind(int position) {
            text_type.setText(_list.get(position).getValue());

            if (_list.get(position).isSelected()) {
                line.setVisibility(View.VISIBLE);
            } else {
                line.setVisibility(View.INVISIBLE);
            }
        }
    }
}
