package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.Payment;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderItemRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig<categoryRepository> implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Alexa Blue", "alexa@gmail.com", "9999999999", "123456");
		userRepository.saveAll(Arrays.asList(u2,u3));
		
		
		Order o1=new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u2);
		Order o2=new Order(null, Instant.parse("2020-06-20T19:53:07Z"),OrderStatus.DELIVERED, u3);
		orderRepository.saveAll(Arrays.asList(o1,o2));
		
		Category c1=new Category(null,"computers");
		Category c2=new Category(null,"cosmetics");
		categoryRepository.saveAll(Arrays.asList(c1,c2));
		
		Product p1=new Product(null,"iPhone", "apple product", 22.0, "example.com");
		productRepository.saveAll(Arrays.asList(p1));
		
		p1.getCategories().add(c2);
		p1.getCategories().add(c1);
		productRepository.saveAll(Arrays.asList(p1));
		
	
		
		OrderItem oi1=new OrderItem(o1, p1, 3, p1.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1));
		
		Payment pay1=new Payment(null, Instant.parse("2019-06-20T21:53:07Z"),o1);
		
		o1.setPayment(pay1);
		orderRepository.save(o1);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
