package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class TaskRepositoryImp implements TaskRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Task createTask(Task task) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO task (name, id_status_task, id_task) values (:taskName, :taskEstado, :tasktask)", true)
                    .addParameter("taskName", task.getName())
                    .addParameter("taskEstado", task.getId_status_task())
                    .addParameter("tasktask", task.getId_task())
                    .executeUpdate().getKey();
            task.setId_task(insertedId);
            return task;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Get_active_tasks> getTotalTasks2(){
        String sql = "SELECT * FROM get_active_task1()";
        List<Get_active_tasks> total = null;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeAndFetch(Get_active_tasks.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return total;
    }  
    
    @Override
    public List<Task> getAllTasks(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM task")
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteTask(int id) {
            String deleteSql ="DELETE FROM task WHERE id_task = :id";
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
    public void updateTask(Task task, int id) {
        String updateSql = "update task set name = :taskName where id_task = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("taskName", task.getName())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<Get_ranking> getRanking(int id_input){
        String sql = "SELECT * FROM get_ranking(:id_input)";
        List<Get_ranking> total = null;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).addParameter("id_input", id_input).executeAndFetch(Get_ranking.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return total;
    }

}