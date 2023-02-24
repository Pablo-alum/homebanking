package com.mindhub.homebanking.configuracion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.SecurityFilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers( "/web/cuentas.html", "/web/prestamos.html", "/web/tarjetas.html", "/web/transacion.html", "/web/creadorDeTarjetas.html" ).hasAnyAuthority("CLIENTE", "ADMIN")
               .antMatchers("/admin/**", "/h2-console/**", "/rest/**","/cuentas/** ","/tarjetas/**","/transaccions/**","/clientePrestamoes/**", "/profile/**").hasAuthority("ADMIN")
                .antMatchers("web/**","api/clientes/current","api/**").permitAll();


        http.formLogin()
                .usernameParameter("email")
                .passwordParameter("contraseña")
                .loginPage("/api/login");



        http.logout().logoutUrl("/api/logout").deleteCookies("JSESSIONID");
        //Siver para enivar info atrabes de Fomularios
        http.csrf().disable();
        http.headers().frameOptions().disable();


        // si el usuario no está autenticado, simplemente envíe una respuesta de falla de autenticación
        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // si el inicio de sesión es exitoso, simplemente borre las banderas que solicitan autenticación
        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

        // si falla el inicio de sesión, simplemente envíe una respuesta de falla de autenticación
        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // si el cierre de sesión es exitoso, simplemente envíe una respuesta exitosa
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());

        return http.build();
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        }
    }

}