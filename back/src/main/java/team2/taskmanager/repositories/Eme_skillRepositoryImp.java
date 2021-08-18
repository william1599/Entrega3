package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Eme_skillRepositoryImp implements Eme_skillRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Eme_skill createEme_skill(Eme_skill eme_skill) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO eme_skill (id_emergency, id_skill) values (:eme_skill_id_emergency, :eme_skill_id_skill)", true)
            .addParameter("eme_skill_id_emergency", eme_skill.getId_emergency())
            .addParameter("eme_skill_id_skill", eme_skill.getId_skill())
            .executeUpdate().getKey();
            eme_skill.setId_eme_skill(insertedId);
            return eme_skill;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Eme_skill> getAllEme_skill(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM eme_skill")
                    .executeAndFetch(Eme_skill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEme_skill(int id) {
            String deleteSql ="DELETE FROM eme_skill WHERE id_eme_skill = :id";
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
    public void updateEme_skill(Eme_skill eme_skill, int id) {
        String updateSql = "update eme_skill set id_emergency = :eme_skill_id_emergency, id_skill = :eme_skill_id_skill where id_eme_skill = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("eme_skill_id_emergency", eme_skill.getId_emergency())
                    .addParameter("eme_skill_id_skill", eme_skill.getId_skill())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}