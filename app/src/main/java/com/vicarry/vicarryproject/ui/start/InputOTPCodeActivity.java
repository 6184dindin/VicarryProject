package com.vicarry.vicarryproject.ui.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityInputOTPCodeBinding;

public class InputOTPCodeActivity extends AppCompatActivity {
    ActivityInputOTPCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_o_t_p_code);

        moveOnInputNewPasswordActivity();

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void moveOnInputNewPasswordActivity(){
        binding.btnNextResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), InputNewPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}