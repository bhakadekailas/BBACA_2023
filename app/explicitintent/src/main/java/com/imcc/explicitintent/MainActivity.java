package com.imcc.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonNext);

        button.setOnClickListener(view -> {

            /*
             *  Start Second Activity using intent
             */
//            Intent intent = new Intent(this, SecondActivity.class);
//            startActivity(intent);


            /*
             * Pass data using simple intent (Not Bundle) from one activity to another activity
             */
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("MyName", "IMCC");
            startActivity(intent);

            /*
             * Pass data using bundle from one activity to another activity
             */
//            Intent intent = new Intent(this, SecondActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putString("Name", "Kailas Bhakade");
//            intent.putExtras(bundle);
//            startActivity(intent);
        });
    }
}