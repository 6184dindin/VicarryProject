package com.vicarry.vicarryproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vicarry.vicarryproject.adapter.ViewPagerAdapter;
import com.vicarry.vicarryproject.databinding.ActivityMainBinding;
import com.vicarry.vicarryproject.fragment.ViewPagerFragment;
import com.vicarry.vicarryproject.ui.start.InputPhoneNumberActivity;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final int COMMODITY_OWNER_KEY = 1;
    private static final int TRUCK_OWNER_KEY = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        createLogo();
        createViewPagerForCommodityOwner();
        createViewPagerForTruckOwner();
        chooseTypeLogin();

    }

    private void chooseTypeLogin(){
        Intent intent = new Intent(getApplicationContext(), InputPhoneNumberActivity.class);

        binding.btnJoinCommodityOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key", COMMODITY_OWNER_KEY);
                startActivity(intent);
            }
        });

        binding.btnJoinTruckOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key", TRUCK_OWNER_KEY);
                startActivity(intent);
            }
        });
    }

    private void createViewPagerForCommodityOwner(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ViewPagerFragment(getDrawable(R.drawable.ic_logistics_pan),"Kết nối chủ xe nhanh chóng, thuận tiện"), "1");
        adapter.addFragment(new ViewPagerFragment(getDrawable(R.drawable.ic_logistics_pan),"Kết nối chủ xe nhanh chóng, thuận tiện"), "2");
        adapter.addFragment(new ViewPagerFragment(getDrawable(R.drawable.ic_logistics_pan),"Kết nối đơn hàng, chủ xe"), "3");
        binding.viewPagerCommodityOwner.setAdapter(adapter);
        binding.tabLayoutCommodityOwner.setupWithViewPager(binding.viewPagerCommodityOwner);
        binding.tabLayoutCommodityOwner.getTabAt(0).setIcon(getDrawable(R.drawable.custom_tablayout_checked_pan));
        binding.tabLayoutCommodityOwner.getTabAt(1).setIcon(getDrawable(R.drawable.custom_tablayout_checked_pan));
        binding.tabLayoutCommodityOwner.getTabAt(2).setIcon(getDrawable(R.drawable.custom_tablayout_checked_pan));
    }

    private void createViewPagerForTruckOwner() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ViewPagerFragment(getDrawable(R.drawable.ic_trolley_pan), "Kết nối đơn hàng phù hợp, tối ưu vận chuyển"), "1");
        adapter.addFragment(new ViewPagerFragment(getDrawable(R.drawable.ic_trolley_pan), "Kết nối chủ xe nhanh chóng, thuận tiện"), "2");
        adapter.addFragment(new ViewPagerFragment(getDrawable(R.drawable.ic_trolley_pan), "Kết nối đơn hàng, chủ xe"), "3");
        binding.viewPagerTruckOwner.setAdapter(adapter);
        binding.tabLayoutTruckOwner.setupWithViewPager(binding.viewPagerTruckOwner);
        binding.tabLayoutTruckOwner.getTabAt(0).setIcon(getDrawable(R.drawable.custom_tablayout_checked_pan));
        binding.tabLayoutTruckOwner.getTabAt(1).setIcon(getDrawable(R.drawable.custom_tablayout_checked_pan));
        binding.tabLayoutTruckOwner.getTabAt(2).setIcon(getDrawable(R.drawable.custom_tablayout_checked_pan));
    }

    private void createLogo(){
//        binding.layoutSum.setWeightSum(100);
//        binding.layoutImage.setWeightSum(100);
        new CountDownTimer(2000, 1000) {

            @Override
            public void onFinish() {
                TransitionManager.beginDelayedTransition(binding.layoutSum, new AutoTransition().setDuration(1000));
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
                params1.weight = 30;
                binding.layoutImage.setLayoutParams(params1);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
                params2.weight = 70;
                binding.imgLogo.setLayoutParams(params2);
                binding.tvTitle.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();
    }

}