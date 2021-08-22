package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface TaskRepository {
    public List<Task> getAllTasks();
    public void updateTask(Task task, int id);
    public List<Get_active_tasks>  getTotalTasks2();  
    public Task createTask(Task task);
    public void deleteTask(int id);
    public List<Get_ranking> getRanking(int id);
}