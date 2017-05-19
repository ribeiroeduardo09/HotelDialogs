package com.fatec.eduardoruben.hoteldialogs;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Floating button começa aqui!

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.speak);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG);
                //.setAction("Action", null).show();
            }
        });
        fab.setImageDrawable(new TextDrawable(fab.getContext(), "FAB", ColorStateList.valueOf(Color.BLACK), 32.f, TextDrawable.VerticalAlignment.BASELINE));

        //ListView começa aqui!!!

        ListView lista = (ListView) findViewById(R.id.listaPrincipal);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.main, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), Reservar2.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Checkin.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Problemas.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Comida.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Checkout.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Geral.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), Reservar2.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

    }


    //ListView termina aqui!!!
}
