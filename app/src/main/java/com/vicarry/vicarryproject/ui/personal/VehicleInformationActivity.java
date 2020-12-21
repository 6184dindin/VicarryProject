package com.vicarry.vicarryproject.ui.personal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.VehicleAttributes;
import com.vicarry.vicarryproject.adapter.VehicleInformationAdapter;
import com.vicarry.vicarryproject.databinding.ActivityVehicleInformationBinding;

import java.util.ArrayList;
import java.util.List;

public class VehicleInformationActivity extends AppCompatActivity {
    ActivityVehicleInformationBinding binding;
    VehicleInformationAdapter adapter;
    List<VehicleAttributes> vehicleAttributesList;
    private static int ADD_VEHICLE_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_vehicle_information);

        vehicleAttributesList = new ArrayList<>();
        settupAdapterVehicleInformation();

        binding.btnAddVehicleInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddVehicleActivity.class);
                startActivityForResult(intent, ADD_VEHICLE_REQUEST_CODE);
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addDataToVehicleAttributesList(){
        vehicleAttributesList.add(new VehicleAttributes("Xe tải thùng lớn", "10 Tấn", "9.25m", "2.36m", "2.41m", "11F1 - 3969"));
        vehicleAttributesList.add(new VehicleAttributes("Xe tải", "8 Tấn", "9.25m", "2.3m", "2.22m", "29C1 - 88888"));
        vehicleAttributesList.add(new VehicleAttributes("Xe ben con", "2 Tấn", "9m", "2.3m", "2.1m", "12B1 - 44444"));
    }

    private void settupAdapterVehicleInformation(){
        addDataToVehicleAttributesList();

        adapter = new VehicleInformationAdapter(vehicleAttributesList, getBaseContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcListVehicleInfo.setLayoutManager(layoutManager);
        binding.rcListVehicleInfo.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}