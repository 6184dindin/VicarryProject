package com.vicarry.vicarryproject.ui.commodityowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityOrderInformationBinding;

public class OrderInformationActivity extends AppCompatActivity {
    ActivityOrderInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_information);
        seeDetails();
    }

    private void seeDetails() {
        TransitionManager.beginDelayedTransition(binding.layoutInformation, new AutoTransition().setDuration(300));
        binding.layoutInfo1.setVisibility(View.VISIBLE);
        binding.layoutInfo2.setVisibility(View.GONE);
        binding.btnSeeDetails.setOnClickListener(v -> showMap());
        binding.btnBack.setOnClickListener(v -> finish());
    }

    private void showMap() {
        TransitionManager.beginDelayedTransition(binding.layoutInformation, new AutoTransition().setDuration(300));
        binding.layoutInfo1.setVisibility(View.GONE);
        binding.layoutInfo2.setVisibility(View.VISIBLE);
        binding.btnShowMap.setOnClickListener(v -> seeDetails());
        binding.btnBack.setOnClickListener(v -> seeDetails());
    }
}