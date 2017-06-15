package com.fatec.eduardoruben.hoteldialogs;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Servem extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servem);

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

        final ListView lista = (ListView) findViewById(R.id.listaServem);

        final List<String> list = new ArrayList<>();

        Field[] fields = R.raw.class.getFields();
        for(int i = 0; i < fields.length; i++){
            list.add(fields[i].getName());
        }

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.servem, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        final AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    dlg.setMessage("Do you serve breakfast?");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(0), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Servem.this, resID);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            int resID = getResources().getIdentifier(list.get(8), "raw", getPackageName());
                            mediaPlayer = MediaPlayer.create(Servem.this, resID);
                            mediaPlayer.start();
                        }
                    });
                }
                if (position == 1) {

                    dlg.setMessage("Do you serve lunch?");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(0), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Servem.this, resID);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            int resID = getResources().getIdentifier(list.get(8), "raw", getPackageName());
                            mediaPlayer = MediaPlayer.create(Servem.this, resID);
                            mediaPlayer.start();
                        }
                    });
                }
                if (position == 2) {

                    dlg.setMessage("Do you serve dinner?");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(0), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Servem.this, resID);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            int resID = getResources().getIdentifier(list.get(8), "raw", getPackageName());
                            mediaPlayer = MediaPlayer.create(Servem.this, resID);
                            mediaPlayer.start();
                        }
                    });
                }
                if (position == 3) {

                    dlg.setMessage("Do you serve food in the rooms?");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(0), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Servem.this, resID);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            int resID = getResources().getIdentifier(list.get(8), "raw", getPackageName());
                            mediaPlayer = MediaPlayer.create(Servem.this, resID);
                            mediaPlayer.start();
                        }
                    });
                }/*
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
