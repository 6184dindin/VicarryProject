package com.vicarry.vicarryproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.VehicleAttributes;

import java.util.List;

public class VehicleInformationAdapter extends RecyclerView.Adapter<VehicleInformationAdapter.ViewHolder> {
    List<VehicleAttributes> list;
    Context context;

    public VehicleInformationAdapter(List<VehicleAttributes> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rc_vehicle_information, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VehicleAttributes vehicleAttributes = list.get(position);
        holder.vehicleCategory.setText(vehicleAttributes.getVehicleCategory());
        holder.vehicleSize.setText(vehicleAttributes.getWeight() + " | " + "dài " + vehicleAttributes.getLenght() + " x rộng "+ vehicleAttributes.getWidth() + " x cao "+ vehicleAttributes.getHeight());
        holder.licensePlates.setText(vehicleAttributes.getLicensePlates());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView vehicleCategory, vehicleSize, licensePlates;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleCategory = itemView.findViewById(R.id.tvVehicleCategory);
            vehicleSize = itemView.findViewById(R.id.tvVehicleSize);
            licensePlates = itemView.findViewById(R.id.tvLicensePlates);
        }
    }
}
