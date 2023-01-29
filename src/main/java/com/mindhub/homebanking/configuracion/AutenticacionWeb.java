package com.mindhub.homebanking.configuracion;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import  org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class AutenticacionWeb extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    ClienteRepositorio clienteRepositorio;


    @Bean

    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    public void init(AuthenticationManagerBuilder auth) throws Exception  {


        auth.userDetailsService(inputGmail -> {

             Cliente cliente = clienteRepositorio.findByEmail(inputGmail);

            if (cliente != null) {
                if (cliente.getEmail().contains("ADMIN")) {
                    return new User(cliente.getEmail(),cliente.getContraseña(),
                            AuthorityUtils.createAuthorityList("ADMIN"));
                }

                return new User(cliente.getEmail(), cliente.getContraseña(),  //  contien el sesion id
                        AuthorityUtils.createAuthorityList("CLIENTE"));//autoridad rol

            } else {
                throw new UsernameNotFoundException("Usuario con email no esta registrado: " + inputGmail);
            }

        });

    }

}


