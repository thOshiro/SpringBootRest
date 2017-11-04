package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"service"})
@ComponentScan(basePackages = {"repository"})
@SpringBootApplication
public class Welcome {

	public static void main(String[] args) {
		SpringApplication.run(Welcome.class, args);
	}
}
