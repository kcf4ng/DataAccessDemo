package com.example.dataaccessdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class ActFile extends AppCompatActivity {

    private View.OnClickListener btnSet_click= new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            try {

                OutputStream streamOut = openFileOutput("Myfile.txt", 0);
                streamOut.write(txtSet.getText().toString().getBytes("utf-8"));
                streamOut.close();
                Toast.makeText(ActFile.this, "Data saved", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };


    private View.OnClickListener btnGet_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                InputStream streamIn = openFileInput("Myfile.txt");
                byte[] bytes = new byte[100];
                int count = streamIn.read(bytes);
                String content = new String (bytes,0,count,"utf-8" );
                lblGet.setText(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
