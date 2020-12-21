package com.vicarry.vicarryproject.ui.truckowner.orderhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityInformationOrderBinding;

public class InformationOrderActivity extends AppCompatActivity {
    ActivityInformationOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_information_order);

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}