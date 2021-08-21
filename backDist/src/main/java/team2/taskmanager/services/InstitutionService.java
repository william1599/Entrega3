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
public class InstitutionService {
    
    private final InstitutionRepository InstitutionRepository;
    InstitutionService(InstitutionRepository InstitutionRepository){
        this.InstitutionRepository = InstitutionRepository;
    }

    @GetMapping("/institutions")
    public List<Institution> getAllInstitution(){
        return InstitutionRepository.getAllInstitution();
    }

    @PostMapping("/institutions")
    @ResponseBody
    public Institution createInstitution(@RequestBody Institution institution){
        Institution result = InstitutionRepository.createInstitution(institution);
        return result;
    }

    @GetMapping("/institutions/delete/{id}")
    @ResponseBody
    public List<Institution> deleteInstitution(@PathVariable int id){
        InstitutionRepository.deleteInstitution(id);
        return InstitutionRepository.getAllInstitution();
    }
    
    @PutMapping("/institutions/update/{id}")
    @ResponseBody
    public List<Institution> updateInstitution(@RequestBody Institution institution, @PathVariable int id){
        InstitutionRepository.updateInstitution(institution, id);
        return InstitutionRepository.getAllInstitution();
    }
 
}