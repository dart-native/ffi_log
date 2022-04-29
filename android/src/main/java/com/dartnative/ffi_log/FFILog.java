package com.dartnative.ffi_log;

import com.dartnative.dart_native.DartNativePlugin;
import com.dartnative.dart_native.InterfaceMessenger;

public class FFILog {
    private static ILog sLog = null;

    public static void setLog(ILog log) {
        sLog = log;
        InterfaceMessenger.getInstance().registerInterface(new FFILogInterface());
        if (sLog != null) {
            String soPath = sLog.getCustomDartNativePath();
            DartNativePlugin.loadSoWithCustomPath(soPath);
        }
    }

    public static ILog getLog() {
        return sLog;
    }

    public interface ILog {
        int OFF = 0;
        int ERROR = 1;
        int WARN = 2;
        int INFO = 3;
        int DEBUG = 4;
        int ALL = 5;

        int getLogLevel();

        void printLog(int level, String tag, String content);

        // If custom so path, need implementation this method.
        default String getCustomDartNativePath() {
            return null;
        }
    }
}