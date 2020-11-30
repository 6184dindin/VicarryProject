package com.vicarry.vicarryproject.ui.commodityowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityHomeCommodityOwnerBinding;

public class HomeCommodityOwnerActivity extends AppCompatActivity {
    ActivityHomeCommodityOwnerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_commodity_owner);
    }
}