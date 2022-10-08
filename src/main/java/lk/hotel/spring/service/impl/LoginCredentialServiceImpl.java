package lk.hotel.spring.service.impl;

import lk.hotel.spring.dto.LoginCredentialsDTO;
import lk.hotel.spring.entity.LoginCredentials;
import lk.hotel.spring.repo.LoginCredentialsRepo;
import lk.hotel.spring.service.LoginCredentialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public String checkLogin(String username, String password) {
        if(repo.existsById(username)){
            LoginCredentials cEntity = repo.findById(username).get();
            if(password.equals(cEntity.getPassword())){
                return cEntity.getRole();
            } else {
                throw new RuntimeException("user not found");
            }

        }else {
            throw new RuntimeException("user not found");
        }


    }

    @Override
    public boolean findIsExists(String username) throws InterruptedException {
        return repo.existsById(username);
    }

    @Override
    public boolean saveLogin(String username, String password) {
        if(!repo.existsById(username)){
            LoginCredentials entity = new LoginCredentials(username, password, "user");
            LoginCredentials save = repo.save(entity);
            return true;
        }else {
            return false;
        }

    }


}
