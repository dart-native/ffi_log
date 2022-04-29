package com.dartnative.ffi_log_example;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.dartnative.ffi_log.FFILog;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends FlutterActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FFILog.setLog(new FFILog.ILog() {
            @Override
            public void printLog(int level, String tag, String content) {
                switch (level) {
                    case FFILog.ILog.ERROR:
                        Log.e(tag, content);
                        break;
                    case FFILog.ILog.WARN:
                        Log.w(tag, content);
                        break;
                    case FFILog.ILog.INFO:
                        Log.i(tag, content);
                        break;
                    case FFILog.ILog.DEBUG:
                        Log.d(tag, content);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public int getLogLevel() {
                return FFILog.ILog.ALL;
            }

            @Override
            public String getCustomDartNativePath() {
                return null;
            }
        });
    }
}
