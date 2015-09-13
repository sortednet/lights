package net.sorted.lights.repository;


import net.sorted.lights.domain.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long>  {
}
