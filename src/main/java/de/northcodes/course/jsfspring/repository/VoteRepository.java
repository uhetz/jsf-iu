package de.northcodes.course.jsfspring.repository;

import de.northcodes.course.jsfspring.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByName(String name);

}