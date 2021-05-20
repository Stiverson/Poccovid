package br.com.itau.Pocovid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class PocovidApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocovidApplication.class, args);
	}

}
