package team.symmetry.ResumeBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScans({@ComponentScan("com"), @ComponentScan("team")})
@SpringBootApplication
public class ResumeBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeBackApplication.class, args);
	}

}
