package com.fatec.eduardoruben.hoteldialogs;

import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

import static com.fatec.eduardoruben.hoteldialogs.R.string.textoFala;

public class TextoVoz extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private FloatingActionButton ouvirTexto;
    private EditText textoParaFalar;
    private EditText texto1;
    private EditText texto2;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_voz);

        tts = new TextToSpeech(this, this);

        textoParaFalar = (EditText) findViewById(R.id.edtText);
        ouvirTexto = (FloatingActionButton) findViewById(R.id.fltPlay);
        texto1 = (EditText) findViewById(R.id.texto1);
        texto2 = (EditText) findViewById(R.id.texto2);
        txtView = (TextView) findViewById(R.id.txtView);

        Bundle bundle = getIntent().getExtras();

        if(bundle.containsKey("inicio"))
        {
            String valor1 = bundle.getString("inicio");
            texto1.setText(valor1);
        }
        if(bundle.containsKey("fim"))
        {
            String valor2 = bundle.getString("fim");
            texto2.setText(valor2);
        }
        if(bundle.containsKey("texto"))
        {
            String valor3 = bundle.getString("texto");
            txtView.setText(valor3);
        }

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
        String texto3 = texto1.getText().toString();
        String texto4 = texto2.getText().toString();
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage(texto3 + texto + texto4);
        dlg.show();
        tts.speak(texto3 + texto + texto4, TextToSpeech.QUEUE_FLUSH, null);
    }
}
