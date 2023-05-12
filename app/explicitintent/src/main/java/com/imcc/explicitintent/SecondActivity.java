package com.imcc.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /**
         *  Get Intent value from Intent
         */
        Intent intent = getIntent();
        String myName = intent.getStringExtra("MyName");
        Log.e("SecondActivity", "onCreate: " + myName);
        Toast.makeText(this, myName, Toast.LENGTH_SHORT).show();


        /**
         *  Get Intent value from bundle
         */
//        Bundle bundle = getIntent().getExtras();
//        String myBundleName = bundle.getString("Name");
//        Log.e("SecondActivity", "onCreate: " + myBundleName);
//        Toast.makeText(this, myBundleName, Toast.LENGTH_SHORT).show();
    }
}