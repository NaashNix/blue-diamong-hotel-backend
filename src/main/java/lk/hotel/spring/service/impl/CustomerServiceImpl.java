package lk.hotel.spring.service.impl;

import lk.hotel.spring.dto.CustomerDTO;
import lk.hotel.spring.entity.Customer;
import lk.hotel.spring.repo.CustomerRepo;
import lk.hotel.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        if (!repo.existsById(customerDTO.getUserID())) {
            Customer save = repo.save(mapper.map(customerDTO, Customer.class));
            return true;
        }else{
            throw new RuntimeException("Car already in the db.");
        }
    }
}
