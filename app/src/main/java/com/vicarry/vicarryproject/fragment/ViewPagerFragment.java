package com.vicarry.vicarryproject.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.vicarry.vicarryproject.R;
import com.vicarry.vicarryproject.databinding.FragmentViewpagerItemBinding;

public class ViewPagerFragment extends Fragment {
    FragmentViewpagerItemBinding binding;
    Drawable drawable;
    String text;

    public ViewPagerFragment(Drawable drawable, String text) {
        this.drawable = drawable;
        this.text = text;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_viewpager_item, container, false);
        binding.imgImage.setImageDrawable(drawable);
        binding.tvText.setText(text);
        return binding.getRoot();
    }
}
