package com.project.web.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Controller class
 * @author User
 *
 */
@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	// Input text validation in the view file
	@NotNull
	@Size(min = 6, max = 8)
	private String name;
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Text Ajax sample....
	public String getSayWelcome(){
		//check if null?
	   if("".equals(name) || name ==null){
		   return "";
	   }else{
		   return "Ajax message : Welcome " + name;
	   }
	}
}

