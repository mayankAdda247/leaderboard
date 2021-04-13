package com.mayank.userapi;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mayank.userapi.entity.User;
import com.mayank.userapi.repository.UserRepository;

@SpringBootApplication
public class UserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner init(UserRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						User u = new User();
						u.setFirstName("user " + i);
						u.setLastName("user "+i);
						u.setEmail("user" + i + "@email.com");
						
						return u;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
 }	*/
}
