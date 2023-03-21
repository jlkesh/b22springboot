package dev.jlkeesh;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final Environment env;
    private final MailConfig mailConfig;
    private final JdbcTemplate jdbcTemplate;

    public HomeController(Environment env,
                          MailConfig mailConfig,
                          JdbcTemplate jdbcTemplate) {
        this.env = env;
        this.mailConfig = mailConfig;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        System.out.println("username = " + env.getProperty("xyzuser.name"));
        model.addAttribute("username", env.getProperty("xyzuser.name"));
        System.out.println(mailConfig);
        return "home";
    }
}
