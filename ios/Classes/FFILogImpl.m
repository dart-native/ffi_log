//
//  FFILogImpl.m
//  Pods
//
//  Created by hui on 2022/4/29.
//

#import "FFILogImpl.h"
#if __has_include(<dart_native/DNInterfaceRegistry.h>)
#import <dart_native/DNInterfaceRegistry.h>
#else
@import dart_native;
#endif

@implementation FFILog

+ (instancetype)sharedInstance
{
    static FFILog* _imp;
    static dispatch_once_t _token;
    dispatch_once(&_token, ^{
        _imp = [FFILog new];
    });
    return _imp;
}

@end

@implementation FFILogInterface

InterfaceEntry(FFILog)

InterfaceMethod(printLog, printLog:(int)logLevel tag:(NSString *)tag content:(NSString *)log) {
    if ([FFILog sharedInstance].delegate) {
        [[FFILog sharedInstance].delegate printLog:logLevel tag:tag content:log];
    }
    return nil;
}

InterfaceMethod(getLogLevel, getLogLevel){
    if ([FFILog sharedInstance].delegate) {
        return @([[FFILog sharedInstance].delegate getLogLevel]);
    }
    return @(FFILogLevelInfo);
}

@end
