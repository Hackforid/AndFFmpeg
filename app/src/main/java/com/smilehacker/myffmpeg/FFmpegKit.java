package com.smilehacker.myffmpeg;

/**
 * Created by kleist on 2017/5/11.
 */

public class FFmpegKit {
    static {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpeginvoke");
    }

    public native static int run(String[] commands);
}
