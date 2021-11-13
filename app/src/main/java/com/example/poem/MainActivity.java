package com.example.poem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity{
    TextView body01,body02;
    Button button01,button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poem_list);

        button01 = (Button)findViewById(R.id.button01);
        button02 = (Button)findViewById(R.id.button02);

        body01 = (TextView) findViewById(R.id.body);
        body02 = (TextView) findViewById(R.id.body2);

        body01.setSingleLine(true);
        body01.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        body01.setSelected(true);

        body02.setSingleLine(true);
        body02.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        body02.setSelected(true);

        button01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        SubActivity2.class);
                startActivity(intent);
            }
        });


        button02.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        SubActivity.class);
                startActivity(intent);
            }
        });



    }
}