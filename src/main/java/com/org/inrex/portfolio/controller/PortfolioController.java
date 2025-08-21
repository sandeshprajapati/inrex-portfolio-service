package com.org.inrex.portfolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class PortfolioController {

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/data")
    public String getPortfolio() {
        return "Portfolio data";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/something")
    public ResponseEntity<?> adminEndpoint() {
        // Only accessible by users with ADMIN role
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
