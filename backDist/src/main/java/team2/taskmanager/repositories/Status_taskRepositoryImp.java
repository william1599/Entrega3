package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Status_taskRepositoryImp implements Status_taskRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Status_task createStatus_task(Status_task status_task) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO status_task (status) values (:status_taskStatus)", true)
                    .addParameter("status_taskStatus", status_task.getStatus())
                    .executeUpdate().getKey();
            status_task.setId_status_task(insertedId);
            return status_task;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Status_task> getAllStatus(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM status_task")
                    .executeAndFetch(Status_task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteStatus(int id) {
            String deleteSql ="DELETE FROM status_task WHERE id_status_task = :id";
            try(Connection conn = sql2o.open()){
                conn.createQuery(deleteSql)
                .addParameter("id", id)
                .executeUpdate();
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
}