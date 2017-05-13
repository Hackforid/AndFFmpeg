package com.smilehacker.myffmpeg;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.format).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileLogo = Environment.getExternalStorageDirectory() + "/ushow/logo.mp4";
                String fileLogoChange  = Environment.getExternalStorageDirectory() + "/ushow/1.ts";
                final String cmd1 = String.format("-i %s -vcodec copy -acodec copy -f mpegts %s", fileLogo, fileLogoChange);
                final String cmd0 = String.format("-i %s", fileLogo);
                FFmpegKit.run((cmd1).split(" "));

            }
        });
    }
}
