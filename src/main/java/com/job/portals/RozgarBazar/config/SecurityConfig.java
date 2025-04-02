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
