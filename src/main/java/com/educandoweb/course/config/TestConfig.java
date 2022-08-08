package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Alexa Blue", "alexa@gmail.com", "9999999999", "123456");
		userRepository.saveAll(Arrays.asList(u2,u3));
		
		
		Order o1=new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u2);
		Order o2=new Order(null, Instant.parse("2020-06-20T19:53:07Z"), u3);
		orderRepository.saveAll(Arrays.asList(o1,o2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
