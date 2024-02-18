package pl.dminior8.DayPlanMaster.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.dminior8.DayPlanMaster.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {}