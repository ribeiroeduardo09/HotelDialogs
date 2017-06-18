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

public class Problemas extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problemas);

        //Floating button começa aqui!

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.speak);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //ListView começa aqui!!!

        final ListView lista = (ListView) findViewById(R.id.listaProblemas);

        final List<String> list = new ArrayList<>();

        Field[] fields = R.raw.class.getFields();
        for(int i = 0; i < fields.length; i++){
            list.add(fields[i].getName());
        }

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.problemas, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        final AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    dlg.setMessage("Frase em inglês");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(4), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Problemas.this, resID);
                    mediaPlayer.start();
                }
                if (position == 1) {

                    dlg.setMessage("Frase em inglês");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(4), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Problemas.this, resID);
                    mediaPlayer.start();
                }
                if (position == 2) {

                    dlg.setMessage("Frase em inglês");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(4), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Problemas.this, resID);
                    mediaPlayer.start();
                }
                if (position == 3) {

                    dlg.setMessage("Frase em inglês");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(4), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Problemas.this, resID);
                    mediaPlayer.start();
                }
                if (position == 4) {

                    dlg.setMessage("Frase em inglês");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(4), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Problemas.this, resID);
                    mediaPlayer.start();
                }
                if (position == 5) {

                    dlg.setMessage("Frase em inglês");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(4), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Problemas.this, resID);
                    mediaPlayer.start();
                }
                if (position == 6) {

                    dlg.setMessage("Frase em inglês");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(4), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Problemas.this, resID);
                    mediaPlayer.start();
                }
            }
        });
    }
}
