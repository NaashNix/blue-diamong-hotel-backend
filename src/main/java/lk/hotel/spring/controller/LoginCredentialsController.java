package lk.hotel.spring.controller;

import lk.hotel.spring.dto.LoginCredentialsDTO;
import lk.hotel.spring.service.LoginCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
@CrossOrigin
public class LoginCredentialsController {

    @Autowired
    LoginCredentialService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginCredentialsDTO findUser() {
        LoginCredentialsDTO naashnix = service.searchLogins("naashnix", "1234");
        return naashnix;
    }

    @GetMapping(params = {"username"})
    public boolean findIsExists(String username) {
        return service.findIsExists(username);
    }
}
