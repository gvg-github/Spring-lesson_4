package ru.gvg.spring.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gvg.spring.database.entity.Project;
import ru.gvg.spring.database.repository.ProjectRepository;

/**
 * @author Denis Volnenko
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void createProject() {
        final Project project = new Project();
        project.setName("New Project");
        projectRepository.save(project);
    }

}
