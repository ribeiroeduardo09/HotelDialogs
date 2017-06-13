package com.fatec.eduardoruben.hoteldialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View.OnClickListener;

import java.util.Calendar;

public class DatePick extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton ok;
    EditText t1;
    EditText t2;
    String num;


    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;

    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_pick);
        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        t1 = (EditText) findViewById(R.id.editText3);
        t2 = (EditText) findViewById(R.id.editText4);
        ok = (FloatingActionButton) findViewById(R.id.fltActBtn);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);
                num = "1";
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);
                num = "2";
            }
        });
        ok.setOnClickListener(this);
    }

    private void colocar_data() {
        t1.setText((mDayIni + 1) + "/" + mMonthIni + "/" + mYearIni+" ");
    }
    private void colocar_data2() {
        t2.setText("a " + (mDayIni + 1) + "/" + mMonthIni + "/" + mYearIni);
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    if(num == "1")
                    {
                        colocar_data();
                    }
                    if(num == "2")
                    {
                        colocar_data2();
                    }
                }
            };

    public void onClick(View v) {
        Intent myIntent = new Intent(this, TextoVoz.class);
        myIntent.putExtra("inicio", "Eu gostaria de fazer uma reserva. Dia ");
        myIntent.putExtra("meio", t1.getText().toString() + t2.getText().toString());
        myIntent.putExtra("texto", "DATA DA RESERVA");
        startActivity(myIntent);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);
        }
        return null;
    }
}