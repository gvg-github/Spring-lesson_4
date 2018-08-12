package ru.gvg.spring.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Denis Volnenko
 */

@Table(name = Project.TABLE_NAME)
@Entity(name = Project.ENTITY_NAME)
public class Project extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "Project";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @NotNull
    private String name = "";

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull final String name) {
        this.name = name;
    }

}
