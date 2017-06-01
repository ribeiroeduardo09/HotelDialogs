package com.fatec.eduardoruben.hoteldialogs;

import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TextoVoz extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private FloatingActionButton ouvirTexto;
    private EditText textoParaFalar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_voz);

        tts = new TextToSpeech(this, this);

        textoParaFalar = (EditText) findViewById(R.id.edtText);
        ouvirTexto = (FloatingActionButton) findViewById(R.id.fltPlay);

        ouvirTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                falarAgora();
            }
        });
    }

    Locale locale = new Locale("PT", "BR");

    @Override
    public void onInit(int texto){
        if(texto == TextToSpeech.SUCCESS){
            int idioma = tts.setLanguage(locale); // AQUI ALTERA O IDIOMA
            if(idioma == TextToSpeech.LANG_MISSING_DATA || idioma == TextToSpeech.LANG_NOT_SUPPORTED){
                ouvirTexto.setEnabled(true);
                falarAgora();
            }
            else{

            }
        }
        else{

        }
    }
    private void falarAgora(){
        String texto = textoParaFalar.getText().toString();
        tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null);
    }
}
