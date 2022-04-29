import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:ffi_log/ffi_log.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
    FFILog.init(needPrintInFlutter: true);
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: TextButton(
            child: const Text('PrintLog'),
            onPressed: () {
              FFILog.debug("MyApp", "log debug");
              FFILog.info("MyApp", "log info");
              FFILog.warn("MyApp", "log warn");
              FFILog.error("MyApp", "log error",
                  stackTrace: StackTrace.current);
            },
          ),
        ),
      ),
    );
  }
}
