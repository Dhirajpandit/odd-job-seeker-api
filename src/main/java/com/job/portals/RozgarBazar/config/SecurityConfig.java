
// package com.job.portals.RozgarBazar.config;

// import com.job.portals.RozgarBazar.service.CustomOAuth2UserService;
// import lombok.AllArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// @AllArgsConstructor
// @Slf4j
// public class SecurityConfig {


//     private final CustomOAuth2UserService customOAuth2UserService;
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf(Customizer.withDefaults());
//         log.info("::::::Security Filter Chain :::::");
//         http.authorizeHttpRequests(auth->auth.requestMatchers("/", "/login/**", "/oauth2/**")
//                 .permitAll()
//                 .anyRequest()
//                 .authenticated()
//         ).oauth2Login(oAuth->oAuth.userInfoEndpoint(userInfo->userInfo.oidcUserService(customOAuth2UserService)));
//                 /*.sessionManagement(session -> session
//                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS) */// Disable caching

//         return http.build();
//     }

//    /* @Bean
//     public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
//         return new CustomOAuth2UserService();
//     }*/
// }

//package com.job.portals.RozgarBazar.config;
//
//import com.job.portals.RozgarBazar.service.CustomOAuth2UserService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//@Slf4j
//public class SecurityConfig {
//
//
//    private final CustomOAuth2UserService customOAuth2UserService;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(Customizer.withDefaults());
//        log.info("::::::Security Filter Chain :::::");
//        http.authorizeHttpRequests(auth->auth.requestMatchers("/", "/login/**", "/oauth2/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//        ).oauth2Login(oAuth->oAuth.userInfoEndpoint(userInfo->userInfo.oidcUserService(customOAuth2UserService)));
//                /*.sessionManagement(session -> session
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) */// Disable caching
//
//        return http.build();
//    }
//
//   /* @Bean
//    public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
//        return new CustomOAuth2UserService();
//    }*/
//}

package com.job.portals.RozgarBazar.config;

import com.job.portals.RozgarBazar.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info(":::::: Initializing Security Filter Chain :::::");

        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for REST APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/**",
                                "/api/otp/**",
                                "/api/auth/**",
                                "/api/notifications/**",
                                "/api/jobs/public/**",
                                "/oauth2/**",        // Google OAuth2 redirect
                                "/login/**",

                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"// Any login-related pages
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.disable()) // Disable default login form
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo ->
                                userInfo.oidcUserService(customOAuth2UserService) // Google login
                        )
                );

        return http.build();
    }
}














//
//package com.job.portals.RozgarBazar.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                    .requestMatchers("/api/**","/api/otp/**","/api/auth/**",
//                            "/api/notifications/**",
//                            "/api/jobs/public/**"
//                    ).permitAll()  // Allow OTP APIs
//                    .anyRequest().authenticated()
//                )
//                .formLogin(AbstractHttpConfigurer::disable); // Disable default login page
//
//        return http.build();
//    }
//}
//



// this is use for otp login/logout  we will use this code when login was start



//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/login", "/logout-success").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login") // Optional, if custom login page
//                        .defaultSuccessUrl("/home", true)
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/logout-success")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                        .permitAll()
//                );
//
//        return http.build();
//    }
//}
//

