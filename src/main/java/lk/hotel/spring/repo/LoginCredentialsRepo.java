package lk.hotel.spring.repo;

import lk.hotel.spring.entity.LoginCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginCredentialsRepo extends JpaRepository<LoginCredentials, String> {
        LoginCredentials findByUsername(String username);
}
