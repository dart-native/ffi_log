# ffi_log

Flutter's sync log component implementation by DartNative.

## Supported Platforms

iOS & Android

## Usage

Dart code :

```dart
// init log
FFILog.init();

// log message
FFILog.debug("MyApp", "log debug");
FFILog.info("MyApp", "log info");
FFILog.warn("MyApp", "log warn");
FFILog.error("MyApp", "log error", stackTrace: StackTrace.current);
```

Objective-C code:

```objectivec
// implementation FFILogDelegate
@interface LogImpl() <FFILogDelegate>
@end

@implementation LogImpl
- (int)getLogLevel {
    return FFILogLevelAll;
}

- (void)printLog:(int)level tag:(NSString *)tag content:(NSString *)content {
    // native logger
    NSLog(@"native log|%zd|%@|%@", level, tag, content);
}
@end

// set implementation
[FFILog sharedInstance].delegate = [[LogImpl alloc] init];
```

Java code:

```java
// set FFILog.ILog implementation
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

        // If dartnative so path is custom, return so path.
        // Otherwise return null.
        @Override
        public String getCustomDartNativePath() {
            return null;
        }
});
```

##License
ffi_log is available under the BSD 3-Clause License. See the LICENSE file for more info.