package com.vicarry.vicarryproject.ui.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityInputPassswordBinding;
import com.vicarry.vicarryproject.ui.commodityowner.HomeCommodityOwnerActivity;
import com.vicarry.vicarryproject.ui.truckowner.completedlist.HomeTruckOwnerActivity;

public class InputPasswordActivity extends AppCompatActivity {
    ActivityInputPassswordBinding binding;
    int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_passsword);
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);

        inputPasswordCorrect();
        moveOnForgotPasswordScreen();

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void inputPasswordCorrect (){
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(key == 1) {
                    intent = new Intent(getBaseContext(), HomeCommodityOwnerActivity.class);
                }
                if(key == 2) {
                    intent = new Intent(getBaseContext(), HomeTruckOwnerActivity.class);
                }
                startActivity(intent);
                finish();
            }
        });
    }

    private void moveOnForgotPasswordScreen(){
        binding.btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveOnOTPActivity();
            }
        });
    }

    private void moveOnOTPActivity(){
        binding.layoutPhoneNumberAccount.setVisibility(View.VISIBLE);
        binding.layoutInputPassword.setVisibility(View.GONE);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), InputOTPCodeActivity.class);
                startActivity(intent);
                new CountDownTimer(1500, 1000){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        binding.layoutPhoneNumberAccount.setVisibility(View.GONE);
                        binding.layoutInputPassword.setVisibility(View.VISIBLE);
                    }
                }.start();
                finish();
            }
        });
    }

}