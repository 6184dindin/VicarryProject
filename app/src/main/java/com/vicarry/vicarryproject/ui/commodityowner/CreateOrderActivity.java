package com.vicarry.vicarryproject.ui.commodityowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityCreateOrderBinding;

public class CreateOrderActivity extends AppCompatActivity {
    ActivityCreateOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_order);
    }
}