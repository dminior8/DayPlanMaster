package pl.dminior8.DayPlanMaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Embeddable
@Table(name = "recurrence")
@NoArgsConstructor
@AllArgsConstructor
public class Recurrence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int task_id;
    private String frequency;
    private int task_interval; //jak dużo na raz
    private String days;

    public static enum Frequency{
        DAILY, WEAKLY, MONTHLY
    }
}


