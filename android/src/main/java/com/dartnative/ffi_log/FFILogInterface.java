package com.dartnative.ffi_log;

import com.dartnative.dart_native.DartNativeInterface;
import com.dartnative.dart_native.annotation.InterfaceEntry;
import com.dartnative.dart_native.annotation.InterfaceMethod;

@InterfaceEntry(name = "FFILog")
public class FFILogInterface extends DartNativeInterface {
    @InterfaceMethod(name = "printLog")
    public void printLog(int logLevel, String tag, String log) {
        if (FFILog.getLog() != null) {
            FFILog.getLog().printLog(logLevel, tag, log);
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