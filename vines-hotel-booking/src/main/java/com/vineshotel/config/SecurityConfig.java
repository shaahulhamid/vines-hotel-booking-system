package com.vineshotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth

                // ✅ Public Pages
                .requestMatchers(
                    "/",
                    "/rooms",
                    "/book",
                    "/login",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                // ✅ Admin Login Page Public
                .requestMatchers("/admin/login").permitAll()

                // ✅ Admin Protected URLs
                .requestMatchers("/admin/**").hasRole("ADMIN")

                // ✅ Others require login
                .anyRequest().authenticated()
            )

            // ✅ Login Handling
            .formLogin(form -> form
                .loginPage("/login")

                // Redirect after login
                .successHandler((request, response, authentication) -> {

                    boolean isAdmin = authentication.getAuthorities()
                            .stream()
                            .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

                    if (isAdmin) {
                        response.sendRedirect("/admin/dashboard");
                    } else {
                        response.sendRedirect("/");
                    }
                })

                .permitAll()
            )

            // ✅ Redirect Admin URLs to Admin Login
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((request, response, exception) -> {

                    String uri = request.getRequestURI();

                    if (uri.startsWith("/admin")) {
                        response.sendRedirect("/admin/login");
                    } else {
                        response.sendRedirect("/login");
                    }
                })
            )

            // ✅ Logout
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }
}
