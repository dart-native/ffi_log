//
//  FFILogImpl.h
//  Pods
//
//  Created by hui on 2022/4/29.
//
#import <Foundation/Foundation.h>

typedef NS_ENUM(NSInteger, FFILogLevel) {
    FFILogLevelOff = 0,
    FFILogLevelError,
    FFILogLevelWarn,
    FFILogLevelInfo,
    FFILogLevelDebug,
    FFILogLevelAll,
};

@protocol FFILogDelegate <NSObject>

- (void)printLog:(int)level tag:(NSString *)tag content:(NSString *)content;

- (int)getLogLevel;

@end


@interface FFILog : NSObject

@property (nonatomic, strong) id<FFILogDelegate> delegate;

+ (instancetype)sharedInstance;

@end

@interface FFILogInterface : NSObject

@end;
