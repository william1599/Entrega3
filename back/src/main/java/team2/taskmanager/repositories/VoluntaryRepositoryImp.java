package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
import org.bson.Document;
import java.util.ArrayList;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class VoluntaryRepositoryImp implements VoluntaryRepository{
    @Autowired
    MongoDatabase database;

    /*@Override
    public Voluntary createVoluntary(Voluntary voluntary){
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO voluntary (name, disponibilidad, id_emergency) values (:volName, :volDisp, :idEmergency)", true)
                    .addParameter("volName", voluntary.getName())
                    .addParameter("volDisp", voluntary.getDisponibilidad())
                    .addParameter("idEmergency", voluntary.getId_emergency())
                    .executeUpdate().getKey();
            voluntary.setId_voluntary(insertedId);
            return voluntary;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }*/

    
    @Override
    public List<Voluntary> getAllVoluntary(){   
        MongoCollection<Voluntary> collection = database.getCollection("voluntary", Voluntary.class);
        List <Voluntary> voluntaries = collection.find().into(new ArrayList<>());
        
        return voluntaries;
        
    }

/*
    @Override
    public void deleteVoluntary(int id) {
            String deleteSql ="DELETE FROM voluntary WHERE id_voluntary = :id";
            try(Connection conn = sql2o.open()){
                conn.createQuery(deleteSql)
                .addParameter("id", id)
                .executeUpdate();
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void updateVoluntary(Voluntary voluntary, int id) {
        String updateSql = "update voluntary set name = :voluntaryName, disponibilidad =:disp where id_voluntary = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("voluntaryName", voluntary.getName())
                    .addParameter("disp", voluntary.getDisponibilidad())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/
}
