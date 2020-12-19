package com.vicarry.vicarryproject.ui.commodityowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivitySearchForOrderBinding;
import com.vicarry.vicarryproject.ui.commodityowner.adapter.OrderAdapter;
import com.vicarry.vicarryproject.ui.commodityowner.model.Order;

import java.util.ArrayList;
import java.util.List;

public class SearchForOrderActivity extends AppCompatActivity {
    ActivitySearchForOrderBinding binding;
    OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_for_order);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcListOrder.setLayoutManager(manager);

        binding.btnImgSearch.setOnClickListener(v -> showLayoutSearch());
        binding.btnBack.setOnClickListener(v -> finish());

        showLayoutSearch();
    }

    private void showLayoutSearch() {
        binding.layoutSearch.setVisibility(View.VISIBLE);
        binding.btnImgCancel.setOnClickListener(v -> {
            closeKeyboard();
            binding.layoutSearch.setVisibility(View.GONE);
        });
        binding.btnSearch.setOnClickListener(v -> {
            closeKeyboard();
            handleSearch();
        });
    }

    void setListOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1));
        orders.add(new Order(2));
        orders.add(new Order(3));
        orders.add(new Order(4));
        orders.add(new Order(5));
        orders.add(new Order(6));
        adapter = new OrderAdapter(this, orders);
        binding.rcListOrder.setAdapter(adapter);
    }
    private void handleSearch() {
        binding.rcListOrder.setVisibility(View.VISIBLE);
        setListOrder();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if(view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}