package dev.jlkeesh;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class NotificationSenderService {
    /*ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());*/

    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    public NotificationSenderService(JavaMailSender javaMailSender,
                                     Configuration configuration) {
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }

    @Async
    public void sendActivationLink(String username, String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setFrom("john.lgd65@gmail.com");
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, email);
            mimeMessage.setSubject("Spring Boot Mailing Example");
            String content = """
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>Activation Page</title>
                    </head>
                    <body>
                    <div style="background: aqua;">
                        <h1>Hello %s</h1>
                        <h2>In Order To Activate Your Account Click</h2>
                        <a href="https://online.pdp.uz?token=%s" target="_blank">activate</a>
                    </div>
                    </body>
                    </html>""".formatted(username, UUID.randomUUID());
            mimeMessage.setContent(content, "text/html");
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendWeeklyReport(String username, String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("john.lgd65@gmail.com");
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("Spring Boot Mailing Example");
            FileSystemResource picture = new FileSystemResource("/home/jlkesh/IdeaProjects/pdp/bootcamp/22/spring/springboot/springboot/src/main/resources/activation.ftlh");
            FileSystemResource pic = new FileSystemResource("/home/jlkesh/Desktop/books/3.jpg");
            mimeMessageHelper.addAttachment("nature.html", picture);
            Template template = configuration.getTemplate("activation.ftlh");
            /*StringWriter stringWriter = new StringWriter();
            template.process(Map.of("username", "Elshodbek"), stringWriter);*/
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, Map.of("username", "Elshodbek"));
            mimeMessageHelper.setText(text, true);
            mimeMessageHelper.addInline("image_id", pic);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async
    public void send(String username) {




        /*Runnable runnable = () -> {*/
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception ignored) {
        }
        log.info("Notification successfully sent to {} !!!", username);
        /*throw new RuntimeException("Exception For Fun");*/
        /*};*/
        /*new Thread(runnable).start();*/
        /*executorService.submit(runnable);*/
        /*CompletableFuture.runAsync(runnable);*/
    }

    public String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (Exception e) {
            e.printStackTrace();
            return "hello";
        }
    }
}
