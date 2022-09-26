package lk.hotel.spring.controller;

import lk.hotel.spring.dto.CustomerDTO;
import lk.hotel.spring.service.CustomerService;
import lk.hotel.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllCustomers() {
        return "Requested Send";
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customer){
        System.out.println(customer.toString());
//        customerService.saveCustomer(customer);
        return null;
    }

}
