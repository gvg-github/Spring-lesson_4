package ru.gvg.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gvg.spring.database.entity.Task;

/**
 * @author Denis Volnenko
 */

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, String> {


}
