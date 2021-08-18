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
public class Status_taskService {
    
    private final Status_taskRepository Status_taskRepository;
    Status_taskService(Status_taskRepository Status_taskRepository){
        this.Status_taskRepository = Status_taskRepository;
    }

    @GetMapping("/status_tasks")
    public List<Status_task> getAllStatus(){
        return Status_taskRepository.getAllStatus();
    }

    @PostMapping("/status_tasks")
    @ResponseBody
    public Status_task createStatus_task(@RequestBody Status_task status_task){
        Status_task result = Status_taskRepository.createStatus_task(status_task);
        return result;
    }

    @GetMapping("/status_tasks/delete/{id}")
    @ResponseBody
    public List<Status_task> deleteStatus(@PathVariable int id){
        Status_taskRepository.deleteStatus(id);
        return Status_taskRepository.getAllStatus();
    }
}