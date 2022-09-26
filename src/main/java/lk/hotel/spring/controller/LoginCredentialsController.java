package lk.hotel.spring.controller;

import lk.hotel.spring.dto.LoginCredentialsDTO;
import lk.hotel.spring.service.LoginCredentialService;
import lk.hotel.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/login")
@CrossOrigin
public class LoginCredentialsController {

    @Autowired
    LoginCredentialService service;


    @GetMapping(params = {"username","password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil checkLogin(@RequestParam String username, @RequestParam String password) {
        return new ResponseUtil(200,"server_connected",service.checkLogin(username,password));
    }

    @GetMapping(params = {"username"})
    public boolean findIsExists(String username) throws InterruptedException {
        return service.findIsExists(username);
    }
}
