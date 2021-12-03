package com.example.tugaskalkulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    Button btnHitung;
    RadioButton rbTambah, rbKurang, rbKali, rbBagi;
    RadioGroup radioGroup;
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    DecimalFormat df = new DecimalFormat("###0.00");
    ArrayList<Hasil> hasilArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNum1 = findViewById(R.id.edt_num1);
        edtNum2 = findViewById(R.id.edt_num2);
        btnHitung = findViewById(R.id.btn_hitung);
        rbTambah = findViewById(R.id.rb_tambah);
        rbBagi = findViewById(R.id.rb_bagi);
        rbKali = findViewById(R.id.rb_kali);
        rbKurang = findViewById(R.id.rb_kurang);
        radioGroup = findViewById(R.id.radioGroup);
        recyclerView = findViewById(R.id.rv_listhasil);

        databaseHelper = new DatabaseHelper(this);
        radioGroup.check(rbTambah.getId()); // Potential error
        hasilArrayList = new ArrayList<>();

        Cursor cur = databaseHelper.read();
//       Assign data to arraylist
        while (cur.moveToNext()){
            hasilArrayList.add(
                    new Hasil(cur.getString(0), cur.getString(1), cur.getString(2),cur.getString(3)));
        }

        recyclerView.setAdapter(new AdapterCalculation(hasilArrayList,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(edtNum1.getText().toString());
                double num2 = Double.parseDouble(edtNum2.getText().toString());
                double hasil;
                String operands= "+";
                if (rbTambah.isChecked()){
                    hasil = num1+num2;
                    operands = "+";
                    databaseHelper.add(num1, num2, hasil, operands);
                } else if (rbBagi.isChecked()){
                    hasil = (num1/num2);    //  change to Double type
                    operands = "/";
                    databaseHelper.add(num1, num2, hasil, operands);
                } else if (rbKali.isChecked()){
                    hasil = (num1*num2);
                    operands = "*";
                    databaseHelper.add(num1, num2, hasil, operands);
                } else if (rbKurang.isChecked()){
                    hasil = (num1-num2);
                    operands = "-";
                    databaseHelper.add(num1, num2, hasil, operands);
                }
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });


    }
}