package com.example.vlad.tankwiki.presentation.tanks.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vlad.tankwiki.R;
import com.example.vlad.tankwiki.data.model.tanks.Tank;
import com.squareup.picasso.Picasso;

public class TanksPagedAdapter extends PagedListAdapter<Tank, TanksPagedAdapter.MyViewHolder> {
    private Context _context;
    private OnTankClickListener _listener;
    private int _selectedPos = RecyclerView.NO_POSITION;
    private int _prevSelectId = (int) RecyclerView.NO_ID;

    public TanksPagedAdapter(Context context, OnTankClickListener listener) {
        super(DIFF_CALLBACK);
        _context = context;
        _listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pos) {
        View view = LayoutInflater.from(_context).inflate(R.layout.holder_tank, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int pos) {
        Tank tank = getItem(holder.getAdapterPosition());
        if (tank != null) {
            holder.bind(tank, holder.getAdapterPosition());
            holder.view.setOnClickListener(v -> onTankClickAction(tank, holder.getAdapterPosition()));
        } else {
            holder.clear();
        }
    }

    private void onTankClickAction(Tank tank, int pos) {
        if (pos == RecyclerView.NO_POSITION) return;

        notifyItemChanged(_selectedPos);
        _selectedPos = pos;
        notifyItemChanged(_selectedPos);

        if (_prevSelectId != tank.getTankId()) {
            _listener.onTankClick(tank);
            _prevSelectId = tank.getTankId();
        }
    }

    private static DiffUtil.ItemCallback<Tank> DIFF_CALLBACK = new DiffUtil.ItemCallback<Tank>() {
        @Override
        public boolean areItemsTheSame(@NonNull Tank oldItem, @NonNull Tank newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tank oldItem, @NonNull Tank newItem) {
            return oldItem.equals(newItem);
        }
    };

    public void resetSelected() {
        _selectedPos = RecyclerView.NO_POSITION;
        _prevSelectId = (int) RecyclerView.NO_ID;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private ImageView imgTank;
        private TextView textName;
        private TextView textTier;
        private TextView textDescription;

        MyViewHolder(@NonNull View v) {
            super(v);
            view = v.findViewById(R.id.parent);
            imgTank = v.findViewById(R.id.ic_tank);
            textName = v.findViewById(R.id.text_name);
            textTier = v.findViewById(R.id.text_tier);
            textDescription = v.findViewById(R.id.text_description);
        }

        void bind(final Tank tank, int pos) {
            textName.setText(tank.getName());
            textTier.setText(String.format(_context.getString(R.string.tier_tmpl), tank.getTier()));
            textDescription.setText(tank.getDescription());

            Picasso.get().load(tank.getImage().getBig()).into(imgTank);

            view.setBackgroundColor(_selectedPos == pos ? ContextCompat.getColor(_context, R.color.rv_selected_color) : Color.TRANSPARENT);
        }

        void clear() {
            view.invalidate();
            imgTank.invalidate();
            textName.invalidate();
            textTier.invalidate();
            textDescription.invalidate();
        }
    }
}
