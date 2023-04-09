package dev.jlkeesh;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/properties")
@EnableConfigurationProperties(StudentConfigurationProperties.class)
public class Main {

    @Value("${properties.example:'Default Value'}")
    private String example1;

/*    @Value("${properties.languages:sad}")
    private List<String> list;*/

    @Value("#{${properties.map}}")
    private Map<String, String> map;

    private final StudentConfigurationProperties studentConfigurationProperties;

    public Main(@Lazy StudentConfigurationProperties studentConfigurationProperties) {
        this.studentConfigurationProperties = studentConfigurationProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/prop-default")
    public String example1() {
        return example1;
    }

    @GetMapping("/prop-list")
    public List<String> example2() {
        return studentConfigurationProperties.getLanguages();
    }

    @GetMapping("/prop-map")
    public Map<String, String> example3() {
        return map;
    }

    @GetMapping("/prop-object")
    public Student example4() {
        return studentConfigurationProperties.getStudent();
    }

    @GetMapping("/prop-objects")
    public List<Student> example5() {
        return studentConfigurationProperties.getStudents();
    }


}