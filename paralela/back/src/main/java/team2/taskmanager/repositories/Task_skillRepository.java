package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface Task_skillRepository {
    public void updateTask_skill(Task_skill task_skill, int id);
    public List<Task_skill> getAllTask_skill();
    public Task_skill createTask_skill(Task_skill task_skill);
    public void deleteTask_skill(int id);
}