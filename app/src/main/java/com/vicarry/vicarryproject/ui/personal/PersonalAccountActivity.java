package com.vicarry.vicarryproject.ui.personal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityPersonalAccountBinding;
import com.vicarry.vicarryproject.ui.truckowner.TransactionHistoryActivity;
import com.vicarry.vicarryproject.ui.truckowner.orderhistory.OrderHistoryActivity;

public class PersonalAccountActivity extends AppCompatActivity {
    ActivityPersonalAccountBinding binding;
    int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_personal_account);

        Intent mIntent = getIntent();
        key = mIntent.getIntExtra("key", 0);

        if(key == 1) {
            binding.layoutInformationForTruckOwner.setVisibility(View.GONE);
        }

        if(key == 2) {
            binding.layoutInformationForTruckOwner.setVisibility(View.VISIBLE);
        }

        binding.btnPersonalInformation.setOnClickListener(v -> {
            Intent intent = new Intent(PersonalAccountActivity.this, UpdatePersonalInformationActivity.class);
            startActivity(intent);
        });

        binding.btnTransportInformation.setOnClickListener(v -> {
            Intent intent = new Intent(PersonalAccountActivity.this, TransportInformationActivity.class);
            startActivity(intent);
        });

        binding.btnVehicleInformation.setOnClickListener(v -> {
            Intent intent = new Intent(PersonalAccountActivity.this, VehicleInformationActivity.class);
            startActivity(intent);
        });

        binding.btnTransactionHistory.setOnClickListener(v -> {
            Intent intent = new Intent(PersonalAccountActivity.this, TransactionHistoryActivity.class);
            startActivity(intent);
        });

        binding.btnOurActivity.setOnClickListener(v -> {
            Intent intent = new Intent(PersonalAccountActivity.this, OrderHistoryActivity.class);
            startActivity(intent);
        });

        binding.btnBack.setOnClickListener(v -> finish());
    }
}