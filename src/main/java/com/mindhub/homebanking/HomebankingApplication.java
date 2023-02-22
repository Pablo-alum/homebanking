package com.mindhub.homebanking;

import com.mindhub.homebanking.Modelo.*;
import com.mindhub.homebanking.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.mindhub.homebanking.configuracion.AutenticacionWeb;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import  org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class HomebankingApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
}
