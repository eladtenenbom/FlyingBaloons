package com.example.elad.flyingbaloons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView1 m1 = new MyView1(this);

        setContentView(m1);
    }
}
