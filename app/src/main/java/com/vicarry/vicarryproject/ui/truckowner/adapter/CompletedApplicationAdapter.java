package com.vicarry.vicarryproject.ui.truckowner.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ItemCompletedApplicationBinding;
import com.vicarry.vicarryproject.ui.truckowner.model.CompletedApplicationObject;

import java.util.List;

public class CompletedApplicationAdapter extends RecyclerView.Adapter<CompletedApplicationAdapter.ViewHolder> {
    List<CompletedApplicationObject> completedApplicationObjects;
    Context context;
    IOnClickListenerCAA iOnClickListenerCAA;

    public void setiOnClickListenerCAA(IOnClickListenerCAA iOnClickListenerCAA) {
        this.iOnClickListenerCAA = iOnClickListenerCAA;
    }

    public CompletedApplicationAdapter(List<CompletedApplicationObject> completedApplicationObjects, Context context) {
        this.completedApplicationObjects = completedApplicationObjects;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCompletedApplicationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_completed_application, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position == completedApplicationObjects.size() - 1) {
            holder.binding.viewMarginBottom.setVisibility(View.VISIBLE);
        }
        if (completedApplicationObjects.get(position).getStatusCAO() == 1) {
            holder.binding.tvStatus.setText("Đang đợi chuyến");
            holder.binding.tvStatus.setTextColor(Color.parseColor("#F8810A"));
            holder.binding.tvStatus.setBackground(context.getResources().getDrawable(R.drawable.bg_unfinished_1_su));
        } else if (completedApplicationObjects.get(position).getStatusCAO() == 2 || completedApplicationObjects.get(position).getStatusCAO() == 3) {
            holder.binding.tvStatus.setTextColor(Color.parseColor("#2D68B2"));
            holder.binding.tvStatus.setBackground(context.getResources().getDrawable(R.drawable.bg_unfinished_2_su));
            if (completedApplicationObjects.get(position).getStatusCAO() == 2) {
                holder.binding.tvStatus.setText("Đợi nhận hàng");
            } else {
                holder.binding.tvStatus.setText("Đang chuyển hàng");
            }
        } else {
            holder.binding.tvStatus.setText("Hoàn thành");
            holder.binding.tvStatus.setTextColor(Color.parseColor("#65B768"));
            holder.binding.tvStatus.setBackground(context.getResources().getDrawable(R.drawable.bg_finish_su));
        }

//        holder.binding.tvCity.setText(completedApplicationObjects.get(position).getCityCAO());
//        holder.binding.tvTime.setText(completedApplicationObjects.get(position).getTimeFromCAO() + " - "
//                + completedApplicationObjects.get(position).getTimeToCAO());
//        holder.binding.tvVehicle.setText(completedApplicationObjects.get(position).getNameVehicleCAO());
//        holder.binding.tvLisencePlates.setText(completedApplicationObjects.get(position).getLicensePlatesCAO());
//        holder.binding.tvName.setText(completedApplicationObjects.get(position).getNameCAO());
//        holder.binding.tvPhoneNumeber.setText(completedApplicationObjects.get(position).getPhoneNumeberCAO());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickListenerCAA.ImoveScreenCAA(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return completedApplicationObjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCompletedApplicationBinding binding;

        public ViewHolder(@NonNull ItemCompletedApplicationBinding binding1) {
            super(binding1.getRoot());
            binding = binding1;
        }
    }
}
