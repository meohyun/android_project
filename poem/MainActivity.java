package com.example.poem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView body01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        body01 = (TextView) findViewById(R.id.body);
        body01.setSingleLine(true);
        body01.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        body01.setSelected(true);
        setContentView(R.layout.activity_main);
    }
}