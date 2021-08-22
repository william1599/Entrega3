package team2.taskmanager.services;
import team2.taskmanager.models.*;
import team2.taskmanager.repositories.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
public class Task_skillService {

    private final Task_skillRepository Task_skillRepository;
    Task_skillService(Task_skillRepository Task_skillRepository){
        this.Task_skillRepository = Task_skillRepository;
    }

    @GetMapping("/task_skills")
    public List<Task_skill> getAllTask_skill(){
        return Task_skillRepository.getAllTask_skill();
    }

    @PostMapping("/task_skills")
    @ResponseBody
    public Task_skill createTask_skill(@RequestBody Task_skill task_skill){
        Task_skill result = Task_skillRepository.createTask_skill(task_skill);
        return result;
    }

    @GetMapping("/task_skills/delete/{id}")
    @ResponseBody
    public List<Task_skill> deleteTask_skill(@PathVariable int id){
        Task_skillRepository.deleteTask_skill(id);
        return Task_skillRepository.getAllTask_skill();
    }

    @PutMapping("/task_skills/update/{id}")
    @ResponseBody
    public List<Task_skill> updateTask_skill(@RequestBody Task_skill task_skill, @PathVariable int id){
        Task_skillRepository.updateTask_skill(task_skill, id);
        return Task_skillRepository.getAllTask_skill();
    }

}