package com.codewithabe.AAiT;

import com.codewithabe.AAiT.models.EventCatagory;
import com.codewithabe.AAiT.repository.EventCatagoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AAiTInfoApplication {

	public static void main(String[] args) {SpringApplication.run(AAiTInfoApplication.class, args);}

	@Bean
	public CommandLineRunner dataLoader(EventCatagoryRepository repo) {
		return args -> {

			repo.save(new EventCatagory(1, "recent"));
			repo.save(new EventCatagory(2, "notice"));

		};
	}
}
