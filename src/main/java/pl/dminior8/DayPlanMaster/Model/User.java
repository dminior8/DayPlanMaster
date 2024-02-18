package pl.dminior8.DayPlanMaster.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User implements Serializable {
    @Id
    private int id;

    @NotBlank(message="Należy podać nazwę użytkownika")
    private String username;

//    @NotBlank(message="Należy podać imię")
//    private String name;
//
//    @NotBlank(message="Należy podać nazwisko")
//    private String surname;

    @Email(message="Niepoprawna wartość maila")
    private String email;

    @NotBlank(message="Niepoprawne hasło")
    private String password;

//    @NotBlank(message="Podanie miejscowości jest obowiązkowe.")
//    private String city;
    private Timestamp created_at;

}
