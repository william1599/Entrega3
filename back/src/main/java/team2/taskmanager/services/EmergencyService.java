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
public class EmergencyService {

    private final EmergencyRepository EmergencyRepository;
    EmergencyService(EmergencyRepository EmergencyRepository){
        this.EmergencyRepository = EmergencyRepository;
    }

    @GetMapping("/emergencies")
    public List<Emergency> getAllEmergency(){
        return EmergencyRepository.getAllEmergency();
    }

    @PostMapping("/emergencies/changeState/{id}")
    public List<Emergency> changeState(@PathVariable int id){
        EmergencyRepository.changeState(id);
        return EmergencyRepository.getAllEmergency();
    }
    @PostMapping("/emergencies")
    @ResponseBody
    public Emergency createEmergency(@RequestBody Emergency emergency){
        Emergency result = EmergencyRepository.createEmergency(emergency);
        return result;
    }

    @GetMapping("/emergencies/delete/{id}")
    @ResponseBody
    public List<Emergency> deleteEmergency(@PathVariable int id){
        EmergencyRepository.deleteEmergency(id);
        return EmergencyRepository.getAllEmergency();
    }
    
    @PutMapping("/emergencies/update/{id}")
    @ResponseBody
    public List<Emergency> updateEmergency(@RequestBody Emergency emergency, @PathVariable int id){
        EmergencyRepository.updateEmergency(emergency, id);
        return EmergencyRepository.getAllEmergency();
    }
    @GetMapping("/emergencies/find/{id}/{R}")
    public List<Voluntary> findVoluntary(@PathVariable int id, @PathVariable int R){
        return EmergencyRepository.findVoluntary(id, R);
    }

}
