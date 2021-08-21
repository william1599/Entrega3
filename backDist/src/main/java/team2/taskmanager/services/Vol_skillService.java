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
public class Vol_skillService {
    
    private final Vol_skillRepository Vol_skillRepository;
    Vol_skillService(Vol_skillRepository Vol_skillRepository){
        this.Vol_skillRepository = Vol_skillRepository;
    }

    @GetMapping("/vol_skills")
    public List<Vol_skill> getAllVol_skill(){
        return Vol_skillRepository.getAllVol_skill();
    }

    @PostMapping("/vol_skills")
    @ResponseBody
    public Vol_skill createVol_skill(@RequestBody Vol_skill vol_skill){
        Vol_skill result = Vol_skillRepository.createVol_skill(vol_skill);
        return result;
    }

    @GetMapping("/vol_skills/delete/{id}")
    @ResponseBody
    public List<Vol_skill> deleteVol_skill(@PathVariable int id){
        Vol_skillRepository.deleteVol_skill(id);
        return Vol_skillRepository.getAllVol_skill();
    }

    @PutMapping("/vol_skills/update/{id}")
    @ResponseBody
    public List<Vol_skill> updateVol_skill(@RequestBody Vol_skill vol_skill, @PathVariable int id){
        Vol_skillRepository.updateVol_skill(vol_skill, id);
        return Vol_skillRepository.getAllVol_skill();
    }

}