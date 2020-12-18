package com.vicarry.vicarryproject.ui.truckowner.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ItemRcvHtoaSuBinding;
import com.vicarry.vicarryproject.ui.truckowner.model.CompletedApplicationObject;

import java.util.List;

public class CompletedApplicationAdapter extends RecyclerView.Adapter<CompletedApplicationAdapter.ViewHolder> {
    List<CompletedApplicationObject> completedApplicationObjects;
    IOnClickListenerCAA iOnClickListenerCAA;

    public void setiOnClickListenerCAA(IOnClickListenerCAA iOnClickListenerCAA) {
        this.iOnClickListenerCAA = iOnClickListenerCAA;
    }

    public CompletedApplicationAdapter(List<CompletedApplicationObject> completedApplicationObjects) {
        this.completedApplicationObjects = completedApplicationObjects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRcvHtoaSuBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_rcv_htoa_su, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (completedApplicationObjects.get(position).getStatusCAO() == 1) {
            holder.itemRcvHtoaSuBinding.tvTime.setVisibility(View.GONE);

            holder.itemRcvHtoaSuBinding.tvStatus.setText("Đang đợi chuyến");
            holder.itemRcvHtoaSuBinding.tvStatus.setTextColor(Color.parseColor("#F8810A"));
            holder.itemRcvHtoaSuBinding.tvStatus.setBackgroundResource(R.drawable.bg_unfinished_1_su);
        } else if (completedApplicationObjects.get(position).getStatusCAO() == 2 || completedApplicationObjects.get(position).getStatusCAO() == 3) {
            holder.itemRcvHtoaSuBinding.tvTime.setVisibility(View.GONE);

            holder.itemRcvHtoaSuBinding.tvStatus.setTextColor(Color.parseColor("#2D68B2"));
            holder.itemRcvHtoaSuBinding.tvStatus.setBackgroundResource(R.drawable.bg_unfinished_2_su);
            if (completedApplicationObjects.get(position).getStatusCAO() == 2) {
                holder.itemRcvHtoaSuBinding.tvStatus.setText("Đợi nhận hàng");
            } else {
                holder.itemRcvHtoaSuBinding.tvStatus.setText("Đang chuyển hàng");
            }
        } else {
            holder.itemRcvHtoaSuBinding.tvTime.setText(completedApplicationObjects.get(position).getTimeCAO());

            holder.itemRcvHtoaSuBinding.tvStatus.setText("Hoàn thành");
            holder.itemRcvHtoaSuBinding.tvStatus.setTextColor(Color.parseColor("#65B768"));
            holder.itemRcvHtoaSuBinding.tvStatus.setBackgroundResource(R.drawable.bg_finish_su);
        }

        holder.itemRcvHtoaSuBinding.tvCity.setText(completedApplicationObjects.get(position).getCityCAO());
        holder.itemRcvHtoaSuBinding.tvTimeFromTo.setText(completedApplicationObjects.get(position).getTimeFromCAO() + " - "
                + completedApplicationObjects.get(position).getTimeToCAO());
        holder.itemRcvHtoaSuBinding.tvVehicle.setText(completedApplicationObjects.get(position).getNameVehicleCAO());
        holder.itemRcvHtoaSuBinding.tvLisencePlates.setText(completedApplicationObjects.get(position).getLicensePlatesCAO());
        holder.itemRcvHtoaSuBinding.tvName.setText(completedApplicationObjects.get(position).getNameCAO());
        holder.itemRcvHtoaSuBinding.tvPhoneNumeber.setText(completedApplicationObjects.get(position).getPhoneNumeberCAO());

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
        ItemRcvHtoaSuBinding itemRcvHtoaSuBinding;

        public ViewHolder(@NonNull ItemRcvHtoaSuBinding itemRcvHtoaSuBinding1) {
            super(itemRcvHtoaSuBinding1.getRoot());
            itemRcvHtoaSuBinding = itemRcvHtoaSuBinding1;
        }
    }
}
