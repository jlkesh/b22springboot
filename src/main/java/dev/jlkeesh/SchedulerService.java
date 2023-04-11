package dev.jlkeesh;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@ConditionalOnProperty(name = "scheduler.enable",
        matchIfMissing = true,
        havingValue = "0"
)
@Slf4j
public class SchedulerService {

    /*private final EntityManager entityManager;*/
    private final ObjectMapper objectMapper;

    public SchedulerService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.SECONDS)
    public void sendNotification() throws InterruptedException, IOException {
        for (int i = 0; i < 10; i++) {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/"+new Random().nextInt(1,100));
            Map<String, Object> mapList = objectMapper.readValue(url, new TypeReference<>() {
            });
            log.info("Notification (Fixed Delay) : " + mapList);
        }
    }

    // @Scheduled(fixedRate = 2, timeUnit = TimeUnit.SECONDS)
    public void sendNotification2() throws InterruptedException {
        log.info("Notification (Fixed Rate) : " + new Date());
        TimeUnit.MILLISECONDS.sleep(4000);
    }

    // @Scheduled(initialDelay = 3, fixedRate = 2, timeUnit = TimeUnit.SECONDS)
    public void sendNotification3() throws InterruptedException {
        log.info("Notification (Fixed Rate + Initial Delay) : " + new Date());
        /*TimeUnit.MILLISECONDS.sleep(4000);*/
    }

    // @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void sendNotification4() throws InterruptedException {
        log.info("Pull Blocked users...................");
        log.info("Check Blocked Till Expired Or Not...................");
        log.info("Delete From Block List...................");
        log.info("set zero to login try count field...................");
    }

    @Scheduled(cron = "10-40/5 50-55/1 * * * *")
    public void sendNotification5() throws InterruptedException {
        log.info("Pull Blocked users...................");
    }

    @Async
    @Scheduled(cron = "59 17 16 L-5 * ?")
    public void sendNotification6() throws InterruptedException {
        log.info("Pull Blocked users...................");
    }

    @Scheduled(cron = "@hourly")
    public void sendNotification7() throws InterruptedException {
        log.info("Daily Pull Blocked users...................");
    }



}
