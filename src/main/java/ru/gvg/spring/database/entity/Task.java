package ru.gvg.spring.database.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Denis Volnenko
 */

@Table(name = Task.TABLE_NAME)
@Entity(name = Task.ENTITY_NAME)
public class Task extends AbstractEntity {

    @NotNull
    public static final String ENTITY_NAME = "Task";

    @NotNull
    public static final String TABLE_NAME = PREFIX + ENTITY_NAME;

    @ManyToOne
    private Task task;

    @NotNull
    private String name = "";

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull final String name) {
        this.name = name;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

}
