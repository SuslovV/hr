package ru.suslov.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.suslov.hr.configuration.HrConfiguration;

@SpringBootApplication
@Import(HrConfiguration.class)
public class HrApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }

}
