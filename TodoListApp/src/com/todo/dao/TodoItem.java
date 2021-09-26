package com.todo.dao;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TodoItem {
    private String title;
    private String desc;
    private Date current_date;
    private SimpleDateFormat date;
    private String category;
    private String due_date;

    public TodoItem(String title, String desc, String category, String due_date){
        this.title=title;
        this.desc=desc;
        current_date = new Date();
        this.date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.category = category;
        this.due_date = due_date;
    }
    
    public TodoItem() {
    	this.title = "";
    	this.desc = "";
    	this.current_date = new Date();
    	this.date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
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
    	this.date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return date.format(current_date);
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }
    
    public String getCategory () {
    	return this.category;
    }
    
    public void setCategory (String category) {
    	this.category = category;
    }
    
    public String getDueDate() {
    	return this.due_date;
    }
    
    public void setDueDate(String due_date) {
    	this.due_date = due_date;
    }
    
    public String toSaveString() {
    	return category + "##" + title + "##" + desc + "##" + due_date + "##" +date.format(current_date) + "\n";
    }
    
    @Override
    public String toString() {
    	return "[" + category + "] " + title + " - "+ desc + " - " + due_date + " - "+ date.format(current_date); 
    }
}