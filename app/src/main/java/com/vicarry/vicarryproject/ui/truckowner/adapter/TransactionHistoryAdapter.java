package com.vicarry.vicarryproject.ui.truckowner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ItemRcvThaSuBinding;
import com.vicarry.vicarryproject.ui.truckowner.model.TransactionHistoryObject;

import java.util.List;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder> {
    List<TransactionHistoryObject> objects;
    Context context;

    public TransactionHistoryAdapter(List<TransactionHistoryObject> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRcvThaSuBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_rcv_tha_su, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvTimeTHO.setText(objects.get(position).getTimeTHO());
        holder.binding.tvBankCodeTHO.setText(objects.get(position).getBankCodeTHO());
        holder.binding.tvCodeTHO.setText("REF : " + objects.get(position).getCodeTHO());

        if (objects.get(position).getStatusTHO() == 1) {
            holder.binding.tvStatusTHO.setText("Nạp tiền");
            holder.binding.tvStatusTHO.setBackground(context.getDrawable(R.drawable.btn_blue_su));
            holder.binding.tvPriceTHO.setText("+ " + objects.get(position).getPriceTHO());
        } else if (objects.get(position).getStatusTHO() == 2) {
            holder.binding.tvStatusTHO.setText("Vận chuyển");
            holder.binding.tvStatusTHO.setBackground(context.getDrawable(R.drawable.btn_orange_su));
            holder.binding.tvPriceTHO.setText("- " + objects.get(position).getPriceTHO());
        } else if (objects.get(position).getStatusTHO() == 3) {
            holder.binding.tvStatusTHO.setText("Rút tiền");
            holder.binding.tvStatusTHO.setBackground(context.getDrawable(R.drawable.btn_red_su));
            holder.binding.tvPriceTHO.setText("- " + objects.get(position).getPriceTHO());
        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRcvThaSuBinding binding;

        public ViewHolder(@NonNull ItemRcvThaSuBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
