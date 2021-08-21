package team2.taskmanager.repositories;
import team2.taskmanager.models.*;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class SkillPorVolRepositoryImp implements SkillPorVolRepository {

    @Autowired
    private MongoDatabase database;

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
    public ArrayList<Get_skill>  countSkills(){
    try{
        MongoClient mongoClient = new MongoClient(
            new MongoClientURI(
                "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false"
            )
        );
    MongoDatabase database = mongoClient.getDatabase("grupo2");
    MongoCollection<Document> collection = database.getCollection("voluntaries");
    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$group", 
    new Document("_id", "$_id")
            .append("skills", 
    new Document("$first", 
    new Document("$size", "$skills"))))));
    System.out.println(collection);
    ArrayList<Get_skill> resultFinal = new ArrayList<>();
        for (Document document : result) {
            Get_skill objeto = new Get_skill();
            System.out.println((String)document.get("stringId"));
            System.out.println((String)document.get("skills"));
            objeto.setId((String)document.get("stringId"));
            objeto.setTotal((int)document.get("skills"));
            resultFinal.add(objeto);
    }
    return resultFinal;
}catch(Exception e){
    System.out.println(e.getMessage());
}
return null ;
}
}