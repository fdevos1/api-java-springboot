package com.felipedevos.crud.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipedevos.crud.entities.Order;
import com.felipedevos.crud.entities.User;
import com.felipedevos.crud.entities.enums.OrderStatus;
import com.felipedevos.crud.repositories.OrderRepository;
import com.felipedevos.crud.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@fakemail.com", "987654321", "123456");
		User u2 = new User(null, "Alex Green", "alex@fakemail.com", "987654321", "123456");
		Order o1 = new Order(null, Instant.parse("2023-09-05T21:00:00Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2023-09-05T21:30:00Z"), OrderStatus.WAITING_PAYMENT, u2);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2));
	}

}