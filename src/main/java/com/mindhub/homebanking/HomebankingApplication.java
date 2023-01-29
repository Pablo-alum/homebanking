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

	@Bean
	public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, CuentaRepositorio cuentaRepositorio, TransacionRepositorio transacionRepositorio, PrestamoRepositorio prestamoRepositorio, ClientePrestamoRepositorio clientePrestamoRepositorio,TarjetaRepositorio tarjetaRepositorio){
		return args -> {

			Cliente cliente1 = new Cliente("Melba" ,"Morel","melba@mindhub.com",passwordEncoder.encode("melba"));
			Cliente cliente2 = new Cliente("Rodrigo" ,"Seul","melbaADMIN@mindhub1.com",passwordEncoder.encode("perro"));
			Cliente cliente3 = new Cliente("Pablo" ,"Germand","melba@mindhub2.com", passwordEncoder.encode("gato"));


			clienteRepositorio.save(cliente1);
			clienteRepositorio.save(cliente2);
			clienteRepositorio.save(cliente3);

			Cuenta cuenta3 = new Cuenta("vim:003", LocalDateTime.now(),30000,cliente2);
			Cuenta cuenta2 = new Cuenta("vim:002", LocalDateTime.now(),20000,cliente3);
			Cuenta cuenta1 = new Cuenta("vim:001", LocalDateTime.now(),0,cliente1);



			cuentaRepositorio.save(cuenta1);
			cuentaRepositorio.save(cuenta2);
			cuentaRepositorio.save(cuenta3);


			Transacción transacción1 = new Transacción(TipoDeTransacción.CREDITO, 102.0, "Joselito le trafiro a pedrito ",LocalDateTime.now());
			Transacción transacción2 = new Transacción(TipoDeTransacción.DEBITO, -302.0, "Joselito le trafiro a pedrito ",LocalDateTime.now());


			cuenta1.agrergarTransacion(transacción1);
			cuenta1.agrergarTransacion(transacción2);

			transacionRepositorio.save(transacción1);
			transacionRepositorio.save(transacción2);

			Prestamo prestamoHipotecario =new Prestamo("Hipotecario",500000,List.of(12,24,36,48,60));
			Prestamo prestamoPersonal =new Prestamo("Personal",100000,List.of(6,12,24));
			Prestamo prestamoAutomotriz =new Prestamo("Automotriz",300000 ,List.of(6,12,24,36));

			prestamoRepositorio.save(prestamoHipotecario);
			prestamoRepositorio.save(prestamoPersonal);
			prestamoRepositorio.save(prestamoAutomotriz);

			ClientePrestamo Melba1 = new ClientePrestamo(prestamoHipotecario,cliente1, 100000.0,24);
			ClientePrestamo Melba2 = new ClientePrestamo(prestamoPersonal,cliente1, 50000.0 ,12);

			ClientePrestamo Rodrigo1 = new ClientePrestamo(prestamoPersonal,cliente2, 100000.0,24);
			ClientePrestamo Rodrigo2 = new ClientePrestamo(prestamoAutomotriz,cliente2, 20000.0,36);

			clientePrestamoRepositorio.save(Melba1);
			clientePrestamoRepositorio.save(Melba2);
			clientePrestamoRepositorio.save(Rodrigo1);
			clientePrestamoRepositorio.save(Rodrigo2);

			Tarjeta tarjeta1 = new Tarjeta(TipoDeTransacciónTarjetas.DEBITO,"250323132",234,LocalDate.now(),	LocalDate.of(	2027,10,19),"Melba_Morel", TipoDeColor.SILVER,cliente1);
			Tarjeta tarjeta2 = new Tarjeta(TipoDeTransacciónTarjetas.DEBITO,"250323312",264,LocalDate.now(),	LocalDate.of(	2027,10,19),"Melba_Morel", TipoDeColor.TITANIUM,cliente1);
			Tarjeta tarjeta3 = new Tarjeta(TipoDeTransacciónTarjetas.DEBITO,"252323312",206,LocalDate.now(),LocalDate.now(),"Pedriogo", TipoDeColor.TITANIUM,cliente2);
			Tarjeta tarjeta4 = new Tarjeta(TipoDeTransacciónTarjetas.CREDITO,"22222312",204,LocalDate.now(),LocalDate.now(),"Pedrioso", TipoDeColor.SILVER,cliente2);


			tarjetaRepositorio.save(tarjeta1);
			tarjetaRepositorio.save(tarjeta2);
			tarjetaRepositorio.save(tarjeta3);
			tarjetaRepositorio.save(tarjeta4);

		};

	}

}
