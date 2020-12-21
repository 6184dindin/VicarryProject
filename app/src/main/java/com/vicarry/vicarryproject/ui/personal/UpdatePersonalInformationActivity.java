package com.vicarry.vicarryproject.ui.personal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.ActivityUpdatePersonalInformationBinding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.graphics.Color.TRANSPARENT;

public class UpdatePersonalInformationActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST_CODE = 111;
    private static final int ACCESS_IMAGE_GALLERY_REQUEST_CODE = 112;
    ActivityUpdatePersonalInformationBinding binding;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_personal_information);

        dialog = new Dialog(this);

        binding.checkboxAddInfoBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.checkboxAddInfoBusiness.isChecked()) {
                    TransitionManager.beginDelayedTransition(binding.linearLayout, new AutoTransition());
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    binding.layoutAddInfoBusiness.setLayoutParams(params);
                } else {
                    TransitionManager.beginDelayedTransition(binding.linearLayout, new AutoTransition());
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
                    binding.layoutAddInfoBusiness.setLayoutParams(params);
                }
            }
        });

        //add avatar
        binding.btnAddAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogAddImage();
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnUpdatePersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void openDialogAddImage() {
        dialog.setContentView(R.layout.dialog_add_image_avatar);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.btnSelectImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.findViewById(R.id.btnLibrary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageGallery();
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white2)));
        dialog.show();
    }

    private void openCamera() {
        if (ContextCompat.checkSelfPermission(UpdatePersonalInformationActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(UpdatePersonalInformationActivity.this, new String[]{Manifest.permission.CAMERA}, 100);
        }
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
    }

    public void openImageGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, ACCESS_IMAGE_GALLERY_REQUEST_CODE);
    }

    private Bitmap bmImage;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CAMERA_REQUEST_CODE:
                if(data == null) {
                    break;
                }
                bmImage = (Bitmap) data.getExtras().get("data");
                    binding.imgAvatar.setImageBitmap(bmImage);
                break;
            case ACCESS_IMAGE_GALLERY_REQUEST_CODE:
                if(data == null) {
                    break;
                }
                Uri targetUri = data.getData();
                try {
                    bmImage = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bmImage.compress(Bitmap.CompressFormat.JPEG, 50, baos);
                    binding.imgAvatar.setImageBitmap(bmImage);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}