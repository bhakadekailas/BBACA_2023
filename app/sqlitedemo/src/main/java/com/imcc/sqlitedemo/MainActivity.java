package com.imcc.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFirstName, etLastName, etMobile;
    TextView tvResult;
    Button buttonSubmit, buttonCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etMobile = findViewById(R.id.etMobile);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonCheck = findViewById(R.id.buttonCheck);
        tvResult = findViewById(R.id.tvResult);

        buttonSubmit.setOnClickListener(v -> {
            saveUser();
        });

        buttonCheck.setOnClickListener(v -> {
            getUser();
        });
    }

    private void getUser() {
        if (etFirstName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your first name", Toast.LENGTH_SHORT).show();
            etFirstName.requestFocus();
        } else if (etLastName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your last name", Toast.LENGTH_SHORT).show();
            etLastName.requestFocus();
        } else if (etMobile.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your mobile number", Toast.LENGTH_SHORT).show();
            etMobile.requestFocus();
        } else {
            MyDatabaseHelper obj = new MyDatabaseHelper(MainActivity.this);
            UserDataModel userDataModel = obj.getUser(etFirstName.getText().toString(), etLastName.getText().toString());
            Toast.makeText(MainActivity.this, "User Found", Toast.LENGTH_SHORT).show();
            tvResult.setText("First Name = " + userDataModel.firstName + "   " + "Last Name = " + userDataModel.lastName);
        }
    }

    private void saveUser() {
        if (etFirstName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your first name", Toast.LENGTH_SHORT).show();
            etFirstName.requestFocus();
        } else if (etLastName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your last name", Toast.LENGTH_SHORT).show();
            etLastName.requestFocus();
        } else if (etMobile.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your mobile number", Toast.LENGTH_SHORT).show();
            etMobile.requestFocus();
        } else {
            String firstName = etFirstName.getText().toString();
            String lastName = etLastName.getText().toString();
            String mobileNumber = etMobile.getText().toString();

            UserDataModel userDataModel = new UserDataModel();
            userDataModel.setFirstName(firstName);
            userDataModel.setLastName(lastName);
            userDataModel.setMobile(mobileNumber);

            MyDatabaseHelper obj = new MyDatabaseHelper(MainActivity.this);
            obj.saveIntoDatabase(userDataModel);
            Toast.makeText(MainActivity.this, "User save successfully", Toast.LENGTH_SHORT).show();
        }
    }
}