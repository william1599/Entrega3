package team2.taskmanager.models;

public class Status_task{
    private Integer id_status_task;
    private boolean status;

	public Integer getId_status_task() {
		return this.id_status_task;
	}

	public void setId_status_task(Integer id_status_task) {
		this.id_status_task = id_status_task;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setstatus(boolean status) {
		this.status = status;
	}
	
}