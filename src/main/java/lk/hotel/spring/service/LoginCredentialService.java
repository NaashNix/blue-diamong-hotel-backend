package lk.hotel.spring.service;

import lk.hotel.spring.dto.LoginCredentialsDTO;


public interface LoginCredentialService {

    public String checkLogin(String username, String password);

    public boolean findIsExists(String username) throws InterruptedException;
}
