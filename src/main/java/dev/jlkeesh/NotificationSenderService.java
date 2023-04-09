package dev.jlkeesh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class NotificationSenderService {
    /*ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());*/

    @Async("your")
    public void send(String username) {
        /*Runnable runnable = () -> {*/
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception ignored) {
            }
            log.info("Notification successfully sent to {} !!!", username);
        /*};*/
        /*new Thread(runnable).start();*/
        /*executorService.submit(runnable);*/
        /*CompletableFuture.runAsync(runnable);*/
    }
}
