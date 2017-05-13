#include <stdio.h>
#include "com_smilehacker_myffmpeg_FFmpegKit.h"
#include "ffmpeg.h"
#include <string.h>
#include <android/log.h>

#define  LOG_TAG    "FFmpegInvoke"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

/*
 * Class:     com_smilehacker_myffpeg_FFmpegKit_
 * Method:    run
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_smilehacker_myffmpeg_FFmpegKit_run(JNIEnv *env,
        jclass obj, jobjectArray commands) {
    int argc = (*env)->GetArrayLength(env, commands);
    char *argv[argc];

    LOGI("Kit argc %d\n", argc);

    int i;
    for (i = 0; i < argc; i++) {
        jstring js = (jstring) (*env)->GetObjectArrayElement(env, commands, i);
        argv[i] = (char*) (*env)->GetStringUTFChars(env, js, 0);

        LOGI("Kit argv %s\n", argv[i]);
    }
    return run(argc, argv);
}