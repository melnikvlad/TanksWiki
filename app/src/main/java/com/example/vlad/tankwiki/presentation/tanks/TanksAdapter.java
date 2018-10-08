package com.example.vlad.tankwiki.presentation.tanks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.beans.Tank;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class TanksAdapter extends RecyclerView.Adapter<TanksAdapter.VehicleViewHolder> {
    private Context _context;
    private List<Tank> list = new ArrayList<>();

    TanksAdapter(Context context) {
        _context = context;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(_context).inflate(R.layout.holder_vehicle, viewGroup, false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        holder.bind(holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void add(final List<Tank> tanks) {
        list.addAll(tanks);
        notifyItemRangeInserted(list.size() - tanks.size() - 1, tanks.size());
    }

    class VehicleViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout itemView;
        private ImageView imgTank;
        private TextView textName;
        private TextView textTier;
        private TextView textDescription;

        VehicleViewHolder(@NonNull View v) {
            super(v);
            itemView = v.findViewById(R.id.itemView);
            imgTank = v.findViewById(R.id.ic_tank);
            textName = v.findViewById(R.id.text_name);
            textTier = v.findViewById(R.id.text_tier);
            textDescription = v.findViewById(R.id.text_description);
        }

        void bind(int pos) {
            textName.setText(list.get(pos).getName());
            textTier.setText(String.format(_context.getString(R.string.tier_tmpl), list.get(pos).getTier()));
            textDescription.setText(list.get(pos).getDescription());

            Picasso.get().load(list.get(pos).getImage().getBig()).into(imgTank);
        }
    }
}
