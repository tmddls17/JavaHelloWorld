package com.todo.dao;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TodoItem {
    private String title;
    private String desc;
    private Date current_date;
    SimpleDateFormat date;

    public TodoItem(String title, String desc){
        this.title=title;
        this.desc=desc;
        current_date = new Date();
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    public TodoItem() {
    	this.title = "";
    	this.desc = "";
    	this.current_date = new Date();
    	this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
    	this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return date.format(current_date);
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }
    
    public String toSaveString() {
    	return title + "##" + desc + "##" + date.format(current_date) + "\n";
    }
    
    @Override
    public String toString() {
    	return "[" + title + "]" + desc + " - " + date.format(current_date); 
    }
}