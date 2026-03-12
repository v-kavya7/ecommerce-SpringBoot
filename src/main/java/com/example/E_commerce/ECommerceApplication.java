package com.example.E_commerce;

import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

//import com.example.E_commerce.entity.User;
import com.example.E_commerce.repository.UserRepository;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args->{
//			userRepository.save(new User("alice","alice@example.com"));
//			userRepository.save(new User("bob","bob@example.com"));
//			userRepository.save(new User("peter","peter@example.com"));
			System.out.println("sample created");
		};
	}

}
