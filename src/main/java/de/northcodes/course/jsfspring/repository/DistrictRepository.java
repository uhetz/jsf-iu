package de.northcodes.course.jsfspring.repository;

import de.northcodes.course.jsfspring.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    List<District> findAll();
}