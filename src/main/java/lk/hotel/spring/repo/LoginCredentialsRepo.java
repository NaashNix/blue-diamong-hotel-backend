package lk.hotel.spring.repo;

import lk.hotel.spring.entity.LoginCredentials;
import org.hibernate.persister.entity.Loadable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginCredentialsRepo extends JpaRepository<LoginCredentials, String> {
        LoginCredentials findByUsername(String username);
}
