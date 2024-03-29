package com.kshrd.btb_spring_security_class_demo.securityConfig;

import com.kshrd.btb_spring_security_class_demo.service.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springdoc.core.data.DataRestOperationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class DatabaseConfig {

    private final PasswordConfig passwordConfig;
    private final UserServiceImp userServiceImp;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        // knows from where to load user for matching credentials
                // Use BCryptPasswordEncoder
        authProvider.setUserDetailsService(userServiceImp);
        authProvider.setPasswordEncoder(passwordConfig.passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
             return httpSecurity
            .csrf(csrf->csrf.disable())
            .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(
                    (req) -> req
                            .requestMatchers("/api/v1/users/user").hasRole("USER")
                            .requestMatchers("/api/v1/users/admin").hasRole("ADMIN")
                            .requestMatchers("/api/v1/users/user_admin").hasAnyRole("USER", "ADMIN")
                            .requestMatchers("/api/v1/users/home","/", "/v3/api-docs/**","/swagger-ui/**","/swagger-ui-html").permitAll()
                            .anyRequest()
                            .authenticated()
            )
            .httpBasic(httpBasic->httpBasic.authenticationEntryPoint((request, response, authException) -> {
                response.sendError(HttpStatus.UNAUTHORIZED.value(),HttpStatus.UNAUTHORIZED.getReasonPhrase());
            }))
            .formLogin(Customizer.withDefaults())
            .build();

    }

}
