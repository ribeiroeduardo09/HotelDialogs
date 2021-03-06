package com.fatec.eduardoruben.hoteldialogs;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity { //implements View.OnClickListener {
    /*private Boolean isFabOpen = false;
    private FloatingActionButton speak,toEng,toPort;
    private Animation fab_open,fab_close,rotate_backward,rotate_forward;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*------------------Listview------------------*//
        ListView lista = (ListView) findViewById(R.id.listaPrincipal);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.main, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        final AlertDialog.Builder dlg = new AlertDialog.Builder(this);

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
                    Intent myIntent = new Intent(view.getContext(), TextoVoz.class);
                    myIntent.putExtra("texto", "ESCREVA A FRASE PERSONALIZADA");
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        //*------------------Floating Action Button------------------*//
        /**speak = (FloatingActionButton) findViewById(R.id.speak);
        toEng = (FloatingActionButton) findViewById(R.id.toEng);
        toPort = (FloatingActionButton) findViewById(R.id.toPort);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
        speak.setOnClickListener(this);
        toEng.setOnClickListener(this);
        //toEng.setImageDrawable(new TextDrawable(toEng.getContext(), "PT", ColorStateList.valueOf(Color.WHITE), 45.f, TextDrawable.VerticalAlignment.BASELINE));
        toPort.setOnClickListener(this);
        //toPort.setImageDrawable(new TextDrawable(toPort.getContext(), "EN", ColorStateList.valueOf(Color.WHITE), 45.f, TextDrawable.VerticalAlignment.BASELINE));


        toEng.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, VoiceRecog.class));
            }
        });
        toPort.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, VoiceRecog.class));
            }
        });**/
    }

    /**@Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.speak:
                animateFAB();
                break;
            case R.id.toEng:
                Log.d("Raj", "toEng");
                break;
            case R.id.toPort:
                Log.d("Raj", "toPort");
                break;
        }
    }

    public void animateFAB() {

        if(isFabOpen) {
            speak.startAnimation(rotate_backward);
            toEng.startAnimation(fab_close);
            toPort.startAnimation(fab_close);
            isFabOpen = false;
            Log.d("Raj", "close");
        } else {
            speak.startAnimation(rotate_forward);
            toEng.startAnimation(fab_open);
            toPort.startAnimation(fab_open);
            isFabOpen = true;
            Log.d("Raj", "open");
        }
    }
    **/
}
