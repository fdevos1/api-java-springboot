package com.felipedevos.crud.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipedevos.crud.entities.Category;
import com.felipedevos.crud.entities.Order;
import com.felipedevos.crud.entities.OrderItem;
import com.felipedevos.crud.entities.Product;
import com.felipedevos.crud.entities.User;
import com.felipedevos.crud.entities.enums.OrderStatus;
import com.felipedevos.crud.repositories.CategoryRepository;
import com.felipedevos.crud.repositories.OrderItemRepository;
import com.felipedevos.crud.repositories.OrderRepository;
import com.felipedevos.crud.repositories.ProductRepository;
import com.felipedevos.crud.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;


	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@fakemail.com", "987654321", "123456");
		User u2 = new User(null, "Alex Green", "alex@fakemail.com", "987654321", "123456");
		
		Order o1 = new Order(null, Instant.parse("2023-09-05T21:00:00Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2023-09-05T21:30:00Z"), OrderStatus.WAITING_PAYMENT, u2);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum", 90.5, "");
		Product p2 = new Product(null, "Macbook", "Lorem ipsum", 1250.0, "");
		
		OrderItem oi1 = new OrderItem(o1,p1,2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p2,1 , p2.getPrice());
		OrderItem oi3 = new OrderItem(o2,p2,1 , p2.getPrice());

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1,p2));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(p1,p2));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}

}