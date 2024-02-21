package pl.dminior8.DayPlanMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dminior8.DayPlanMaster.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {}

