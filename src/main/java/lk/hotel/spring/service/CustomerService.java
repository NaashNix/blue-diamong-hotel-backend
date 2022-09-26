package lk.hotel.spring.service;

import lk.hotel.spring.dto.CustomerDTO;

public interface CustomerService {
    boolean saveCustomer(CustomerDTO customerDTO);
}
