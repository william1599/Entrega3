package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface Vol_skillRepository {
    public List<Vol_skill> getAllVol_skill();
    public Vol_skill createVol_skill(Vol_skill vol_skill);
    public void deleteVol_skill(int id);
    public void updateVol_skill(Vol_skill vol_skill, int id);

}