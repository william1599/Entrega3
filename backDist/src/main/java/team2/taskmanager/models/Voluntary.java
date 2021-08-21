package team2.taskmanager.models;
import org.postgresql.util.PGobject;

public class Voluntary{
    private Integer id_voluntary;
    private String name;
    private boolean disponibilidad;
	private Integer id_emergency;
	private PGobject location;

	public PGobject getLocation() {
		return this.location;
	}

	public void setLocation(PGobject location) {
		this.location = location;
	}

	public Integer getId_voluntary() {
		return this.id_voluntary;
	}

	public void setId_voluntary(Integer id_voluntary) {
		this.id_voluntary = id_voluntary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Integer getId_emergency() {
        return this.id_emergency;
    }

    public void setId_emergency(Integer id_emergency) {
        this.id_emergency = id_emergency;
    }

}