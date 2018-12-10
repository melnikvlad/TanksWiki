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
import com.example.vlad.tankwiki.data.model.filter.Tier;
import com.example.vlad.tankwiki.presentation.filter.OnFilterItemClick;

import java.util.Map;
import java.util.Set;

import static com.example.vlad.tankwiki.domain.interactors.FilterInteractor.TIER;


public class TierAdapter extends BaseFilterAdapter<Tier, TierAdapter.TierViewHolder> {
    private Context _context;

    public TierAdapter(Context context, OnFilterItemClick<Tier> listener) {
        super(Tier.getSet(), listener);
        _context = context;
    }

    @NonNull
    @Override
    public TierViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(_context).inflate(R.layout.holder_tier, viewGroup, false);
        return new TierViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TierViewHolder holder, int pos) {
        super.onBindViewHolder(holder, pos);

        holder.text_tier.setOnClickListener((view -> {
            _listener.onSelect(_list.get(pos));
            switchSelectState(pos);
        }));
    }

    public void update(Map<String,Set<IFilterItem>> selectedOptions) {
        Set<IFilterItem> set = selectedOptions.get(TIER);
        updateList(set);
    }

    class TierViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
        View line;
        TextView text_tier;

        TierViewHolder(@NonNull View itemView) {
            super(itemView);
            line = itemView.findViewById(R.id.view_underline);
            text_tier = itemView.findViewById(R.id.text_tier);
        }

        @Override
        public void bind(int pos) {
            text_tier.setText(_list.get(pos).getValue());

            if (_list.get(pos).isSelected()) {
                line.setVisibility(View.VISIBLE);
            } else {
                line.setVisibility(View.INVISIBLE);
            }
        }
    }
}
