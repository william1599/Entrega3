package team2.taskmanager.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Skill{


	@BsonId
    //private Integer id_skill;
    private String name;
	private String description;
	private String code;

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
    
    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}