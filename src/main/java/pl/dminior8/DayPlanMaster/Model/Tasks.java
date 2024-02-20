package pl.dminior8.DayPlanMaster.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dminior8.DayPlanMaster.Service.Converters.CategoryConverter;
import pl.dminior8.DayPlanMaster.Service.Converters.PriorityConverter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tasks")
//@DiscriminatorColumn(name = "category", discriminatorType = DiscriminatorType.STRING)
public class Tasks {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String title;
    private String taskDescription;
    private Category category;
    private Timestamp createdAt;
    private Date dueDate;
    private boolean isComplete;
    private Priority priority;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "task_id")
    private Recurrence recurrence;


    @ElementCollection
    //@OneToMany(mappedBy = "tasks", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "task_id")
    private List<Subtasks> subtasks;

    @Convert(converter = CategoryConverter.class)
    public static enum Category{
        WORK, EDUCATION, TRAINING, HOBBY, OTHER
    }

    @Convert(converter = PriorityConverter.class)
    public static enum Priority{
        HIGH, MEDIUM, LOW
    }

}
