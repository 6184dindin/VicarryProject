package com.vicarry.vicarryproject.ui.truckowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityTransactionHistoryBinding;

public class TransactionHistoryActivity extends AppCompatActivity {
    ActivityTransactionHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_transaction_history);
    }
}