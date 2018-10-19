package com.bilibili.audiorecordcomponent.audiorecord;

import android.media.AudioFormat;

public class Config {

    public static int sampleRate = 44100;

    public static int frameSize = sampleRate / 100;

    public static int channel_in = AudioFormat.CHANNEL_IN_MONO;

    public static int channel_out = AudioFormat.CHANNEL_OUT_MONO;

    public static int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
}
