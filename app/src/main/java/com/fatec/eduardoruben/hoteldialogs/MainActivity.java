package com.fatec.eduardoruben.hoteldialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView começa aqui!!!

        ListView lista = (ListView) findViewById(R.id.listaPrincipal);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.equipes, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

    }


    //ListView termina aqui!!!
}
