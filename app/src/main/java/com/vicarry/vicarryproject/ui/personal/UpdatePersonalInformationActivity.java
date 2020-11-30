package com.vicarry.vicarryproject.ui.personal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityUpdatePersonalInformationBinding;

public class UpdatePersonalInformationActivity extends AppCompatActivity {
    ActivityUpdatePersonalInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_personal_information);
    }
}