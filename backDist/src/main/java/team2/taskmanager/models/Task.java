package team2.taskmanager.models;

public class Task{
    private Integer id_task;
    private String name;
    private Integer id_status_task;
    private Integer id_emergency;

	public Integer getId_task() {
		return this.id_task;
	}

	public void setId_task(Integer id_task) {
		this.id_task = id_task;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Integer getId_status_task() {
		return this.id_status_task;
	}

    public Integer getId_emergency() {
		return this.id_emergency;
	}
	
}