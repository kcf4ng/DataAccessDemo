package com.example.dataaccessdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActShared extends AppCompatActivity {

    private View.OnClickListener btnSet_click= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            SharedPreferences table = getSharedPreferences("T1",0);
            SharedPreferences.Editor row = table.edit();
            row.putString("KK",txtSet.getText().toString()).commit();
            Toast.makeText(ActShared.this, "Data saved", Toast.LENGTH_SHORT).show();

        }
    };
    private View.OnClickListener btnGet_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences table = getSharedPreferences("T1",0);
            String data = table.getString("KK","No Data");
            lblGet.setText(data);
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.command);
        InitialComponent();

    }

    private void InitialComponent() {
        btnSet= findViewById(R.id.btnSet);
        btnSet.setOnClickListener(btnSet_click);
        btnGet= findViewById(R.id.btnGet);
        btnGet.setOnClickListener(btnGet_click);
        txtSet=findViewById(R.id.txtSet);
        lblGet=findViewById(R.id.lblGet);
    }

    Button btnSet, btnGet;
    EditText txtSet;
    TextView lblGet;
}
