package ru.gvg.spring.database.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gvg.spring.database.service.ProjectService;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.08.2018.
 */
@Component
public class AutoStart implements InitializingBean {

    @Autowired
    private ProjectService projectService;

    @Override
    public void afterPropertiesSet() throws Exception {
        projectService.createProject();
    }

}
