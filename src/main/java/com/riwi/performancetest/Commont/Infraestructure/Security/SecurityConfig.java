package com.riwi.performancetest.Commont.Infraestructure.Security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {


    //class authentication configuration
    // puedes configurar cómo se autenticará a los usuarios
    //Puedes configurar el AuthenticationManager con los detalles de cómo se deben validar las credenciales de los usuarios.

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/api/proyect/save").hasRole("ADMIN")
                                .requestMatchers(
                                        "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                                .anyRequest().permitAll()
                );

//        http.addFilterBefore(validationFilter, UsernamePasswordAuthenticationFilter.class);
//        http.addFilterBefore(new AutenticationFilterWithUserPass(authenticationManager()),UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}