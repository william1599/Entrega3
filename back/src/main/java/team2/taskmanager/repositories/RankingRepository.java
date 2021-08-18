package team2.taskmanager.repositories;
import team2.taskmanager.models.*;
import java.util.List;

public interface RankingRepository {
    public void updateRanking(Ranking Ranking, int id);
    public List<Ranking> getAllRanking();
    public Ranking createRanking(Ranking Ranking);
    public void deleteRanking(int id);
}