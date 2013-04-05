package com.project.web.managedBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.business.bean.FileBean;
import com.project.business.exceptions.TestBusinessException;
import com.project.transaction.FileTransactionBo;

@Component
@ManagedBean(name="fileUploadController")
@SessionScoped
public class FileUploadController {
	
	private static final String destination="E:\\uploadsTest\\";
	
	@NotNull
	@Size(min = 6, max = 8)
	private String user;

	@Autowired
	public FileTransactionBo fileTransactionBo;	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}	

    public void handleFileUpload(FileUploadEvent event) {
    	System.out.println("FileUploadController: begin method ");	
    	System.out.println("FileUploadController: user="+user);
		
		try {
	            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
	        } catch (IOException e) {
	            e.printStackTrace();
	    }
		
		FileBean fileBean = new FileBean();
	    fileBean.setName(event.getFile().getFileName());
	    fileBean.setPathLocation(destination);
	    fileBean.setSize(event.getFile().getSize());		
		
		try {
			fileTransactionBo.saveFile(fileBean);
		} catch (TestBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		System.out.println("FileUploadController: event.file.size="+event.getFile().getSize());
		System.out.println("FileUploadController: msg.details="+msg.getDetail());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
    
    public void copyFile(String fileName, InputStream in) {
        try {
             // write the inputStream to a FileOutputStream
             OutputStream out = new FileOutputStream(new File(destination + fileName));
          
             int read = 0;
             byte[] bytes = new byte[1024];
          
             while ((read = in.read(bytes)) != -1) {
                 out.write(bytes, 0, read);
             }
          
             in.close();
             out.flush();
             out.close();
          
             System.out.println("New file created!");
             } catch (IOException e) {
            	 System.out.println(e.getMessage());
             }
    }
}
