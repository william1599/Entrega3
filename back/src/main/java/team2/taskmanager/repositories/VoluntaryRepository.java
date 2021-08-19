package team2.taskmanager.repositories;
import team2.taskmanager.models.Voluntary;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.bson.Document;

    
/*@RepositoryRestResource(collectionResourceRel = "Voluntary", path = "voluntaries")
public interface VoluntaryRepository extends MongoRepository<Voluntary, String>{
    List<Voluntary> findByName(@Param("name") String name);
}*/


public interface VoluntaryRepository {
    public List<Voluntary> getAllVoluntary();
    //public Voluntary createVoluntary(Voluntary voluntary);
    //public void deleteVoluntary(int id);
    //public void updateVoluntary(Voluntary voluntary, int id);
}
