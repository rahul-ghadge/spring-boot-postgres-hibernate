package com.arya.postgres.hibernate.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.CollectionUtils;

import com.arya.postgres.hibernate.demo.entity.UserEntity;
import com.arya.postgres.hibernate.demo.repository.UserRepository;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan					//("com.arya.postgres.hibernate.demo.entity")
@EnableJpaRepositories		//("com.arya.postgres.hibernate.demo")
public class SpringBootPostgresHibernateApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresHibernateApplication.class, args);
	}

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		List<UserEntity> list = userRepository.findAll();
		
		if(CollectionUtils.isEmpty(list)) {
			
			for (int i = 1; i <= 5; i++) {
				
				UserEntity user = new UserEntity();
				user.setEmail("demo-user" + i + "@mail.com");
				user.setFirstName("demo-" + i);
				user.setLastName("user-" + i);

				userRepository.save(user);
			}
			
		}
		
		System.out.println(userRepository.findById(1).get());
		System.out.println("---------------------------------------------");
		System.out.println(userRepository.findById(1).get());
		System.out.println();
		
	}
	
	
	
	
	
	
}
