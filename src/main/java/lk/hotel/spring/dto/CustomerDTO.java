package lk.hotel.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CustomerDTO {
    String userID;
    String firstName;
    String secondName;
    String email;
    String nicNumber;
    Date joinedDate;
    String username;
}
