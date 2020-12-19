package com.vicarry.vicarryproject.ui.commodityowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityHomeCommodityOwnerBinding;
import com.vicarry.vicarryproject.ui.commodityowner.adapter.OrderAdapter;
import com.vicarry.vicarryproject.ui.commodityowner.model.Order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeCommodityOwnerActivity extends AppCompatActivity {
    ActivityHomeCommodityOwnerBinding binding;
    OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_commodity_owner);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcListOrder.setLayoutManager(manager);

        setSpinnerDemo();
        setListOrder();

        binding.btnImgAdd.setOnClickListener(v -> {
            Intent intent = new Intent(HomeCommodityOwnerActivity.this, CreateOrderActivity.class);
            startActivity(intent);
        });

        binding.btnImgSearch.setOnClickListener(v -> {
            Intent intent = new Intent(HomeCommodityOwnerActivity.this, SearchForOrderActivity.class);
            startActivity(intent);
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

    void setSpinnerDemo() {
        List<String> stringsDate = new ArrayList<>();
        stringsDate.add("Hôm nay");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                stringsDate);
        adapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item));
        binding.spinner.setAdapter(adapter);
    }
}