package com.example.poem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView body01,body02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        body01 = (TextView) findViewById(R.id.body);
        body02 = (TextView) findViewById(R.id.body2);

        body01.setSingleLine(true);
        body01.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        body01.setSelected(true);

        body02.setSingleLine(true);
        body02.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        body02.setSelected(true);

    }
}
