/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Date;
import java.util.Objects;



/**
 *
 * @author Deku
 */
public class Planning extends Document {
    private int id_plan;
    private String title;
    
    private String analyse;
    private String evaluate;
    private String product;
    private String sprintgoal;
    private String tasks;
    
    private Date date_creation;
    private Time time_creation;
    private Date date_modification;
    private Time time_modification;
    
    private String createdby;

    public Planning(int id_plan, String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String createdby, int id_type) {
        super(id_type);
        this.id_plan = id_plan;
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
        this.createdby = createdby;
    }

    public Planning( ) {}

    public Planning(int id_plan, String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.id_plan = id_plan;
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }
    public Planning(String title, String analyse, String evaluate, String product, String sprintgoal, String tasks) {

        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        
        this.date_creation = Date.valueOf(LocalDate.now());
        this.time_creation = Time.valueOf(LocalTime.now());
        this.date_modification = Date.valueOf(LocalDate.now());
        this.time_modification = Time.valueOf(LocalTime.now());
    }


    

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSprintgoal() {
        return sprintgoal;
    }

    public void setSprintgoal(String sprintgoal) {
        this.sprintgoal = sprintgoal;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }


    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = Date.valueOf(LocalDate.now());
    }

    public Time getTime_creation() {
        return time_creation;
    }

    public void setTime_creation(Time time_creation) {
        this.time_creation = Time.valueOf(LocalTime.now());
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = Date.valueOf(LocalDate.now());
    }

    public Time getTime_modification() {
        return time_modification;
    }

    public void setTime_modification(Time time_modification) {
        this.time_modification = Time.valueOf(LocalTime.now());
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_plan;
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.analyse);
        hash = 89 * hash + Objects.hashCode(this.evaluate);
        hash = 89 * hash + Objects.hashCode(this.product);
        hash = 89 * hash + Objects.hashCode(this.sprintgoal);
        hash = 89 * hash + Objects.hashCode(this.tasks);
        hash = 89 * hash + Objects.hashCode(this.date_creation);
        hash = 89 * hash + Objects.hashCode(this.time_creation);
        hash = 89 * hash + Objects.hashCode(this.date_modification);
        hash = 89 * hash + Objects.hashCode(this.time_modification);
        hash = 89 * hash + Objects.hashCode(this.createdby);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planning other = (Planning) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Planning{" + "id_plan=" + id_plan + ", title=" + title + ", analyse=" + analyse + ", evaluate=" + evaluate + ", product=" + product + ", sprintgoal=" + sprintgoal + ", tasks=" + tasks + ", date_creation=" + date_creation + ", time_creation=" + time_creation + ", date_modification=" + date_modification + ", time_modification=" + time_modification + ", createdby=" + createdby + '}';
    }
    
    

    
    
}
