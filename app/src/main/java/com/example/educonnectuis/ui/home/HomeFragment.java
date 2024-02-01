package com.example.educonnectuis.ui.home;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.example.educonnectuis.R;
import com.google.android.material.slider.Slider;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ImageSlider image_slider;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        image_slider = view.findViewById(R.id.image_slider);
        map = view.findViewById(R.id.map);


        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.school, "UNIQUE INTERNATIONAL SCHOOL.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.school, "TESTING....",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.school, "TESTING....", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.school, "TESTING....",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.school, "TESTING....", ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Unique International School");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}