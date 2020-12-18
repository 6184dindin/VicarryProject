package com.vicarry.vicarryproject.ui.truckowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivitySetScheduleBinding;
import com.vicarry.vicarryproject.databinding.DialogBtSsaSuBinding;
import com.vicarry.vicarryproject.databinding.DialogDatePickerBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SetScheduleActivity extends AppCompatActivity {
    ActivitySetScheduleBinding binding;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_set_schedule);

        dialog = new Dialog(this);

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.ivDatePickerFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDatePicker(binding.tvDatePickerFrom);
            }
        });

        binding.ivDatePickerTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDatePicker(binding.tvDatePickerTo);
            }
        });
    }

    private void btnDatePicker(TextView textView) {
        DialogDatePickerBinding binding1 = DialogDatePickerBinding.inflate(LayoutInflater.from(this));

        showDialog(binding1);

        binding1.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = binding1.simpleDatePicker.getDayOfMonth();
                int month = binding1.simpleDatePicker.getMonth() + 1;
                int year = binding1.simpleDatePicker.getYear();

                DateFormat df = new SimpleDateFormat("HH:mm");
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                String time = df.format(date);

                String dateTime = day + "/" + month + "/" + year + ", " + time;

                textView.setText(dateTime);
                dialog.dismiss();
            }
        });
    }

    public void btnSetSchedule(View view) {
        DialogBtSsaSuBinding btSsaSuBinding = DialogBtSsaSuBinding.inflate(LayoutInflater.from(this));

        btSsaSuBinding.btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });

        showDialog(btSsaSuBinding);
    }

    private void showDialog(ViewDataBinding binding1) {
        dialog.setContentView(binding1.getRoot());

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        dialog.show();
    }
}