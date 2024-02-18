package pl.dminior8.DayPlanMaster.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dminior8.DayPlanMaster.Model.Task;
import pl.dminior8.DayPlanMaster.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {}

