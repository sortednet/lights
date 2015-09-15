package net.sorted.lights.repository;


import net.sorted.lights.domain.Light;
import net.sorted.lights.domain.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface LightRepository extends CrudRepository<Light, Long>  {
}
