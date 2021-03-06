package team2.taskmanager.models;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import team2.taskmanager.models.Skill;

public class Voluntary{
	@BsonId
    ObjectId _id;

    //@Id private String id;
    private String name;
    private String disponibilidad;
	private int id_emergency;
	private List<Float> location;
	private List<Skill> skills;

	public Voluntary(ObjectId _id, String name, String disponibilidad, int id_emergency, List<Float> location, List<Skill> skills){
		this._id = _id;
		this.name = name;
		this.disponibilidad = disponibilidad;
		this.id_emergency = id_emergency;
		this.location = location;
		this.skills = skills;

	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public List<Float> getLocation() {
		return this.location;
	}

	public void setLocation(List<Float> location) {
		this.location = location;
	}

	public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }
    public String getStringId(){
        return this._id.toString();
    }

/*
	public String getId() {
		return this.id;
	}

	public void setId(String id){
		this.id = id;
	}
*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Integer getId_emergency() {
        return this.id_emergency;
    }

    public void setId_emergency(Integer id_emergency) {
        this.id_emergency = id_emergency;
    }
	
	
}