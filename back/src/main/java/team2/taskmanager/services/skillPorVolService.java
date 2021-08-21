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

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class skillPorVolService{
    
    private final SkillPorVolRepository SkillPorVolRepository;
    skillPorVolService(SkillPorVolRepository skillPorVolRepository){
        this.SkillPorVolRepository = skillPorVolRepository;
    }

     
    @GetMapping("/voluntaries/skills")
    
    public ArrayList<Get_skill> countSkills(){
        ArrayList<Get_skill> retorno= SkillPorVolRepository.countSkills();
        return retorno;
    }
}