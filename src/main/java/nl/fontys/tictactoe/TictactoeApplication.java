package nl.fontys.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TictactoeApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(TictactoeApplication.class, args);
	}
}
