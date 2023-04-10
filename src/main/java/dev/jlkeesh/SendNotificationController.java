package dev.jlkeesh;

import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public String sendActivationLink(
            @RequestParam String username,
            @RequestParam String email){

        notificationSenderService.sendActivationLink(username, email);

        return "Notification successfully sent to " + username + " !!!";
    }
    @PostMapping("/report")
    public String sendActivationLink(){

        notificationSenderService.sendWeeklyReport(null,"email");

        return "Notification successfully sent to " + null + " !!!";
    }

}
