package com.felipedevos.crud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipedevos.crud.entities.User;
import com.felipedevos.crud.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@fakemail.com", "987654321", "123456");
		User u2 = new User(null, "Alex Green", "alex@fakemail.com", "987654321", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

}