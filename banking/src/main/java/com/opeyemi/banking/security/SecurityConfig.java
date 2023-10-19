// package com.opeyemi.banking.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//         httpSecurity.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();

//         return httpSecurity.build();
//     }

//     @Bean
//     public UserDetailsService users(){
//         UserDetails admin = User.builder().username("admin").password("admin").roles("ADMIN").build();
//         return new InMemoryUserDetailsManager(admin);
//     }

// }
