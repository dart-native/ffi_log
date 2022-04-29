package com.dartnative.ffi_log;

import com.dartnative.dart_native.DartNativeInterface;
import com.dartnative.dart_native.annotation.InterfaceEntry;
import com.dartnative.dart_native.annotation.InterfaceMethod;

@InterfaceEntry(name = "FFILog")
public class FFILogInterface extends DartNativeInterface {
    @InterfaceMethod(name = "printLog")
    public void printLog(int logLevel, String tag, String log) {
        switch (logLevel) {
            case FFILog.ILog.ERROR:
                if (FFILog.getLog() != null) {
                    FFILog.getLog().e(tag, log);
                } else {
                    android.util.Log.e(tag, log);
                }
                break;
            case FFILog.ILog.WARN:
                if (FFILog.getLog() != null) {
                    FFILog.getLog().w(tag, log);
                } else {
                    android.util.Log.w(tag, log);
                }
                break;
            case FFILog.ILog.INFO:
                if (FFILog.getLog() != null) {
                    FFILog.getLog().i(tag, log);
                } else {
                    android.util.Log.i(tag, log);
                }
                break;
            case FFILog.ILog.DEBUG:
                if (FFILog.getLog() != null) {
                    FFILog.getLog().d(tag, log);
                } else {
                    android.util.Log.d(tag, log);
                }
                break;
            default:
                break;
        }
    }

    @InterfaceMethod(name = "getLogLevel")
    public int getLogLevel() {
        if (FFILog.getLog() != null) {
            return FFILog.getLog().getLogLevel();
        } else {
            return FFILog.ILog.INFO;
        }
    }
}