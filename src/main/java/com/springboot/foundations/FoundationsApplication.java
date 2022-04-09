package com.springboot.foundations;

import component.ComponentDependency;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoundationsApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;

	public FoundationsApplication(ComponentDependency cd){
		this.componentDependency = cd;
	}

	public static void main(String[] args) {
		SpringApplication.run(FoundationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saluda();
	}
}
