package pl.dminior8.DayPlanMaster.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tasks")
public class Tasks {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id;
    private String title;
    private String description;
    private String category;
    private Timestamp created_at;
    private Date due_date;
    private Boolean is_complete;
    private String priority;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "task_id")
    private Recurrence recurrence;


    @ElementCollection
    private List<Subtasks> subtasks;

}
