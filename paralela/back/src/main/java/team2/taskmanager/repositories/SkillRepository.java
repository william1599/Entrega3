package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface SkillRepository {
    public Skill createSkill(Skill skill);
    public List<Skill> getAllSkill();
    public void updateSkill(Skill skill, int id);
    public void deleteSkill(int id);
}