package team2.taskmanager.models;

public class Get_active_tasks
{
    private String f_name;
    private Integer f_total;
	private Integer f_id;

	public Integer getF_id() {
		return this.f_id;
	}

	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}

	public String getF_name() {
		return this.f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public Integer getF_total() {
		return this.f_total;
	}

	public void setF_total(Integer f_total) {
		this.f_total = f_total;
	}
	
}