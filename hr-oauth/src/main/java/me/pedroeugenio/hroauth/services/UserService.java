package me.pedroeugenio.hroauth.services;

import me.pedroeugenio.hroauth.entities.User;
import me.pedroeugenio.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            LOGGER.error("email not found: "+email);
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        LOGGER.info("Email found "+email);
        return user;
    }
}
