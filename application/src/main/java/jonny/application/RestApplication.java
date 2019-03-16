package jonny.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "jonny")
public class RestApplication{
    public static void main(String[] args) { SpringApplication.run(RestApplication.class, args); }
}