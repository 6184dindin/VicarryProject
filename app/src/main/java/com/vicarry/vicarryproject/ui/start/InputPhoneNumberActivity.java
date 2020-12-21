package com.vicarry.vicarryproject.ui.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityInputPhoneNumberBinding;

public class InputPhoneNumberActivity extends AppCompatActivity {
    ActivityInputPhoneNumberBinding binding;
    int key;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_phone_number);

        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(), InputPasswordActivity.class);
                intent1.putExtra("key", key);
                startActivity(intent1);
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etPhoneNumber.setText("");
            }
        });

        binding.etPhoneNumber.addTextChangedListener(textChange);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private TextWatcher textChange = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String phoneNumber = binding.etPhoneNumber.getText().toString();
            String temp = "";
            if(!phoneNumber.isEmpty()){
                binding.btnCancel.setVisibility(View.VISIBLE);
                binding.tvHintPhoneNumber.setVisibility(View.GONE);
            }else {
                binding.btnCancel.setVisibility(View.GONE);
                binding.tvHintPhoneNumber.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}