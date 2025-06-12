//
//// package com.job.portals.RozgarBazar.service;
//
//// import com.job.portals.RozgarBazar.entity.User;
//// import com.job.portals.RozgarBazar.enums.OnboardingStatus;
//// import com.job.portals.RozgarBazar.repository.UserRepository;
//// import jakarta.annotation.PostConstruct;
//// import lombok.AllArgsConstructor;
//// import lombok.extern.slf4j.Slf4j;
//// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
//// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//// import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//// import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//// import org.springframework.stereotype.Service;
//
//// @Service
//// @AllArgsConstructor
//// @Slf4j
//// public class CustomOAuth2UserService extends OidcUserService {
//
////      private final UserRepository userRepository;
//
////     @Override
////     public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
////         log.info(":::::::: Started Load User Method ::::::");
////         OidcUser oidcUser = super.loadUser(userRequest);
////         String email = oidcUser.getAttribute("email");
////         log.info(":::::: Fetching User Email from Token ::::" + email);
////         if(email!=null && (!userRepository.existsByEmail(email))){
////             User user = new User();
////             user.setEmail(email);
////             user.setOnboardingStatus(OnboardingStatus.GOOGLE_AUTHENTICATED);
////             userRepository.save(user);
////         }
////         return oidcUser;
////     }
//
////     @PostConstruct
////     public void init() {
////         log.info("CustomOAuth2UserService bean initialized");
////     }
//// }
//
////package com.job.portals.RozgarBazar.service;
////
////import com.job.portals.RozgarBazar.entity.User;
////import com.job.portals.RozgarBazar.enums.OnboardingStatus;
////import com.job.portals.RozgarBazar.repository.UserRepository;
////import jakarta.annotation.PostConstruct;
////import lombok.AllArgsConstructor;
////import lombok.extern.slf4j.Slf4j;
////import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
////import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
////import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
////import org.springframework.security.oauth2.core.oidc.user.OidcUser;
////import org.springframework.stereotype.Service;
////
////@Service
////@AllArgsConstructor
////@Slf4j
////public class CustomOAuth2UserService extends OidcUserService {
////
////     private final UserRepository userRepository;
////
////    @Override
////    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
////        log.info(":::::::: Started Load User Method ::::::");
////        OidcUser oidcUser = super.loadUser(userRequest);
////        String email = oidcUser.getAttribute("email");
////        log.info(":::::: Fetching User Email from Token ::::" + email);
////        if(email!=null && (!userRepository.existsByEmail(email))){
////            User user = new User();
////            user.setEmail(email);
////            user.setOnboardingStatus(OnboardingStatus.GOOGLE_AUTHENTICATED);
////            userRepository.save(user);
////        }
////        return oidcUser;
////    }
////
////    @PostConstruct
////    public void init() {
////        log.info("CustomOAuth2UserService bean initialized");
////    }
////}
//
//package com.job.portals.RozgarBazar.service;
//
//import com.job.portals.RozgarBazar.entity.User;
//import com.job.portals.RozgarBazar.enums.OnboardingStatus;
//import com.job.portals.RozgarBazar.repository.UserRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//@Slf4j
//public class CustomOAuth2UserService extends OidcUserService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
//        log.info(":::::: Starting loadUser() in CustomOAuth2UserService ::::::");
//        OidcUser oidcUser = super.loadUser(userRequest);
//
//        String email = oidcUser.getAttribute("email");
//        log.info(":::::: Fetched email from token: {} ::::::", email);
//
//        if (email != null && !userRepository.existsByEmail(email)) {
//            User user = new User();
//            user.setEmail(email);
//            user.setOnboardingStatus(OnboardingStatus.GOOGLE_AUTHENTICATED);
//            userRepository.save(user);
//            log.info(":::::: New user saved with Google-authenticated status ::::::");
//        }
//
//        return oidcUser;
//    }
//
//    @PostConstruct
//    public void init() {
//        log.info(":::::: CustomOAuth2UserService bean initialized ::::::");
//    }
//}
