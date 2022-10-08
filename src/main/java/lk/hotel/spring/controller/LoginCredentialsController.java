package lk.hotel.spring.controller;

import lk.hotel.spring.dto.LoginCredentialsDTO;
import lk.hotel.spring.service.CustomerService;
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

    @Autowired
    CustomerService customerService;

    @GetMapping(params = {"username","password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil checkLogin(@RequestParam String username, @RequestParam String password) {
        try{
            if(service.checkLogin(username,password).equals("user")){
                return new ResponseUtil(202,"USER_FOUND",customerService.getCustomerById(username));
            }else{
                throw new RuntimeException("user_not_found");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseUtil(601,"USER_NOT_FOUND",null);
        }

    }

    @GetMapping(params = {"username"})
    public boolean findIsExists(String username) throws InterruptedException {
        return service.findIsExists(username);
    }
}
