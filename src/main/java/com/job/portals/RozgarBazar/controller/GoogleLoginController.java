
 package com.job.portals.RozgarBazar.controller;

 import org.springframework.http.ResponseEntity;
 import org.springframework.security.core.Authentication;
 import org.springframework.security.core.annotation.AuthenticationPrincipal;
 import org.springframework.security.core.context.SecurityContextHolder;
 import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
 import org.springframework.security.oauth2.core.oidc.user.OidcUser;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 @RestController
 @RequestMapping("api/")
 public class GoogleLoginController {
     @GetMapping("/google")
     public ResponseEntity<String> googleLogin(){
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         if (authentication instanceof OAuth2AuthenticationToken oauth &&
                 oauth.getPrincipal() instanceof OidcUser oidcUser) {
             System.out.println(oidcUser.getEmail());
         } else {
             System.out.println("Not an OIDC user");
         }

         return ResponseEntity.ok("Hello");
     }

     @GetMapping("/user-info")
     public String getUserInfo(@AuthenticationPrincipal OidcUser principal) {
         return "User email: " + principal.getEmail();
     }
 }
//package com.job.portals.RozgarBazar.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/")
//public class GoogleLoginController {
//    @GetMapping("/google")
//    public ResponseEntity<String> googleLogin(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication instanceof OAuth2AuthenticationToken oauth &&
//                oauth.getPrincipal() instanceof OidcUser oidcUser) {
//            System.out.println(oidcUser.getEmail());
//        } else {
//            System.out.println("Not an OIDC user");
//        }
//
//        return ResponseEntity.ok("Hello");
//    }
//
//    @GetMapping("/user-info")
//    public String getUserInfo(@AuthenticationPrincipal OidcUser principal) {
//        return "User email: " + principal.getEmail();
//    }
//
