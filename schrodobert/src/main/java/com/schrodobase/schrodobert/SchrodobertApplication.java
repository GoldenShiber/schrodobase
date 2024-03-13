package com.schrodobase.schrodobert;

import com.schrodobase.schrodobert.config.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchrodobertApplication implements CommandLineRunner {

	@Autowired
	private YAMLConfig myConfig;
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SchrodobertApplication.class);
		app.run();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("using environment: " + myConfig.getEnvironment());
		System.out.println("name: " + myConfig.getName());
		System.out.println("enabled:" + myConfig.isEnabled());
		System.out.println("servers: " + myConfig.getServers());
	}
}
