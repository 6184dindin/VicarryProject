package com.vicarry.vicarryproject.ui.commodityowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityCreateOrderBinding;

public class CreateOrderActivity extends AppCompatActivity {
    ActivityCreateOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_order);
        createOrder();
    }
    private void createOrder() {
        binding.layoutInfo1.setVisibility(View.VISIBLE);
        binding.layoutInfo2.setVisibility(View.GONE);
        binding.btnComplete.setText("TIẾP THEO");

        binding.btnBack.setOnClickListener(v -> {
            finish();
        });
        binding.btnComplete.setOnClickListener(v -> {
            closeKeyboard();
            completeOrder();
        });
    }

    private void completeOrder() {
        binding.layoutInfo1.setVisibility(View.GONE);
        binding.layoutInfo2.setVisibility(View.VISIBLE);
        binding.btnComplete.setText("HOÀN THÀNH");

        binding.btnBack.setOnClickListener(v -> {
            closeKeyboard();
            createOrder();
        });
        binding.btnComplete.setOnClickListener(v-> {
            closeKeyboard();
            Toast.makeText(this, "Compelte", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if(view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}