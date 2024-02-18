package pl.dminior8.DayPlanMaster.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Data
@Entity(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private String title;
    private String description;
    private String category;
    private Timestamp created_at;
    private Date due_date;
    private int is_complete;
    private String priority;

//    @OneToOne
//    private Recurrence recurrence;
//
//    @ElementCollection
//    private List<Subtask> subtasks;

}
