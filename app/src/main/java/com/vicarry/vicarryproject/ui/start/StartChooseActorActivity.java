package com.vicarry.vicarryproject.ui.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityStartChooseActorBinding;

public class StartChooseActorActivity extends AppCompatActivity {
    ActivityStartChooseActorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start_choose_actor);
    }
}