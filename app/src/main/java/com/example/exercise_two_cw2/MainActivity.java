package com.example.exercise_two_cw2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.exercise_two_cw2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private ArrayList<Integer> images = new ArrayList<>();

    private RequestOptions requestOptions = new RequestOptions();

    private int currentImageIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        images.add(R.drawable.img_background_1);
        images.add(R.drawable.img_background_2);
        images.add(R.drawable.img_background_3);
        images.add(R.drawable.img_background_4);
        images.add(R.drawable.img_background_5);
        images.add(R.drawable.img_background_6);
        images.add(R.drawable.img_background_7);
        images.add(R.drawable.img_background_8);
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(36));
        setContentView(binding.getRoot());
        initView();
        showImage(0);
    }

    private void initView() {
        binding.btnBack.setOnClickListener(v -> {
            if (currentImageIndex - 1 < 0) {
                currentImageIndex = images.size() - 1;
            } else {
                currentImageIndex = currentImageIndex - 1;
            }
            showImage(currentImageIndex);
        });

        binding.btnNext.setOnClickListener(v -> {
            if (currentImageIndex + 1 > images.size() - 1) {
                currentImageIndex = 0;
            } else {
                currentImageIndex = currentImageIndex + 1;
            }
            showImage(currentImageIndex);
        });
    }

    private void showImage(int index) {
        int imageRes = images.get(index);
        Glide
                .with(this)
                .load(imageRes)
                .centerCrop()
                .apply(requestOptions)
                .into(binding.imvImages);
    }
}
