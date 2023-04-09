package dev.jlkeesh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class SendNotificationController {

    private final NotificationSenderService notificationSenderService;

    public SendNotificationController(NotificationSenderService notificationSenderService) {
        this.notificationSenderService = notificationSenderService;
    }

    @GetMapping
    public String sendNotification(@RequestParam String username) {

        notificationSenderService.send(username);

        return "Notification successfully sent to " + username + " !!!";
    }

}
