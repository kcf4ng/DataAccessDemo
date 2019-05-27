package com.example.dataaccessdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener btnShared_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity( new Intent(MainActivity.this, ActShared.class));
        }
    };

    private View.OnClickListener btnFile_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity( new Intent(MainActivity.this, ActFile.class));
        }
    };

    private View.OnClickListener btnList_click =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity( new Intent(MainActivity.this, ActSqlite.class));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
    }

    private void InitialComponent() {
        btnShared = findViewById(R.id.btn1);
        btnShared.setOnClickListener(btnShared_click);
        btnFile = findViewById(R.id.btn2);
        btnFile.setOnClickListener(btnFile_click);
        btnList =findViewById(R.id.btn3);
        btnList.setOnClickListener(btnList_click);
        lblTitle=findViewById(R.id.lblTitle);
    }
    TextView lblTitle;
    Button btnShared;   //shared preference
    Button btnFile;  //file I/O
    Button btnList;  //SQLite
}
