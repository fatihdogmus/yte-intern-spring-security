package yte.intern.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @GetMapping("/user")
    public String user() {
        return "You are a peasant user!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "You are glorious admin!";
    }
}
