package lk.hotel.spring.service.impl;

import lk.hotel.spring.dto.LoginCredentialsDTO;
import lk.hotel.spring.entity.LoginCredentials;
import lk.hotel.spring.repo.LoginCredentialsRepo;
import lk.hotel.spring.service.LoginCredentialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class LoginCredentialServiceImpl implements LoginCredentialService {

    @Autowired
    LoginCredentialsRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public LoginCredentialsDTO searchLogins(String username, String password) {

        return mapper.map(repo.findById(username).get(), LoginCredentialsDTO.class);

    }

    @Override
    public boolean findIsExists(String username) {
        LoginCredentials loginCredentials = repo.findById(username).get();
        return loginCredentials != null;
    }


}
