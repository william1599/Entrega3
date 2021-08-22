package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class InstitutionRepositorylmp implements InstitutionRepository {

    @Autowired
    private Sql2o sql2o;
    

    @Override
    public List<Institution> getAllInstitution(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institution")
                    .executeAndFetch(Institution.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institution createInstitution(Institution institution) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO institution (name) values (:institutionName)", true)
                    .addParameter("institutionName", institution.getName())
                    .executeUpdate().getKey();
            institution.setId_institution(insertedId);
            return institution;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    
    @Override
    public void deleteInstitution(int id) {
            String deleteSql ="DELETE FROM institution WHERE id_institution = :id";
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
    public void updateInstitution(Institution institution, int id) {
        String updateSql = "update institution where id_institution = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("institutionName", institution.getName())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}