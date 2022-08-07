package yte.intern.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String user() {
        return "Ben user sayfasıyım";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Ben admin sayfasıyım";
    }
}
