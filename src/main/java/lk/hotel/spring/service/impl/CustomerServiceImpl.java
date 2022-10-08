package lk.hotel.spring.service.impl;

import lk.hotel.spring.dto.CustomerDTO;
import lk.hotel.spring.entity.Customer;
import lk.hotel.spring.repo.CustomerRepo;
import lk.hotel.spring.service.CustomerService;
import lk.hotel.spring.service.LoginCredentialService;
import lk.hotel.spring.util.CredentialsSender;
import lk.hotel.spring.util.GenerateUsername;
import lk.hotel.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CredentialsSender sender;

    @Autowired
    GenerateUsername generator;

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    LoginCredentialService loginCredentialService;

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {

        String username = generator.generateNewUsername();
        customerDTO.setUserID(username);

        String password = generator.generatePassword();
        System.out.println("Password : "+password);

            if (loginCredentialService.saveLogin(customerDTO.getUsername(), password)) {
                if (!repo.existsById(customerDTO.getUserID())) {

                    Customer save = repo.save(mapper.map(customerDTO, Customer.class));
                    sender.SendCredentials(customerDTO.getUsername(), password, customerDTO.getEmail(), customerDTO.getFirstName());
                    return true;

                } else {
                    throw new RuntimeException(username + "- already exist in the DB.");
                }
            } else {
                throw new RuntimeException(username + " - user already in the database.login.");
            }


    }

    @Override
    public CustomerDTO getCustomerById(String username) {
        if(repo.existsByUsername(username)){
            System.out.println("USername  : "+username);
            return mapper.map(repo.findByUsername(username),CustomerDTO.class);
        }else {
            throw new RuntimeException("user not exists.");
        }
    }
}
