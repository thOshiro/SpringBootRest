package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springboot.springController.InvestorController;

@ComponentScan(basePackages = {"service"})
@EntityScan("entity")
@EnableJpaRepositories("repository")
@ComponentScan(basePackageClasses = InvestorController.class)
@SpringBootApplication
public class Welcome {

	public static void main(String[] args) {
		SpringApplication.run(Welcome.class, args);
	}
}
