package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Vol_skillRepositoryImp implements Vol_skillRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Vol_skill createVol_skill(Vol_skill vol_skill) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO vol_skill (id_voluntary, id_skill) values (:vol_skill_id_voluntary, :vol_skill_id_skill)", true)
            .addParameter("vol_skill_id_voluntary", vol_skill.getId_voluntary())
            .addParameter("vol_skill_id_skill", vol_skill.getId_skill())
            .executeUpdate().getKey();
            vol_skill.setId_vol_skill(insertedId);
            return vol_skill;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Vol_skill> getAllVol_skill(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM vol_skill")
                    .executeAndFetch(Vol_skill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteVol_skill(int id) {
            String deleteSql ="DELETE FROM vol_skill WHERE id_vol_skill = :id";
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
    public void updateVol_skill(Vol_skill vol_skill, int id) {
        String updateSql = "update vol_skill set id_voluntary = :vol_skill_id_voluntary, id_skill = :vol_skill_id_skill where id_vol_skill = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("vol_skill_id_voluntary", vol_skill.getId_voluntary())
                    .addParameter("vol_skill_id_skill", vol_skill.getId_skill())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}