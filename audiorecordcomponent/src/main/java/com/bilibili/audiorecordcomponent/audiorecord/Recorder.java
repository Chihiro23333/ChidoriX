package com.bilibili.audiorecordcomponent.audiorecord;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

public class Recorder {

    private static final String TAG = "Recorder";

    private byte[] mRecordBuffer;

    private AudioRecord audioRecord;
    private AtomicBoolean recording;
    private RecordFileEncoder recordFileEncoder;

    public Recorder(RecordFileEncoder recordFileEncoder) {
        this.recordFileEncoder = recordFileEncoder;
        recording = new AtomicBoolean(false);
        mRecordBuffer = new byte[Config.frameSize * 2];
    }

    private void doCapture() {
        audioRecord.startRecording();
        while (recording.get()) {
            int length = audioRecord.read(mRecordBuffer, 0, mRecordBuffer.length);
            Log.i(TAG, mRecordBuffer.length + "");
            recordFileEncoder.encodeAndSave(mRecordBuffer);
        }
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                recording.set(true);
                doCapture();
            }
        }).start();
    }

    public void stop() {
        audioRecord.stop();
        recording.set(false);
    }

    public void prepare() {
        int minBufferSize = AudioRecord.getMinBufferSize(
                Config.sampleRate,
                Config.channel_in,
                Config.audioFormat);

        int bufferSize = Config.frameSize * 10;
        if (bufferSize < minBufferSize) {
            bufferSize = ((minBufferSize / Config.frameSize) + 1) * Config.frameSize * 2;
        }
        audioRecord = new AudioRecord(
                MediaRecorder.AudioSource.MIC,       // source
                Config.sampleRate,                   // sample rate, hz
                Config.channel_in,                      // channels
                Config.audioFormat,                  // audio format
                bufferSize);
    }
}
