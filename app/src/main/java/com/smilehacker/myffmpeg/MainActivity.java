package com.smilehacker.myffmpeg;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.smilehacker.ffmpeg.FFmpegKit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.format).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FFmpegKit.loadLib(MainActivity.this);
                String fileLogo = Environment.getExternalStorageDirectory() + "/ushow/a-1.mp4";
                String fileLogoChange  = Environment.getExternalStorageDirectory() + "/ushow/1.ts";
                final String cmd1 = String.format("ffmpeg -i %s -vcodec copy -acodec copy -f mpegts %s", fileLogo, fileLogoChange);
                final String cmd0 = String.format("-i %s", fileLogo);
                FFmpegKit.execute((cmd1).split(" "));
                //FFmpegKit.execute(cmd1);
            }
        });
    }
}
