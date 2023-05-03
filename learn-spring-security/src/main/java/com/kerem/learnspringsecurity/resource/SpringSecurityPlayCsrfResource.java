package com.kerem.learnspringsecurity.resource;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityPlayCsrfResource {

    @GetMapping("/csrf-token")
    public CsrfToken csrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
