package team2.taskmanager.models;

public class Get_Skills
{
    private String EName;
	private String SName;
	private String ETableName;
	private String ESTableName;


	public String getEName() {
		return EName;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String SName) {
		this.SName = SName;
	}
	public String getESTableName() {
		return ESTableName;
	}
	public void setESTableName(String ESTableName) {
		this.ESTableName = ESTableName;
	}
	public String getETableName() {
		return ETableName;
	}
	public void setETableName(String ETableName) {
		this.ETableName = ETableName;
	}
	public void setEName(String EName) {
		this.EName = EName;
	}
}