package com.fatec.eduardoruben.hoteldialogs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.media.MediaPlayer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class Geral extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geral);

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

        final ListView lista = (ListView) findViewById(R.id.listaGeral);

        final List<String> list = new ArrayList<>();

        Field[] fields = R.raw.class.getFields();
        for(int i = 0; i < fields.length; i++){
            list.add(fields[i].getName());
        }

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.geral, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        final AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), TextoVoz.class);
                    myIntent.putExtra("inicio", "Estou no quarto ");
                    myIntent.putExtra("texto", "ESCREVA O NÚMERO DO QUARTO");
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), TextoVoz.class);
                    myIntent.putExtra("inicio", "O número do meu quarto é ");
                    myIntent.putExtra("texto", "ESCREVA O NÚMERO DO QUARTO");
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {

                    dlg.setMessage("I need a taxi");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(2), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Geral.this, resID);
                    mediaPlayer.start();
                }
                if (position == 3) {

                    dlg.setMessage("I would like the contact of some mechanic");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(1), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Geral.this, resID);
                    mediaPlayer.start();
                }
                if (position == 4) {

                    dlg.setMessage("Where is the nearest bank?");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(6), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Geral.this, resID);
                    mediaPlayer.start();
                }
                if (position == 5) {

                    dlg.setMessage("Where is the nearest restaurant?");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(7), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Geral.this, resID);
                    mediaPlayer.start();
                }
                if (position == 6) {

                    dlg.setMessage("Where is the nearest diner?");
                    dlg.show();

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    int resID = getResources().getIdentifier(list.get(5), "raw", getPackageName());
                    mediaPlayer = MediaPlayer.create(Geral.this, resID);
                    mediaPlayer.start();
                }
            }
        });
    }
}
