package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Task_skillRepositoryImp implements Task_skillRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Task_skill> getAllTask_skill(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM task_skill")
                    .executeAndFetch(Task_skill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Task_skill createTask_skill(Task_skill task_skill) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO task_skill (id_task, id_eme_skill) values (:task_skill_id_task, :task_skill_id_eme_skill)", true)
                    .addParameter("task_skill_id_task", task_skill.getId_task())
                    .addParameter("task_skill_id_eme_skill", task_skill.getId_eme_skill())
                    .executeUpdate().getKey();
            task_skill.setId_task_skill(insertedId);
            return task_skill;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteTask_skill(int id) {
            String deleteSql ="DELETE FROM task_skill WHERE id_task_skill = :id";
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
    public void updateTask_skill(Task_skill task_skill, int id) {
        String updateSql = "update task_skill set id_task = :task_skill_id_task, id_eme_skill = :task_skill_id_eme_skill where id_task_skill = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("task_skill_id_task", task_skill.getId_task())
                    .addParameter("task_skill_id_eme_skill", task_skill.getId_eme_skill())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}