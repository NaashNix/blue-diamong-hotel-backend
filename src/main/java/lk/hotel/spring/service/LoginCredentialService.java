package lk.hotel.spring.service;

import lk.hotel.spring.dto.LoginCredentialsDTO;


public interface LoginCredentialService {

    public LoginCredentialsDTO searchLogins(String username, String password);

    public boolean findIsExists(String username);
}
