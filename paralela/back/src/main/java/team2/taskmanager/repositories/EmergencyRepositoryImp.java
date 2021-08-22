package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class EmergencyRepositoryImp implements EmergencyRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void changeState(int id){
        List<String> lista_caso = null;
        try(Connection conn = sql2o.open()){
            lista_caso = conn.createQuery("SELECT estado FROM emergency WHERE id_emergency = :id")
                    .addParameter("id", id)
                    .executeAndFetch(String.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        String caso = lista_caso.get(0);
        if (caso.equals("true")){
            String updateSql ="update emergency set estado = false where id_emergency = :id";
            try(Connection conn = sql2o.open()){
                conn.createQuery(updateSql)
                .addParameter("id", id)
                .executeUpdate();
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (caso.equals("false")){
            String updateSql ="update emergency set estado = true where id_emergency = :id";
            try(Connection conn = sql2o.open()){
                conn.createQuery(updateSql)
                .addParameter("id", id)
                .executeUpdate();
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<Emergency> getAllEmergency(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergency")
                    .executeAndFetch(Emergency.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergency createEmergency(Emergency emergency) {
        try(Connection conn = sql2o.open()){
            int cod_emergency = emergency.getCod_emergency();
            int tabla = cod_emergency % 3;
            if(tabla == 0){

            int insertedId = (int) conn.createQuery("INSERT INTO emergencia0 (cod_emergency, name, estado) values (:emergencycod_emergency, :emergencyName, :emergencyEstado)", true)
                    .addParameter("emergencycod_emergency", emergency.getCod_emergency())
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("emergencyEstado", emergency.isEstado())
                    .executeUpdate().getKey();
            emergency.setId_emergency(insertedId);
            emergency.setTableName("emergencia0");
            }
            if(tabla == 1){

            int insertedId = (int) conn.createQuery("INSERT INTO emergencia1 (cod_emergency, name, estado) values (:emergencycod_emergency, :emergencyName, :emergencyEstado)", true)
                    .addParameter("emergencycod_emergency", emergency.getCod_emergency())
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("emergencyEstado", emergency.isEstado())
                    .executeUpdate().getKey();
            emergency.setId_emergency(insertedId);
            emergency.setTableName("emergencia1");
        }
            if(tabla == 2){

            int insertedId = (int) conn.createQuery("INSERT INTO emergencia2 (cod_emergency, name, estado) values (:emergencycod_emergency, :emergencyName, :emergencyEstado)", true)
                    .addParameter("emergencycod_emergency", emergency.getCod_emergency())
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("emergencyEstado", emergency.isEstado())
                    .executeUpdate().getKey();
            emergency.setId_emergency(insertedId);
            emergency.setTableName("emergencia2");
        }
        return emergency;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEmergency(int id) {
            String deleteSql ="DELETE FROM emergency WHERE id_emergency = :id";
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
    public void updateEmergency(Emergency emergency, int id) {
        String updateSql = "update emergency set name = :emergencyName where id_emergency = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Voluntary> findVoluntary(int id, int R) {
        String findSql = "SELECT V.* FROM voluntary V, emergency E WHERE E.id_emergency = :id and st_distance(E.location::geography, V.location::geography) < :radio and V.id_emergency = :id";
        try(Connection conn = sql2o.open()){
                return conn.createQuery(findSql)
                .addParameter("id", id)
                .addParameter("radio", R)
                .executeAndFetch(Voluntary.class);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}