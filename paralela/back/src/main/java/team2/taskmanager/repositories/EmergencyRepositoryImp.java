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
            String nombreTabla = "emergencia0";
            int insertedId = (int) conn.createQuery("INSERT INTO emergency0 (cod_emergency, name, estado, id_institution, tableName) values (:emergencycod_emergency, :emergencyName, :emergencyEstado, :idInstitution, :emergencyTable)", true)
                    .addParameter("emergencycod_emergency", emergency.getCod_emergency())
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("emergencyEstado", emergency.getEstado())
                    .addParameter("idInstitution", emergency.getId_institution())
                    .addParameter("emergencyTable", nombreTabla)
                    .executeUpdate().getKey();
            }
            if(tabla == 1){
            String nombreTabla = "emergencia1";
            int insertedId = (int) conn.createQuery("INSERT INTO emergency1 (cod_emergency, name, estado, id_institution, tableName) values (:emergencycod_emergency, :emergencyName, :emergencyEstado, :idInstitution, :emergencyTable)", true)
                    .addParameter("emergencycod_emergency", emergency.getCod_emergency())
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("emergencyEstado", emergency.getEstado())
                    .addParameter("idInstitution", emergency.getId_institution())
                    .addParameter("emergencyTable", nombreTabla)
                    .executeUpdate().getKey();
        }
            if(tabla == 2){
            String nombreTabla = "emergencia2";
            int insertedId = (int) conn.createQuery("INSERT INTO emergency2 (cod_emergency, name, estado, id_institution, tableName) values (:emergencycod_emergency, :emergencyName, :emergencyEstado, :idInstitution, :emergencyTable)", true)
                    .addParameter("emergencycod_emergency", emergency.getCod_emergency())
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("emergencyEstado", emergency.getEstado())
                    .addParameter("idInstitution", emergency.getId_institution())
                    .addParameter("emergencyTable", nombreTabla)
                    .executeUpdate().getKey();
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

    @Override
    public List<Get_Skills> findSkillsEmergency(int cod_emergency) {
        int tabla = cod_emergency % 3;
        List<Get_Skills> retorno = null; 
        if(tabla == 0){
            String findSql = "SELECT DISTINCT E.name as EName, E.tableName as ETableName, S.name as SName, ES.tableName as ESTableName FROM skill S, emergency0 E, eme_Skill0 ES WHERE E.cod_emergency = :id and ES.cod_emergency = :id and ES.id_skill = S.id_skill ";
            try(Connection conn = sql2o.open()){
                retorno = conn.createQuery(findSql)
                .addParameter("id", cod_emergency)
                .executeAndFetch(Get_Skills.class);
            
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        if(tabla == 1){
            String findSql = "SELECT DISTINCT E.name as EName, E.tableName as ETableName , S.name as SName, ES.tableName as ESTableName FROM skill S, emergency1 E, eme_Skill1 ES WHERE E.cod_emergency = :id and ES.cod_emergency = :id and ES.id_skill = S.id_skill ";
            try(Connection conn = sql2o.open()){
                retorno =conn.createQuery(findSql)
                .addParameter("id", cod_emergency)
                .executeAndFetch(Get_Skills.class);
            
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        if(tabla == 2){
            String findSql = "SELECT DISTINCT E.name as EName, E.tableName as EtableName, S.name as SName, ES.tableName as estableName FROM skill S, emergency2 E, eme_Skill2 ES WHERE E.cod_emergency = :id and ES.cod_emergency = :id and ES.id_skill = S.id_skill";
            try(Connection conn = sql2o.open()){
                retorno =conn.createQuery(findSql)
                .addParameter("id", cod_emergency)
                .executeAndFetch(Get_Skills.class);
            
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }
            
        }
        return retorno;
    }
}