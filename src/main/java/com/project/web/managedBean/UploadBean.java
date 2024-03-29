package com.project.web.managedBean;

import java.io.File;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UploadBean {

    private String text;
    private File file;
    private String[] check;

    public void submit() {
        // Now do your thing with the obtained input.
        System.out.println("Text: " + text);
        System.out.println("File: " + file);
        System.out.println("Check: " + Arrays.toString(check));
    }

    public String getText() {
        return text;
    }

    public File getFile() {
        return file;
    }

    public String[] getCheck() {
        return check;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setCheck(String[] check) {
        this.check = check;
    }
    
}
