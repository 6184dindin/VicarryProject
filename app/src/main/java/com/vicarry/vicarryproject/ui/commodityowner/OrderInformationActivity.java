package com.vicarry.vicarryproject.ui.commodityowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityOrderInformationBinding;
import com.vicarry.vicarryproject.databinding.DialogDeleteOrderBinding;
import com.vicarry.vicarryproject.databinding.DialogFindingTruckForOrderBinding;
import com.vicarry.vicarryproject.databinding.DialogRetryAnotherTimeBinding;
import com.vicarry.vicarryproject.databinding.DialogRetryBinding;

public class OrderInformationActivity extends AppCompatActivity {
    ActivityOrderInformationBinding binding;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_information);

        dialog = new Dialog(this);

        seeDetails();
        binding.btnLayoutDeleteOrder.setOnClickListener(v -> {
            showDialogDeleteOrder();
        });

        binding.btnBookTruck.setOnClickListener(v -> {
            showDialogFindingTruck();
        });

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

    private void showDialogDeleteOrder() {
        DialogDeleteOrderBinding binding = DialogDeleteOrderBinding.inflate(LayoutInflater.from(this));
        binding.btnConfirm.setOnClickListener(v -> {
            dialog.dismiss();
            finish();
        });
        showDialog(binding);
    }

    private void showDialogFindingTruck() {
        DialogFindingTruckForOrderBinding binding = DialogFindingTruckForOrderBinding.inflate(LayoutInflater.from(this));
        binding.btnCancel.setOnClickListener(v -> {
            dialog.dismiss();
        });

        new CountDownTimer(2000, 1000) {

            @Override
            public void onFinish() {
                showDialogRetryAnotherTime();
            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

        showDialog(binding);
    }

    private void showDialogRetryAnotherTime() {
        DialogRetryAnotherTimeBinding binding = DialogRetryAnotherTimeBinding.inflate(LayoutInflater.from(this));
        binding.btnRetry.setOnClickListener(v -> {
            dialog.dismiss();
            showDialogRetry();
        });
        binding.btnRetryAnotherTime.setOnClickListener(v -> {
            dialog.dismiss();
        });
        showDialog(binding);
    }

    private void showDialogRetry() {
        DialogRetryBinding binding = DialogRetryBinding.inflate(LayoutInflater.from(this));
        binding.btnRetry.setOnClickListener(v -> {
            dialog.dismiss();
        });
        showDialog(binding);
    }

    private void showDialog(ViewDataBinding binding) {
        dialog.setContentView(binding.getRoot());

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        dialog.show();
    }
}