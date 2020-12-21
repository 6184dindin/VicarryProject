package com.vicarry.vicarryproject.ui.personal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.adapter.ImageVehicleAdapter;
import com.vicarry.vicarryproject.databinding.ActivityAddVehicleBinding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AddVehicleActivity extends AppCompatActivity {
    private static final int SELECT_IMAGE_VEHICLE_REQUEST_CODE = 111;
    private static final int SELECT_IMAGE_VEHICLE_REGISTRATION_REQUEST_CODE = 112;
    ActivityAddVehicleBinding binding;
    private List<Bitmap> listImageVehicle;
    private ImageVehicleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_vehicle);

        listImageVehicle = new ArrayList<>();

        binding.btnAddImageVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageVehicle();
            }
        });

        binding.btnAddImageVehicleRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageVehicleRegistration();
            }
        });

        binding.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addDataForSpinner(){
    }

    private void selectImageVehicle(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE_VEHICLE_REQUEST_CODE);

    }

    private void selectImageVehicleRegistration(){
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, SELECT_IMAGE_VEHICLE_REGISTRATION_REQUEST_CODE);
    }

    private void addListImageVehicle(int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            assert data != null;
            Bitmap bitmap = null;
            if (data.getClipData() != null) {
                ClipData mClipData = data.getClipData();

                for (int i = 0; i < mClipData.getItemCount(); i++) {
                    ClipData.Item item = mClipData.getItemAt(i);
                    Uri uri = item.getUri();
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (listImageVehicle.size() < 10) {
                        listImageVehicle.add(bitmap);
                    } else {
                        break;
                    }
                }
            } else if (data.getData() != null) {
                Uri uri = data.getData();
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (listImageVehicle.size() < 10) {
                    listImageVehicle.add(bitmap);
                }
            }
        }
    }

    private void addListImageVehicleToRecycleView(){
        adapter = new ImageVehicleAdapter(listImageVehicle, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        binding.rcListImageVehicle.setLayoutManager(layoutManager);
        binding.rcListImageVehicle.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SELECT_IMAGE_VEHICLE_REQUEST_CODE:
                addListImageVehicle(resultCode, data);
                addListImageVehicleToRecycleView();
                binding.tvNumberImageSelect.setText("(" + listImageVehicle.size() + "/10)");
                break;
            case SELECT_IMAGE_VEHICLE_REGISTRATION_REQUEST_CODE:
                Uri targetUri = data.getData();
                Bitmap bitmap;
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    binding.imgVehicleRegistration.setLayoutParams(params);
                    binding.layoutUpload.setVisibility(View.GONE);
                    binding.imgDefault.setVisibility(View.GONE);
                    binding.imgVehicleRegistration.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
        }
    }
}