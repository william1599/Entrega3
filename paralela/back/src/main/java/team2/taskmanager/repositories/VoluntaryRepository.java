package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface VoluntaryRepository {
    public List<Voluntary> getAllVoluntary();
    public Voluntary createVoluntary(Voluntary voluntary);
    public void deleteVoluntary(int id);
    public void updateVoluntary(Voluntary voluntary, int id);
}