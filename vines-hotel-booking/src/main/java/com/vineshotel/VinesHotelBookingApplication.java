package com.vineshotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vineshotel.entity.User;
import com.vineshotel.repository.UserRepository;

@SpringBootApplication
public class VinesHotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinesHotelBookingApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(UserRepository userRepo, PasswordEncoder encoder) {
		return args -> {
			
			if (userRepo.findByUsername("admin").isEmpty()) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("admin123"));
				admin.setRole("ROLE_ADMIN");
				
				userRepo.save(admin);
				
				System.out.println("Admin user created!");
			}
			
		};
	}

}
