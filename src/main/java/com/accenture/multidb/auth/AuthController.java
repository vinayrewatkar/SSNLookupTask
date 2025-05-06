package com.accenture.multidb.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private UserRepository users;
    @Autowired private PasswordEncoder encoder;

    @PostMapping("/signup")
    public String signup(@RequestBody User u) {
        u.setPassword(encoder.encode(u.getPassword()));
        u.setRole("ROLE_USER");
        users.save(u);
        return "Signed up";
    }

    @PostMapping("/login")
    public String login(@RequestBody User u) {
        User found = users.findByUsername(u.getUsername());
        if (found != null && encoder.matches(u.getPassword(), found.getPassword())) {
            return "Logged in";
        }
        return "Invalid credentials";
    }
}
