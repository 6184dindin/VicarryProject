package com.vicarry.vicarryproject.ui.truckowner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ItemOrderHistoryBinding;
import com.vicarry.vicarryproject.ui.truckowner.model.OrderHistoryObject;

import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder> {
    List<OrderHistoryObject> objects;
    IOnClickListenerObject listenerOHA;

    public OrderHistoryAdapter(List<OrderHistoryObject> objects, IOnClickListenerObject listenerOHA) {
        this.objects = objects;
        this.listenerOHA = listenerOHA;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOrderHistoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_order_history, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvID.setText(objects.get(position).getIdOHO());
        holder.binding.tvPrice.setText(objects.get(position).getPriceOHO() + " VND");
        holder.binding.tvAddressFrom.setText(objects.get(position).getAddressFromOHO());
        holder.binding.tvAddressTo.setText(objects.get(position).getAddressToOHO());
        holder.binding.tvTime.setText(objects.get(position).getTimeOHO());
        holder.binding.tvMass.setText(objects.get(position).getMassOHO());
        holder.binding.tvProduct.setText(objects.get(position).getProductOHO());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerOHA.ImoveScreen(objects.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOrderHistoryBinding binding;

        public ViewHolder(@NonNull ItemOrderHistoryBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
