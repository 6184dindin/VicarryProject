package com.vicarry.vicarryproject.ui.truckowner.orderhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityOrderHistoryBinding;
import com.vicarry.vicarryproject.ui.commodityowner.OrderInformationActivity;
import com.vicarry.vicarryproject.ui.truckowner.adapter.IOnClickListenerObject;
import com.vicarry.vicarryproject.ui.truckowner.adapter.OrderHistoryAdapter;
import com.vicarry.vicarryproject.ui.truckowner.model.OrderHistoryObject;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryActivity extends AppCompatActivity implements IOnClickListenerObject {
    ActivityOrderHistoryBinding binding;

    List<OrderHistoryObject> objects = new ArrayList<>();

    OrderHistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_history);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcvList.setLayoutManager(layoutManager);

        addOHO();
        initRecyclerView();

        binding.btnImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addOHO() {
        objects.add(new OrderHistoryObject("#VD139305", "8.000.000", "Lào cai"
                , "Hà Nội", "12/10/2020 , 12:30 PM", "10 Tấn", "Sắt thành phẩm", true));
        objects.add(new OrderHistoryObject("#VD129305", "24.000.000", "Hồ Chí Minh"
                , "Hà Nội", "12/10/2020 , 12:30 PM", "10 Tấn", "Sắt thành phẩm", true));
        objects.add(new OrderHistoryObject("#VD139305", "8.000.000", "Điện Biên"
                , "Hà Nội", "12/10/2020 , 12:30 PM", "10 Tấn", "Sắt thành phẩm", true));
        objects.add(new OrderHistoryObject("#VD139305", "15.000.000", "Nha Trang"
                , "Hà Nội", "12/10/2020 , 12:30 PM", "10 Tấn", "Sắt thành phẩm", true));
        objects.add(new OrderHistoryObject("#VD139305", "15.000.000", "Nha Trang"
                , "Hà Nội", "12/10/2020 , 12:30 PM", "10 Tấn", "Sắt thành phẩm", true));
        objects.add(new OrderHistoryObject("#VD139305", "15.000.000", "Nha Trang"
                , "Hà Nội", "12/10/2020 , 12:30 PM", "10 Tấn", "Sắt thành phẩm", true));
    }

    private void initRecyclerView() {
        adapter = new OrderHistoryAdapter(objects, this);
        binding.rcvList.setAdapter(adapter);
    }

    @Override
    public void ImoveScreen(Object object) {
        startActivity(new Intent(OrderHistoryActivity.this, OrderInformationActivity.class));
    }
}