LOCAL_PATH := $(call my-dir)
# FFmpeg library
include $(CLEAR_VARS)
LOCAL_MODULE := ffmpeg
LOCAL_SRC_FILES := libffmpeg.so
include $(PREBUILT_SHARED_LIBRARY)
# Program
include $(CLEAR_VARS)
LOCAL_MODULE := ffmpegdemo
LOCAL_SRC_FILES := ffmpegdemo.c
LOCAL_C_INCLUDES += $(LOCAL_PATH)/include
LOCAL_LDLIBS := -llog -lz
LOCAL_SHARED_LIBRARIES := ffmpeg
include $(BUILD_SHARED_LIBRARY)