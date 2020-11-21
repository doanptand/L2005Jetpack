package com.ddona.pokemon.util;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingUtil {

    @BindingAdapter("set_src")
    public static void bindImage(ImageView img, String link) {
        Glide.with(img).load(link).into(img);
    }

//    @BindingAdapter("setTime")
//    public static void setTime(TextView tvTime, long time) {
//        String timeStr = convert(time);
//        tvTime.setText(timeStr);
//    }
}
