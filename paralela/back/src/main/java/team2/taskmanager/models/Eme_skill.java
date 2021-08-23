package team2.taskmanager.models;

public class Eme_skill {
    private Integer id_eme_skill;
    private Integer cod_emergency;
    private Integer id_skill;
	private String tableName;

	public Integer getId_eme_skill() {
		return this.id_eme_skill;
	}

	public void setId_eme_skill(Integer id_eme_skill) {
		this.id_eme_skill = id_eme_skill;
	}

	public Integer getCod_emergency(){
		return this.cod_emergency;
	}

	public void setCod_emergency(Integer cod_emergency) {
		this.cod_emergency = cod_emergency;
	}

	public Integer getId_skill() {
		return this.id_skill;
	}

	public void setId_skill(Integer id_skill) {
		this.id_skill = id_skill;
	}
	public String getTableName() {
        return tableName;
    }

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}