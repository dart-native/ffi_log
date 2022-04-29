#import "AppDelegate.h"
#import "GeneratedPluginRegistrant.h"
#import <ffi_log/FFILogImpl.h>

@interface AppDelegate() <FFILogDelegate>

@end

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application
    didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
  [GeneratedPluginRegistrant registerWithRegistry:self];
  [FFILog sharedInstance].delegate = self;
  // Override point for customization after application launch.
  return [super application:application didFinishLaunchingWithOptions:launchOptions];
}

- (int)getLogLevel {
    return FFILogLevelAll;
}

- (void)printLog:(int)level tag:(NSString *)tag content:(NSString *)content {
    NSLog(@"native log|%zd|%@|%@", level, tag, content);
}

@end
