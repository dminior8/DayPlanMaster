package pl.dminior8.DayPlanMaster.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Embeddable
@Data
@Entity(name="subtasks")
@NoArgsConstructor
@AllArgsConstructor
//@DiscriminatorColumn(name = "isExercise", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class Subtasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private boolean isDone;

//    @UniqueElements
//    private Exercises exercise;
    //private boolean isExercise;

//    @ManyToOne
//    @JoinColumn(name = "tasks_id")
//    private Tasks tasks;
}
