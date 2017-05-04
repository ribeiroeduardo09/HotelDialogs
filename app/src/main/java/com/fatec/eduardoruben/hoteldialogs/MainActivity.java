package com.fatec.eduardoruben.hoteldialogs;

import android.os.Bundle;
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

        //ListView começa aqui!!!

        ListView lista = (ListView) findViewById(R.id.listaPrincipal);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.main, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    //ListView termina aqui!!!
}
