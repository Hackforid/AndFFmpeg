package com.smilehacker.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.hzy.lib7z.Un7Zip;

import java.io.File;

/**
 * Created by kleist on 2017/5/11.
 */

public class FFmpegKit {

    private final static String TAG = "FFmpegKit";
//    static {
//        System.loadLibrary("ffmpeg");
//        System.loadLibrary("ffmpeginvoke");
//    }

    private final static String FFMPEG_ZIP = "libffmpeg.so.7z";
    private final static String FFMPEG_SO = "libffmpeg.so";

    private static boolean mIsLibLoad = false;

    private native static int run(String[] commands);

    public static void loadLib(Context context) {
        if (mIsLibLoad) {
            return;
        }
        Config config = new Config(context);

        File libPath = new File(context.getFilesDir(), "libs");
        File soFile = new File(libPath, FFMPEG_SO);
        if (!soFile.exists() || config.isVersionExpired()) {
            if (libPath.exists()) {
                if (!libPath.isDirectory()) {
                    libPath.delete();
                }
            } else {
                libPath.mkdirs();
            }

            Un7Zip.extract7zFromAssets(context, FFMPEG_ZIP, libPath.getAbsolutePath());
            config.refreshVersion();
        }

        Log.i(TAG, "load ffmpeg:" + soFile.getAbsolutePath());

        System.load(soFile.getAbsolutePath());
        System.loadLibrary("ffmpeginvoke");
        mIsLibLoad = true;
    }

    public static void execute(String[] cmd) {
        if (!mIsLibLoad) {
            throw new IllegalStateException("ffmpeg need load at first");
        }
        run(cmd);
    }

    public static void execute(String cmd) {
        if (!TextUtils.isEmpty(cmd)) {
            execute(cmd.split("\\s+"));
        }
    }
}
