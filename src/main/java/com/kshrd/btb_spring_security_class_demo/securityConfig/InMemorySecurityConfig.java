//package com.kshrd.btb_spring_security_class_demo.securityConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class InMemorySecurityConfig {
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails user1 = User.withUsername("user")
//                .password(passwordEncoder().encode("12345"))
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User.withUsername("admin")
//                .password(passwordEncoder().encode("9876"))
//                .roles("ADMIN")
//                .build();
//
//        System.out.printf("User1 " + user1.getPassword());
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//             return httpSecurity
//            .csrf(csrf->csrf.disable())
//            .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .authorizeHttpRequests(
//                    (req) -> req
//                            .requestMatchers("/api/v1/users/user").hasRole("USER")
//                            .requestMatchers("/api/v1/users/admin").hasRole("ADMIN")
//                            .requestMatchers("/api/v1/users/user_admin").hasAnyRole("USER", "ADMIN")
//                            .requestMatchers("/api/v1/users/home","/", "/v3/api-docs/**","/swagger-ui/**","/swagger-ui-html").permitAll()
//                            .anyRequest()
//                            .authenticated()
//            )
//            .httpBasic(httpBasic->httpBasic.authenticationEntryPoint((request, response, authException) -> {
//                response.sendError(HttpStatus.UNAUTHORIZED.value(),HttpStatus.UNAUTHORIZED.getReasonPhrase());
//            }))
//            .formLogin(Customizer.withDefaults())
//            .build();
//
//    }
//
//
//
//
//
//
//
//
//}
//
//
