package com.example.poem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity02 extends Activity {
    Button button03,exit_button;
    long backKeyPressedTime;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button03 = (Button)findViewById(R.id.button03);
        exit_button = (Button)findViewById(R.id.exit_button);

        button03.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);
            }
        });

        // 종료 버튼
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // builder 라는 변수 만듦
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity02.this);
                builder.setMessage("정말로 종료하시겠습니까?");
                                    builder.setTitle("종료")
                        .setCancelable(false)
                        .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    finish();
                                }
                            })
                                    .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("종료 알림창");
                alert.show();
            }
        });


    }
    @Override
    // 뒤로가기 버튼 2번 눌렀을때 종료
    public void onBackPressed(){
        // 뒤로가기 버튼 2번의 간격이 2초이상일 경우
        if(System.currentTimeMillis() > backKeyPressedTime +2000){
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this,"뒤로가기를 한번 더 누르면 종료합니다.",Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        // 뒤로가기 버튼 2번을 2초안에 눌렀을 경우에 종료
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000){
            finish();
            toast.cancel();

            // 앱을 완전히 종료
            moveTaskToBack(true);
            finishAndRemoveTask();
            android.os.Process.killProcess(android.os.Process.myPid());
        }

    }
}
