import 'package:dart_native/dart_native.dart';
import 'package:stack_trace/stack_trace.dart';

/// FFILog levels, default is [LogLevel.info].
///
/// [off] No logging.
/// [error] Only error message.
/// [warn] Potentially harmful situations of interest to end users or system managers that indicate potential problems.
/// [info] Informational messages that might make sense to end users and system administrators,
///        and highlight the progress of the application.
/// [debug] Relatively detailed tracing used by application developers.
/// [all] All messages.
enum LogLevel { off, error, warn, info, debug, all }

class FFILog {
  static final Interface _logInterface = Interface("FFILog");

  static LogLevel _logLevel = LogLevel.info;
  static bool _needPrintInFlutter = true;

  static void init({bool needPrintInFlutter = true}) {
    _needPrintInFlutter = needPrintInFlutter;
    _logLevel = LogLevel.values[_getLogLevel()];
  }

  static error(String tag, String log,
      {StackTrace? stackTrace, Object? error}) {
    _logWithLevel(
        LogLevel.error, tag, _formatLog(log, stackTrace, error: error));
  }

  static warn(String tag, String log, [StackTrace? stackTrace]) {
    _logWithLevel(LogLevel.warn, tag, _formatLog(log, stackTrace));
  }

  static info(String tag, String log, [StackTrace? stackTrace]) {
    _logWithLevel(LogLevel.info, tag, _formatLog(log, stackTrace));
  }

  static debug(String tag, String log, [StackTrace? stackTrace]) {
    _logWithLevel(LogLevel.debug, tag, _formatLog(log, stackTrace));
  }

  static _logWithLevel(LogLevel level, String tag, String message) {
    if (_needPrintInFlutter) {
      print("$tag : $message");
    }

    if (level.index >= _logLevel.index) {
      return;
    }

    _logInterface
        .invokeMethodSync('printLog', args: [level.index, tag, message]);
  }

  static int _getLogLevel() {
    return _logInterface.invokeMethodSync('getLogLevel');
  }

  static String _formatLog(String log, StackTrace? stackTrace,
      {Object? error}) {
    if (error != null) {
      log += '$log: error=${error.toString()}';
    }

    if (stackTrace != null) {
      var trace = Trace.format(stackTrace, terse: true);
      log += ', stackTrace=\n$trace';
    }

    return log;
  }
}
