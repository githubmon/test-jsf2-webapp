package com.project.web.managedBean;

import java.io.File;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class UploadFileBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 6, max = 8)
	private String user;
	
	private String device;
	private File file;
	
    public String upload() {
        // Now do your thing with the obtained input.
        System.out.println("User: " + user);
        System.out.println("File: " + file);
        System.out.println("Device: " + device);
        
        return "responseUpload";
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public String getDevice() {
		this.device = "web";
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
	
}
