package ru.gvg.spring.database.endpoint;

import org.jetbrains.annotations.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ru.gvg.spring.database.entity.Task;
import ru.gvg.spring.database.service.TaskService;
import ru.gvg.spring.model.News;
import ru.gvg.spring.soap.task.*;

import java.util.List;
import java.util.logging.Logger;

@Endpoint
public class TaskEndpoint {

    @NotNull
    private final static Logger LOGGER = Logger.getLogger(TaskEndpoint.class.getSimpleName());

    @NotNull
    public final static String LOCATION_URI = "/soap/task";

    @NotNull
    public final static String PORT_TYPE_NAME = "TaskEndpointPort";

    @NotNull
    public final static String NAMESPACE = "http://gvg.ru/spring/soap/task";

    @Autowired
    private TaskService taskService;

    @NotNull
    private PriceRecord getPrice(@NotNull final News news) {
        final PriceRecord record = new PriceRecord();
        record.setName(news.getCap());
        record.setDate(news.getDate());
        record.setPrice(news.getPrice());
        return record;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "pingRequest", namespace = NAMESPACE)
    public PingResponse ping(@RequestPayload final PingRequest request) {
        final PingResponse result = new PingResponse();
        result.setSuccess(true);
        return result;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "testRequest", namespace = NAMESPACE)
    public TestResponse test(@RequestPayload TestRequest request) {
        // TODO Impl logic
        return new TestResponse();
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getTasksRequest", namespace = NAMESPACE)
    public GetTasksResponse getTasks(@RequestPayload final GetTasksRequest request) {
        final GetTasksResponse result = new GetTasksResponse();
        try {
            final List<Task> tasks = taskService.getListTask();
            for (Task task: tasks) {
                result.getRows().add(toRecord(task));
            }
        } catch (@NotNull final Exception e) {
            LOGGER.severe(e.getMessage());
        }
        return result;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "removeTaskRequest", namespace = NAMESPACE)
    public RemoveTaskResponse removeTask(@RequestPayload final RemoveTaskRequest request) {
        final RemoveTaskResponse result = new RemoveTaskResponse();
        try {
            taskService.removeTaskById(request.getId());
            result.setSuccess(true);
        } catch (@NotNull final Exception e) {
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }


    @ResponsePayload
    @PayloadRoot(localPart = "createTaskRequest", namespace = NAMESPACE)
    public CreateTaskResponse createTask(@RequestPayload final CreateTaskRequest request) {
        final CreateTaskResponse result = new CreateTaskResponse();
        try {
            taskService.createTask(request.getName());
            result.setSuccess(true);
        } catch (@NotNull final Exception e) {
            LOGGER.severe(e.getMessage());
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @NotNull
    private TaskRecord toRecord(@NotNull final Task task) {
        final TaskRecord record = new TaskRecord();
        record.setId(task.getId());
        record.setName(task.getName());
        return record;
    }

}
