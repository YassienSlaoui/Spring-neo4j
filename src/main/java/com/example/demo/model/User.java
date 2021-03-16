package com.example.demo.model;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Node
public class User {
	@Id @GeneratedValue
	private  Long id;
    private String name;
    private Integer age;
    private String team;
    public User(Integer age, String name,String team) {      
    	
		
		this.age = age;
        this.name = name;
        this.team = team;       
    }
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getTeam() {
		return team;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String toString() {
        return " "+name+ (age != null ? " ( " + age +" " +team+  " ) " : "");
    }
}