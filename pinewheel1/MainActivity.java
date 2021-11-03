package com.example.pinewheel1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id가 pinwheel인 이미지를 인식함.
        ImageView iv_pinwheel = (ImageView)findViewById(R.id.pinewheel);

        // 인식한 이미지를 360도 회전시키는 애니메이션 객체 생성
        ObjectAnimator object = ObjectAnimator.ofFloat(iv_pinwheel,"rotation",360);
        object.setInterpolator(new LinearInterpolator()); // 부드럽게 움직이도록
        object.setDuration(2000); // 회전하는데 2초
        object.setRepeatCount(ValueAnimator.INFINITE); // 무한대로 반복
        object.start();

    }
}