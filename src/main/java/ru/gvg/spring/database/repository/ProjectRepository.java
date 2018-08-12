package ru.gvg.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gvg.spring.database.entity.Project;

/**
 * @author Denis Volnenko
 */

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, String> {
}
