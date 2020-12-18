package com.vicarry.vicarryproject.ui.truckowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityWithdrawMoneyBinding;
import com.vicarry.vicarryproject.databinding.DialogRcvWmaSuBinding;

import java.util.StringTokenizer;

public class WithdrawMoneyActivity extends AppCompatActivity {
    ActivityWithdrawMoneyBinding binding;

    Dialog dialog;

    private String current = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_withdraw_money);

        dialog = new Dialog(this);

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.edtPrice.getText().toString().trim().equals("")
                        || binding.edtInformationAccount.getText().toString().trim().equals("")) {
                    binding.tvError.setVisibility(View.VISIBLE);
                } else {
                    binding.tvError.setVisibility(View.GONE);
                    showDialog();
                }
            }
        });

        binding.edtPrice.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().equals(current)) {
                return;
            }

            String text = "";

            StringTokenizer token = new StringTokenizer(s.toString(), ".");

            while (token.hasMoreTokens()) {
                text += token.nextToken();
            }

            if (text.equals("0")) {
                text = "";
            }

            String firstText = "";
            String middleText = "";
            String lastText = "";

            String textFinish = "";


            if (text.trim().length() < 4 && text.trim().length() > 0) {
                textFinish = text;
            } else if (text.trim().length() >= 4 && text.trim().length() < 7) {
                firstText = text.substring(0, text.length() - 3);
                middleText = text.substring(text.length() - 3);
                textFinish = firstText + "." + middleText;
            } else if (text.trim().length() >= 7) {
                if (Integer.parseInt(text) > 1200000 && text.trim().length() == 7) {
                    middleText = text.substring(0, 3);
                    lastText = text.substring(3, 6);
                    textFinish = middleText + "." + lastText;
                } else {
                    firstText = text.substring(0, 1);
                    middleText = text.substring(1, 4);
                    lastText = text.substring(4, 7);
                    textFinish = firstText + "." + middleText + "." + lastText;
                }
            }

            current = textFinish;
            binding.edtPrice.setText(current);
            binding.edtPrice.setSelection(current.length());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void showDialog() {
        DialogRcvWmaSuBinding binding1 = DialogRcvWmaSuBinding.inflate(LayoutInflater.from(WithdrawMoneyActivity.this));

        dialog.setContentView(binding1.getRoot());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        binding1.tvDialogPrice.setText(binding.edtPrice.getText().toString().trim() + " VND");

        binding1.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}