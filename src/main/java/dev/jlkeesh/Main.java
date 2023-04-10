package dev.jlkeesh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class Main {

    /* @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        return javaMailSender;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

   /* @Profile({"test"})
    @Bean
    public TaskExecutor taskExecutorTest() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setKeepAliveSeconds(10);
        taskExecutor.setQueueCapacity(50);
        taskExecutor.setThreadNamePrefix("TEST-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Profile("prod")
    @Bean
    public TaskExecutor taskExecutorProd() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(60);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setQueueCapacity(500);
        taskExecutor.setThreadNamePrefix("PROD-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Profile("dev")
    @Bean
    public TaskExecutor taskExecutorDev() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.setThreadNamePrefix("DEV-");
        taskExecutor.initialize();
        return taskExecutor;
    }*/

}