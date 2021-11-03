package com.example.followme1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {

    ImageView iv_smile ;
    float previous_x = 0;
    float previous_y = 0;
    Vibrator mVibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //화면 FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        iv_smile = (ImageView) findViewById(R.id.smile);

        // 진동을 위해 하드웨어에 접근이 가능한 진동 객체 생성
        mVibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


    }
    // 터치 시에 시스템에 의해 호출됨
    @Override
    public boolean onTouchEvent(MotionEvent event){


        switch(event.getAction()){
            // 누르기 시작할때
            case MotionEvent.ACTION_DOWN:
            break;

            // 움직일때
            case MotionEvent.ACTION_MOVE:
                int touch_x = (int)event.getX();
                int touch_y = (int)event.getY();

                ObjectAnimator smileX = ObjectAnimator.ofFloat(iv_smile,"translationX", previous_x,touch_x);

                smileX.start();

                ObjectAnimator smileY = ObjectAnimator.ofFloat(iv_smile,"translationY",previous_y,touch_y);

                smileY.start();

                mVibe.vibrate(50);

                previous_x = touch_x;
                previous_y = touch_y;
                break;

            // 터치 후 손을 뗄때
            case MotionEvent.ACTION_UP:
                break;
        }

        return false;

    }
}