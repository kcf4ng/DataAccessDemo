package com.example.dataaccessdemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ActSqlite extends AppCompatActivity {

    private View.OnClickListener btnNew_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ContentValues data = new ContentValues();
            data.put("fId", txtId.getText().toString());
            data.put("fName",txtName.getText().toString());
            data.put("fPhone",txtPhone.getText().toString());
            data.put("fEmail",txtEmail.getText().toString());
            data.put("fAddress",txtAddress.getText().toString());


            CDBManager db = new CDBManager(ActSqlite.this);

            db.insert("tCustomer",data);
            Toast.makeText(ActSqlite.this,"新增資料成功",Toast.LENGTH_SHORT).show();

        }
    };
    private View.OnClickListener btnDelete_click= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ActSqlite.this,"刪除資料成功",Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener btnUpdate_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener btnBrowse_click= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           Cursor table = (new CDBManager(ActSqlite.this)).getBySql("SELECT * FROM tCustomer");

           if (table.getCount()<= 0 ) {
               return;
           }

            table.moveToFirst();
            ArrayList<String > list = new ArrayList<>();

           for(int i = 0 ; i < table.getCount() ; i++){

               list.add(table.getString(2)+"\r\n"+table.getString(3)+"/"+table.getString(4));
               table.moveToNext();
            }
           String[] customers = list.toArray(new String[list.size()]);

            AlertDialog.Builder builder = new AlertDialog.Builder(ActSqlite.this);
            builder.setItems(customers,null ).setTitle("客戶資料一覽").create().show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sqlite);
        InitialComponent();

    }

    private void InitialComponent() {

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone= findViewById(R.id.txtPhone);
        txtAddress= findViewById(R.id.txtAddress);
        btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(btnNew_click);
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(btnDelete_click);
        btnBrowse = findViewById(R.id.btnBrowse);
        btnBrowse.setOnClickListener(btnBrowse_click);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(btnUpdate_click);
        txtId= findViewById(R.id.txtId);

    }

    Button btnDelete,btnNew, btnUpdate, btnBrowse;
    EditText txtId, txtName, txtPhone, txtEmail, txtAddress;

}
