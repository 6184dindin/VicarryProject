package com.vicarry.vicarryproject.ui.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityInputNewPasswordBinding;

public class InputNewPasswordActivity extends AppCompatActivity {
    ActivityInputNewPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_new_password);

        successCreateNewPassword();

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void successCreateNewPassword() {
        binding.btnNextResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.etNewPassword.getText().toString().length() < 8) {
                    Toast.makeText(InputNewPasswordActivity.this, "Mật khẩu phải có ít nhất 8 ký tự !", Toast.LENGTH_SHORT).show();

                } else if (!binding.etNewPassword.getText().toString().equals(binding.etConfirmNewPassword.getText().toString())) {
                    Toast.makeText(InputNewPasswordActivity.this, "Mật khẩu xác nhận không chính xác !", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(getBaseContext(), InputPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}