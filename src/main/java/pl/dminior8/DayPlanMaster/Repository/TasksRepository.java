package pl.dminior8.DayPlanMaster.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.dminior8.DayPlanMaster.Model.Tasks;

import java.util.Optional;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {
    Optional<Tasks> findTasksByCategory(Tasks.Category category);
}