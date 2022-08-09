package com.example.camp;

import com.example.camp.model.Activity;
import com.example.camp.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
public class CampFizzyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampFizzyApplication.class, args);
	}

	@Component
	public class StartUpRunner implements CommandLineRunner {

		@Autowired
		private ActivityRepository activityRepository;
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Running");
			activityRepository.saveAll(Arrays.asList(
					Activity.builder().name("Archery").difficulty(3).build(),
					Activity.builder().name("Hatchet Throwing").difficulty(5).build(),
					Activity.builder().name("Firestarting").difficulty(2).build()
			));
			System.out.println(activityRepository.count());
		}
	}
}
