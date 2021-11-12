package com.example.poem;

import android.app.Activity;
import android.os.Bundle;

public class SubActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poem_frost);
    }
}
