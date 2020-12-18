package com.vicarry.vicarryproject.ui.truckowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityTransactionHistoryBinding;
import com.vicarry.vicarryproject.ui.truckowner.adapter.TransactionHistoryAdapter;
import com.vicarry.vicarryproject.ui.truckowner.model.TransactionHistoryObject;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryActivity extends AppCompatActivity {
    public static final int RECHARGE = 1;
    public static final int TRANSPORT = 2;
    public static final int WHITDRAWAL = 3;

    ActivityTransactionHistoryBinding binding;

    List<TransactionHistoryObject> objects = new ArrayList<>();
    TransactionHistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_transaction_history);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rcvList.setLayoutManager(layoutManager);

        addObject();
        initRecyclerView();
    }

    private void addObject() {
        objects.add(new TransactionHistoryObject("22/11/2020 9:30", "BIDV", "937452123"
                , "1.000.000", RECHARGE));
        objects.add(new TransactionHistoryObject("22/11/2020 7:30", "VICARRY SYSTEM", "VD98432"
                , "200.000", TRANSPORT));
        objects.add(new TransactionHistoryObject("21/11/2020 12:30", "BIDV", "VD97431"
                , "500.000", RECHARGE));
        objects.add(new TransactionHistoryObject("20/11/2020 11:30", "VICARRY SYSTEM", "937452123"
                , "300.000", WHITDRAWAL));
    }

    private void initRecyclerView() {
        adapter = new TransactionHistoryAdapter(objects, this);
        binding.rcvList.setAdapter(adapter);
    }
}