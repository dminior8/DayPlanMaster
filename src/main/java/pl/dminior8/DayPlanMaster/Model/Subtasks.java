package pl.dminior8.DayPlanMaster.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Embeddable
@Data
@Entity(name="subtasks")
@NoArgsConstructor
@AllArgsConstructor
public class Subtasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
