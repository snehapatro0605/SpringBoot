package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaExampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user = new User();
		user.setName("Durgesh");
		user.setCity("Lucknow");
		user.setStatus("programmer");
		
		User user1 = new User();
		user1.setName("Uttam");
		user1.setCity("Delhi");
		user1.setStatus("Python");
		
		User user2 = new User();
		user2.setName("Ankit");
		user2.setCity("Chennai");
		user2.setStatus("Java");
		
		//Save single user
		User userE = userRepository.save(user);
		System.out.println(userE);
		
		//Save multiple user
		List<User> userList = List.of(user1,user2);
		userRepository.saveAll(userList);
		System.out.println(userList);
		
		//update by id
		Optional<User> optional = userRepository.findById(3);
		User userGet = optional.get();
		userGet.setName("Ankit Tiwari");
		userRepository.save(userGet);

		//Retrieve		
		Iterable<User> itr = userRepository.findAll();
		itr.forEach(userItr->System.out.println("List of users: "+userItr));
		
		//Delete 
		userRepository.deleteById(3);
	}
}
