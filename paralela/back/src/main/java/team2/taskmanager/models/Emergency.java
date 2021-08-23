package team2.taskmanager.models;
import org.postgresql.util.PGobject;

public class Emergency {
    private Integer cod_emergency;
    private String name;
    private boolean estado;
    private Integer id_institution;
    private PGobject location;
    private String tableName;

	public PGobject getLocation() {
		return this.location;
	}

	public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getCod_emergency() {
        return this.cod_emergency;
    }

    public void setCod_emergency(Integer cod_emergency) {
        this.cod_emergency = cod_emergency;
    }

    public void setLocation(PGobject location) {
		this.location = location;
	}

   

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getId_institution() {
        return this.id_institution;
    }

    public void setId_institution(Integer id_institution) {
        this.id_institution = id_institution;
    }
 
}   