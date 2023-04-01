package com.nd705.suppointspb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SuppointspbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SuppointspbApplication.class, args);

		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
		System.out.println(encoder.encode("pass"));
	}

}
