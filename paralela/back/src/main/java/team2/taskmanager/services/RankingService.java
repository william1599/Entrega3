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
public class RankingService {
    
    private final RankingRepository RankingRepository;
    RankingService(RankingRepository RankingRepository){
        this.RankingRepository = RankingRepository;
    }
    @GetMapping("/ranking")
    public List<Ranking> getAllRanking(){
        return RankingRepository.getAllRanking();
    }
    
    @PostMapping("/ranking")
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        Ranking result = RankingRepository.createRanking(ranking);
        return result;
    }

    @GetMapping("/ranking/delete/{id}")
    @ResponseBody
    public List<Ranking> deleteRanking(@PathVariable int id){
        RankingRepository.deleteRanking(id);
        return RankingRepository.getAllRanking();
    }
    
    @PutMapping("/ranking/update/{id}")
    @ResponseBody
    public List<Ranking> updateRanking(@RequestBody Ranking ranking, @PathVariable int id){
        RankingRepository.updateRanking(ranking, id);
        return RankingRepository.getAllRanking();
    }
}