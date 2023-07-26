package project.adviceweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class AdviceWebApplication implements CommandLineRunner {

	@Value("(${advice-web.message})")
	String message;

	public static void main(String[] args) {
		SpringApplication.run(AdviceWebApplication.class, args);
	}

	@Override
	public void run(String... args){

		System.out.println(message);


	}
}
