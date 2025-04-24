package com.job.portals.RozgarBazar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = {
//		"com.job.portals.RozgarBazar.model",
//		"com.job.portals.RozgarBazar.entity"
//}
//)
//@EnableJpaRepositories(basePackages = "com.job.portals.RozgarBazar.repository")
public class RozgarBazarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RozgarBazarApplication.class, args);
	}

}
