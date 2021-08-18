package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface InstitutionRepository {
    public void updateInstitution(Institution institution, int id);
    public List<Institution> getAllInstitution();
    public Institution createInstitution(Institution institution);
    public void deleteInstitution(int id);
}