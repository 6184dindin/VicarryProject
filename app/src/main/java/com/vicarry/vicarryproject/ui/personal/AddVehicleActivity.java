package com.vicarry.vicarryproject.ui.personal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityAddVehicleBinding;

public class AddVehicleActivity extends AppCompatActivity {
    ActivityAddVehicleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_vehicle);
    }
}