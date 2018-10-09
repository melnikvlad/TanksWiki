package com.example.vlad.tankwiki.presentation.filter;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;



public class TierAdapter extends RecyclerView.Adapter<TierAdapter.TierViewHolder> {
    private static final int TIER_COUNT = 10;
    private Context _context;

    public TierAdapter(Context context) {
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
        holder.bind(holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return TIER_COUNT;
    }

    class TierViewHolder extends RecyclerView.ViewHolder {
        TextView text_tier;

        TierViewHolder(@NonNull View itemView) {
            super(itemView);
            text_tier = itemView.findViewById(R.id.text_tier);
        }

        void bind(int pos) {
            text_tier.setText(String.valueOf(pos + 1));
        }
    }
}
