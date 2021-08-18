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
public class SkillService {

    private final SkillRepository SkillRepository;
    SkillService(SkillRepository SkillRepository){
        this.SkillRepository = SkillRepository;
    }

    @GetMapping("/skills")
    public List<Skill> getAllSkill(){
        return SkillRepository.getAllSkill();
    }

    @PostMapping("/skills")
    @ResponseBody
    public Skill createSkill(@RequestBody Skill skill){
        Skill result = SkillRepository.createSkill(skill);
        return result;
    }

    @GetMapping("/skills/delete/{id}")
    @ResponseBody
    public List<Skill> deleteSkill(@PathVariable int id){
        SkillRepository.deleteSkill(id);
        return SkillRepository.getAllSkill();
    }
    
    @PutMapping("/skills/update/{id}")
    @ResponseBody
    public List<Skill> updateSkill(@RequestBody Skill skill, @PathVariable int id){
        SkillRepository.updateSkill(skill, id);
        return SkillRepository.getAllSkill();
    }
}
