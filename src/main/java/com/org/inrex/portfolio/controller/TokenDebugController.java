package com.org.inrex.portfolio.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/debug")
public class TokenDebugController {

    @GetMapping("/token")
    public Map<String, Object> debugToken(@AuthenticationPrincipal Jwt jwt) {
        if (jwt == null) {
            return Map.of("error", "No JWT token found");
        }

        return Map.of(
                "claims", jwt.getClaims(),
                "token_details", Map.of(
                        "subject", jwt.getSubject(),
                        "issuer", jwt.getIssuer().toString(),
                        "audience", jwt.getAudience(),
                        "scopes", jwt.getClaimAsStringList("scope"),
                        "realm_access", jwt.getClaim("realm_access"),
                        "resource_access", jwt.getClaim("resource_access")));
    }
}
