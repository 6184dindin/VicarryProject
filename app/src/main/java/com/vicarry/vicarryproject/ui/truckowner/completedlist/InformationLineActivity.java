package com.vicarry.vicarryproject.ui.truckowner.completedlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityInformationLineBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InformationLineActivity extends AppCompatActivity {
    ActivityInformationLineBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_information_line);

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}