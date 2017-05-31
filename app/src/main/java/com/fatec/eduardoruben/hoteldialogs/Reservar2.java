package com.fatec.eduardoruben.hoteldialogs;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reservar2 extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar2);

        //Floating button começa aqui!

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.speak);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //ListView começa aqui!!!

        final ListView lista = (ListView) findViewById(R.id.listaReservar);

        final List<String> list = new ArrayList<>();

        Field[] fields = R.raw.class.getFields();
        for(int i = 0; i < fields.length; i++){
            list.add(fields[i].getName());
        }

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.reservar, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), Reservar2.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {
                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(4), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Reservar2.this, resID);
                    mediaPlayer.start();
                }/*
                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Reservar2.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Reservar2.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Reservar2.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Reservar2.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), Reservar2.class);
                    startActivityForResult(myIntent, 0);
                }*/
            }
        });
    }
}
