package lk.hotel.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer{
    @Id
    String userID;
    String firstName;
    String secondName;
    String email;
    String nicNumber;
    Date joinedDate;
    String username;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    LoginCredentials loginCredentials;

}

