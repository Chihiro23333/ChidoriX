package com.bilibili.audiorecordcomponent.audiorecord;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class RecordFileEncoder {

    private static final String TAG = "RecordFileEncoder";

    private AacEncode aacEncode;
    private OutputStream outputStream;

    public RecordFileEncoder(File file) {

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

    public void save(byte[] b) {
        try {
            outputStream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void encodeToAAC(File in, File out) {
        try {
            InputStream inputStream = new FileInputStream(in);
            OutputStream outputStream = new FileOutputStream(out);
            int len;
            byte[] b = new byte[2048];
            while ((len = inputStream.read(b)) != -1) {
                byte[] encodByte = aacEncode.offerEncoder(b);
                outputStream.write(encodByte);
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
