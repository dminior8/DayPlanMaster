package pl.dminior8.DayPlanMaster.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.dminior8.DayPlanMaster.model.Task;

import java.util.Optional;

public interface TasksRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findTasksByCategory(Task.Category category);
    Optional<Task> findTaskById(int id);
}