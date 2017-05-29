package com.fatec.eduardoruben.hoteldialogs;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Mp3Filter implements FilenameFilter {
    public boolean accept(File dir, String name){
        return(name.endsWith(".mp3"));
    }
}

public class Audio extends ListActivity {
    private static final String SD_PATH = new String("/sdcard/");
    private List<String> audios = new ArrayList<String>();
    private MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        updatePlayList();
        
        ImageButton parar = (ImageButton)findViewById(R.id.fltParar);
        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id){
        try{
            mp.reset();
            mp.setDataSource(SD_PATH + audios.get(position));
            mp.prepare();
            mp.start();
        } catch (IOException e){
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }

    private void updatePlayList() {
        File home = new File(SD_PATH);
        if(home.listFiles(new Mp3Filter()).length > 0){
            for(File file : home.listFiles(new Mp3Filter())){
                audios.add(file.getName());
            }

            ArrayAdapter<String> songList = new ArrayAdapter<String>(this, R.layout.activity_audio_item, audios);
            setListAdapter(songList);
        }
    }
}
