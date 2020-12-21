package com.vicarry.vicarryproject.ui.commodityowner.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ItemOrderBinding;
import com.vicarry.vicarryproject.ui.commodityowner.OrderInformationActivity;
import com.vicarry.vicarryproject.ui.commodityowner.model.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    Context context;
    List<Order> orders;

    public OrderAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemOrderBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_order, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);

        holder.binding.id.setText(String.valueOf(order.getId()));
        holder.binding.layoutItem.setOnClickListener(v -> {
            Intent intent = new Intent(context, OrderInformationActivity.class);
            context.startActivity(intent);
        });
        if(position == orders.size() - 1) {
            holder.binding.layoutMarginBottom.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOrderBinding binding;
        public ViewHolder(@NonNull ItemOrderBinding binding1) {
            super(binding1.getRoot());
            binding = binding1;
        }
    }
}
