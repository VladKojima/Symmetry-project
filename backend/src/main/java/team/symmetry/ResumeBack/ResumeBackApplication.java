package team.symmetry.ResumeBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Scope;

import com.jwt.service.dto.authorization.Roles;

import team.symmetry.ResumeBack.dto.UserDto;
import team.symmetry.ResumeBack.services.UserService;

@ComponentScans({@ComponentScan("com"), @ComponentScan("team")})
@SpringBootApplication
public class ResumeBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeBackApplication.class, args);
	}

	@Bean
	@Scope("singleton")
	public int initAdmin(UserService userService){
		try{
			userService.createUser(UserDto.builder()
		.login("admin")
		.password("admin")
		.role(Roles.ADMIN.toString())
		.build()
		);
		}
		catch(Exception e){

		}
		
		return 0;
	}
}
