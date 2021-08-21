package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class SkillRepositoryImp implements SkillRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Skill> getAllSkill(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM skill")
                    .executeAndFetch(Skill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Skill createSkill(Skill skill) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO skill (name) values (:skillName)", true)
                    .addParameter("skillName", skill.getName())
                    .executeUpdate().getKey();
            skill.setId_skill(insertedId);
            return skill;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteSkill(int id) {
            String deleteSql ="DELETE FROM skill WHERE id_skill = :id";
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
    public void updateSkill(Skill skill, int id) {
        String updateSql = "update skill set name = :skillName where id_skill = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("skillName", skill.getName())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}