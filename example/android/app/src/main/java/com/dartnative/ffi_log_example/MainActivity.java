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
            public void d(String tag, String log) {
                Log.d(tag, log);

            }

            @Override
            public void i(String tag, String log) {
                Log.i(tag, log);

            }

            @Override
            public void w(String tag, String log) {
                Log.w(tag, log);

            }

            @Override
            public void e(String tag, String log) {
                Log.e(tag, log);

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
