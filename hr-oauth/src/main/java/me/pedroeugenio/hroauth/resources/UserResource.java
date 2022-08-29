package me.pedroeugenio.hroauth.resources;

import me.pedroeugenio.hroauth.entities.User;
import me.pedroeugenio.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/search")
    private ResponseEntity<User> findByEmail(@RequestParam String email){
        try {
            return ResponseEntity.ok((User) service.loadUserByUsername(email));
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
