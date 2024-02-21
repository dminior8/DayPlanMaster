package pl.dminior8.DayPlanMaster.model;

import jakarta.persistence.*;
import lombok.*;

//TODO: Stworzyć nowy kontroler ExerciseController łączący
//@Entity(name = "exercises")
@Data
//@DiscriminatorValue("TRAINING")
public class Exercise {
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    private Type exerciseCategory;
    private int setCount;
    private int reps;

    public static enum Type{
        ARMS, CHEST, BACK, LEGS, OTHER;
    }
}

