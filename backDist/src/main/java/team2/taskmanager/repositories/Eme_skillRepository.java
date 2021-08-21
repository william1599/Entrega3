package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface Eme_skillRepository {
    public List<Eme_skill> getAllEme_skill();
    public Eme_skill createEme_skill(Eme_skill eme_skill);
    public void deleteEme_skill(int id);
    public void updateEme_skill(Eme_skill eme_skill, int id);
}