package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface EmergencyRepository {
    public void changeState(int id);
    public void updateEmergency(Emergency emergency, int id);
    public List<Emergency> getAllEmergency();
    public Emergency createEmergency(Emergency emergency);
    public void deleteEmergency(int id);
    public List<Voluntary> findVoluntary(int id, int R);
    public List<Get_Skills> findSkillsEmergency(int cod_emergency);
}