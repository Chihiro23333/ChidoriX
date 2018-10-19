package com.bilibili.audiorecordcomponent.audiorecord;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class RecordFileEncoder {

    private static final String TAG = "RecordFileEncoder";

    private File file;
    private AacEncode aacEncode;
    private OutputStream outputStream;

    public RecordFileEncoder(File file) {

        this.file = file;
        aacEncode = new AacEncode();
        aacEncode.prepare();

        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void encodeAndSave(byte[] b) {
        try {
            Log.i(TAG, "encodeAndSave:" + b.length);
            byte[] bytes = aacEncode.offerEncoder(b);
            Log.i(TAG, "encodeAndSaveAfter:" + bytes.length);
            outputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
