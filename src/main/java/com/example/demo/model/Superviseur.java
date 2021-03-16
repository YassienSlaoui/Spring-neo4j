package com.example.demo.model;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;





public class Superviseur {
	@Id @GeneratedValue
	private  Long id;
    private  String name;
    private  Integer age;
    private  String team;
    @Relationship(type = "assignment", direction = Relationship.Direction.OUTGOING)
    private  List<User> user;
    
    
    

	public Superviseur( String name, Integer age, String team, List<User> user) {
		
		this.name = name;
		this.age = age;
		this.team = team;
		this.user = user;
	}
    public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeam() {
		return team;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	

	public String toString() {
        return name + (age != null ? " ( " + age +" " +team+  " ) " : "");
    }
}


