package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface Status_taskRepository {
    public Status_task createStatus_task(Status_task status_task);
    public List<Status_task> getAllStatus();
    public void deleteStatus(int id);
}