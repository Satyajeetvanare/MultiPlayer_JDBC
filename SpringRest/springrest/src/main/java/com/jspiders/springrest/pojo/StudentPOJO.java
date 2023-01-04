package com.jspiders.springrest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="Studnet_SpringRest")
public class StudentPOJO {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String email;
	
	private String  username;
	
	private String password;
	

}
