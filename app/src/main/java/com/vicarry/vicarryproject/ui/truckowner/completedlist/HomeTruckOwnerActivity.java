package com.vicarry.vicarryproject.ui.truckowner.completedlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityHomeTruckOwnerBinding;
import com.vicarry.vicarryproject.databinding.DialogRcvHtoaFinishSuBinding;
import com.vicarry.vicarryproject.databinding.DialogRcvHtoaReceiveSuBinding;
import com.vicarry.vicarryproject.databinding.DialogRcvHtoaWaitingSuBinding;
import com.vicarry.vicarryproject.ui.commodityowner.OrderInformationActivity;
import com.vicarry.vicarryproject.ui.personal.PersonalAccountActivity;
import com.vicarry.vicarryproject.ui.truckowner.SetScheduleActivity;
import com.vicarry.vicarryproject.ui.truckowner.adapter.CompletedApplicationAdapter;
import com.vicarry.vicarryproject.ui.truckowner.adapter.IOnClickListenerCAA;
import com.vicarry.vicarryproject.ui.truckowner.model.CompletedApplicationObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeTruckOwnerActivity extends AppCompatActivity {
    public static final int SET_SCHEDULE_REQUEST = 1;
    public static final int INFORMATION_LINE_REQUEST = 2;

    public static final int WAITING = 1;
    public static final int RECEIVED = 2;
    public static final int DELIVERED = 3;
    public static final int FINISHED = 4;

    ActivityHomeTruckOwnerBinding binding;

    List<String> listSpinner;
    List<CompletedApplicationObject> completedApplicationObjects = new ArrayList<>();

    CompletedApplicationAdapter adapter;

    Dialog dialog;

    boolean checkBtnShowWallet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_truck_owner);

        dialog = new Dialog(this);

        binding.btnImgPersonalInfo.setOnClickListener(v -> {
            Intent intent = new Intent(HomeTruckOwnerActivity.this, PersonalAccountActivity.class);
            intent.putExtra("key",2);
            startActivity(intent);
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcvList.setLayoutManager(layoutManager);

        addRCV();
        handingSpinner(completedApplicationObjects);
    }

    private void handingSpinner(List<CompletedApplicationObject> completedApplicationObjects) {
        String[] listspn = {"Đang đợi đơn hàng", "Đơn hàng đã nhận", "Đơn hàng đang chuyển", "Đơn hàng hoàn thành"};
        listSpinner = new ArrayList<>(Arrays.asList(listspn));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                listSpinner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnList.setAdapter(adapter);

        binding.spnList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                handingItemSelectedSpinner(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void handingItemSelectedSpinner(int position) {

        List<CompletedApplicationObject> cAObject = new ArrayList<>();
        for (CompletedApplicationObject object : completedApplicationObjects) {
            if (position == 0 && object.getStatusCAO() == WAITING) {
                cAObject.add(object);
            } else if (position == 1 && object.getStatusCAO() == RECEIVED) {
                cAObject.add(object);
            } else if (position == 2 && object.getStatusCAO() == DELIVERED) {
                cAObject.add(object);
            } else if (position == 3 && object.getStatusCAO() == FINISHED) {
                cAObject.add(object);
            }
        }

        initRecyclerView(completedApplicationObjects);
    }

    private void addRCV() {
        completedApplicationObjects.add(new CompletedApplicationObject("24/10/2020", "Đà Nẵng",
                "23/10/2020, 14:30", "24/10/2020, 14:30", "Xe tải mui bạt",
                "30A 234.98", "Lê Minh Quý", "0909.654.213", 1));
        completedApplicationObjects.add(new CompletedApplicationObject(null, "Đà Nẵng",
                "23/10/2020, 14:30", "24/10/2020, 14:30", "Xe tải mui bạt",
                "30A 234.98", "Lê Minh Quý", "0909.654.213", 2));
        completedApplicationObjects.add(new CompletedApplicationObject(null, "Đà Nẵng",
                "23/10/2020, 14:30", "24/10/2020, 14:30", "Xe tải mui bạt",
                "30A 234.98", "Lê Minh Quý", "0909.654.213", 3));
        completedApplicationObjects.add(new CompletedApplicationObject(null, "Đà Nẵng",
                "23/10/2020, 14:30", "24/10/2020, 14:30", "Xe tải mui bạt",
                "30A 234.98", "Lê Minh Quý", "0909.654.213", 4));
        completedApplicationObjects.add(new CompletedApplicationObject(null, "Đà Nẵng",
                "23/10/2020, 14:30", "24/10/2020, 14:30", "Xe tải mui bạt",
                "30A 234.98", "Lê Minh Quý", "0909.654.213", 3));
        completedApplicationObjects.add(new CompletedApplicationObject(null, "Đà Nẵng",
                "23/10/2020, 14:30", "24/10/2020, 14:30", "Xe tải mui bạt",
                "30A 234.98", "Lê Minh Quý", "0909.654.213", 4));
    }

    private void initRecyclerView(List<CompletedApplicationObject> completedApplicationObjects) {
        adapter = new CompletedApplicationAdapter(completedApplicationObjects, getBaseContext());
        adapter.setiOnClickListenerCAA(new IOnClickListenerCAA() {
            @Override
            public void ImoveScreenCAA(int pss) {
                if (completedApplicationObjects.get(pss).getStatusCAO() == FINISHED) {
                    startActivityForResult(new Intent(HomeTruckOwnerActivity.this, OrderInformationActivity.class), INFORMATION_LINE_REQUEST);
                } else if (completedApplicationObjects.get(pss).getStatusCAO() == DELIVERED) {
                    handingItemDialogDelivered();
                } else if (completedApplicationObjects.get(pss).getStatusCAO() == RECEIVED) {
                    handingItemDialogReceive();
                } else if (completedApplicationObjects.get(pss).getStatusCAO() == WAITING) {
                    handingItemDialogWaiting();
                }
            }
        });
        binding.rcvList.setAdapter(adapter);
    }

    //Dialog Waiting
    private void handingItemDialogWaiting() {
        DialogRcvHtoaWaitingSuBinding binding1 = DialogRcvHtoaWaitingSuBinding.inflate(LayoutInflater.from(HomeTruckOwnerActivity.this));

        showDialog(binding1);

        binding1.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        handingDialogOrder(binding1);
    }

    private void countDownDialog(int time, DialogRcvHtoaWaitingSuBinding binding, String text, int filedActive) {
        if (time < 0) {
            dialog.dismiss();
            return;
        }

        binding.btnNext.setText(text + " (" + time + "s)");

        CountDownTimer countDownTimer = new CountDownTimer(1000, 1000) {
            public void onFinish() {
                countDownDialog(time - 1, binding, text, filedActive);
            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        };
        countDownTimer.start();

        binding.btnNext.setOnClickListener(v -> {
            countDownTimer.cancel();

            if (filedActive == 0) {
                handingDialogChooseVehicle(binding);
            }
            if (filedActive == 1) {
                handingDialogDetail(binding);
            }
        });
    }

    private void handingDialogOrder(@NonNull DialogRcvHtoaWaitingSuBinding binding1) {
        countDownDialog(90, binding1, "Nhận ngay", 0);
    }

    private void handingDialogChooseVehicle(@NonNull DialogRcvHtoaWaitingSuBinding binding1) {
        binding1.tvTitle.setText("CHỌN XE");

        binding1.llContent1.setVisibility(View.GONE);
        binding1.llContent2.setVisibility(View.VISIBLE);

        countDownDialog(60, binding1, "Xong", 1);
    }

    private void handingDialogDetail(@NonNull DialogRcvHtoaWaitingSuBinding binding1) {
        binding1.tvTitle.setText("CHI TIẾT");
        binding1.btnNext.setText("Xong");

        binding1.llContent2.setVisibility(View.GONE);
        binding1.llContent3.setVisibility(View.VISIBLE);

        binding1.btnNext.setOnClickListener(v -> dialog.dismiss());
    }

    private void showDialog(ViewDataBinding binding1) {
        dialog.setContentView(binding1.getRoot());

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        dialog.show();
    }

    //Dialog Receive
    private void handingItemDialogReceive() {
        DialogRcvHtoaReceiveSuBinding binding1 = DialogRcvHtoaReceiveSuBinding.inflate(LayoutInflater.from(HomeTruckOwnerActivity.this));

        showDialog(binding1);

        binding1.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        binding1.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    //Dialog Delivered
    private void handingItemDialogDelivered() {
        DialogRcvHtoaFinishSuBinding binding1 = DialogRcvHtoaFinishSuBinding.inflate(LayoutInflater.from(HomeTruckOwnerActivity.this));

        showDialog(binding1);

        binding1.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        binding1.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public void btnShowWallet(View view) {
        if (!checkBtnShowWallet) {
            TransitionManager.beginDelayedTransition(binding.layoutPrice, new AutoTransition().setDuration(250));
            checkBtnShowWallet = true;

//            binding.tvPrice.setLayoutParams(params);

//            binding.tvPrice.setAnimation(AnimationUtils.loadAnimation(HomeTruckOwnerActivity.this,
//                    R.anim.right_left_animation));
            binding.btnImgPrice.setImageDrawable(getResources().getDrawable(R.drawable.ic_wallet_1));
            binding.tvPrice.setVisibility(View.VISIBLE);


            new CountDownTimer(2800, 1000) {
                public void onFinish() {
                    TransitionManager.beginDelayedTransition(binding.layoutPrice, new AutoTransition().setDuration(500));
                    binding.btnImgPrice.setImageDrawable(getResources().getDrawable(R.drawable.ic_wallet_2));
                    binding.tvPrice.setVisibility(View.GONE);
                    checkBtnShowWallet = false;
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                }
            }.start();
        }
    }

    public void btnMoveScreenSetSchedule(View view) {
        startActivityForResult(new Intent(HomeTruckOwnerActivity.this, SetScheduleActivity.class), SET_SCHEDULE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}