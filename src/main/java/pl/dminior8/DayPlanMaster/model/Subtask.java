package pl.dminior8.DayPlanMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Embeddable
@Data
@Entity(name="subtasks")
@NoArgsConstructor
@AllArgsConstructor
//@DiscriminatorColumn(name = "isExercise", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class Subtask {

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
