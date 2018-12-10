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
import com.example.vlad.tankwiki.data.model.filter.Nation;
import com.example.vlad.tankwiki.presentation.filter.OnFilterItemClick;

import java.util.Map;
import java.util.Set;

import static com.example.vlad.tankwiki.domain.interactors.FilterInteractor.NATION;
import static com.example.vlad.tankwiki.domain.interactors.FilterInteractor.TYPE;


public class NationAdapter extends BaseFilterAdapter<Nation, NationAdapter.NationViewHolder> {
    private Context _context;

    public NationAdapter(Context _context, OnFilterItemClick<Nation> listener) {
        super(Nation.getSet(), listener);
        this._context = _context;
    }

    @NonNull
    @Override
    public NationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(_context).inflate(R.layout.holder_nation, viewGroup, false);
        return new NationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NationViewHolder holder, int pos) {
        super.onBindViewHolder(holder, pos);

        holder.text_nation.setOnClickListener((v) -> {
            _listener.onSelect(_list.get(pos));
            switchSelectState(pos);
        });
    }

    public void update(Map<String,Set<IFilterItem>> selectedOptions) {
        Set<IFilterItem> set = selectedOptions.get(NATION);
        updateList(set);
    }

    class NationViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
        View line;
        TextView text_nation;

        NationViewHolder(@NonNull View v) {
            super(v);
            line = v.findViewById(R.id.view_underline);
            text_nation = v.findViewById(R.id.text_nation);
        }

        @Override
        public void bind(int position) {
            text_nation.setText(_list.get(position).getValue());

            if (_list.get(position).isSelected()) {
                line.setVisibility(View.VISIBLE);
            } else {
                line.setVisibility(View.INVISIBLE);
            }
        }
    }
}
