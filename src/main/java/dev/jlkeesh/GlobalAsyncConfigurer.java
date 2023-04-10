/*
package dev.jlkeesh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

@Configuration
@Slf4j
public class GlobalAsyncConfigurer implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            log.error("Async Execution Exception : on method : [{}], with params : [{}] ", method.getName(), params);
            log.error("Actual Exception Is : ", ex);
        };
    }
}*/
