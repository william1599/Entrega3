package team2.taskmanager.models;

public class Ranking
{
    private Integer id_ranking;
	private Integer numRanking;
	private Integer id_voluntary;
	private Integer id_task;

	public Integer getId_ranking() {
		return this.id_ranking;
	}

	public void setId_ranking(Integer id_ranking) {
		this.id_ranking = id_ranking;
	}

	public Integer getNumRanking() {
		return this.numRanking;
	}

	public void setNumRanking(Integer numRanking) {
		this.numRanking = numRanking;
	}

	public Integer getId_voluntary() {
		return this.id_voluntary;
	}

	public void setId_voluntary(Integer id_voluntary) {
		this.id_voluntary = id_voluntary;
	}
	public Integer getId_task() {
		return this.id_task;
	}

	public void setId_task(Integer id_task) {
		this.id_task = id_task;
	}		
	
}