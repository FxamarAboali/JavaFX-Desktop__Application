/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Deku
 */
public class SprintRetrospective extends Document {

    private int id_retro;
    private String title;

    private String startdoing;
    private String stopdoing;
    private String continuedoing;

    private Date date_creation;
    private Time time_creation;
    private Date date_modification;
    private Time time_modification;

    private String createdby;


    public SprintRetrospective(int id_retro, String title, String startdoing, String stopdoing, String continuedoing, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.id_retro = id_retro;
        this.title = title;
        this.startdoing = startdoing;
        this.stopdoing = stopdoing;
        this.continuedoing = continuedoing;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
        this.createdby = createdby;
    }

    public SprintRetrospective(String title, String startdoing, String stopdoing, String continuedoing, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.title = title;
        this.startdoing = startdoing;
        this.stopdoing = stopdoing;
        this.continuedoing = continuedoing;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintRetrospective(String title, String startdoing, String stopdoing, String continuedoing) {
        this.title = title;
        this.startdoing = startdoing;
        this.stopdoing = stopdoing;
        this.continuedoing = continuedoing;

        this.date_creation = Date.valueOf(LocalDate.now());
        this.time_creation = Time.valueOf(LocalTime.now());
        this.date_modification = Date.valueOf(LocalDate.now());
        this.time_modification = Time.valueOf(LocalTime.now());
    }

    public int getId_retro() {
        return id_retro;
    }

    public void setId_retro(int id_retro) {
        this.id_retro = id_retro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartdoing() {
        return startdoing;
    }

    public void setStartdoing(String startdoing) {
        this.startdoing = startdoing;
    }

    public String getStopdoing() {
        return stopdoing;
    }

    public void setStopdoing(String stopdoing) {
        this.stopdoing = stopdoing;
    }

    public String getContinuedoing() {
        return continuedoing;
    }

    public void setContinuedoing(String continuedoing) {
        this.continuedoing = continuedoing;
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
        int hash = 7;
        hash = 29 * hash + this.id_retro;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.startdoing);
        hash = 29 * hash + Objects.hashCode(this.stopdoing);
        hash = 29 * hash + Objects.hashCode(this.continuedoing);
        hash = 29 * hash + Objects.hashCode(this.date_creation);
        hash = 29 * hash + Objects.hashCode(this.time_creation);
        hash = 29 * hash + Objects.hashCode(this.date_modification);
        hash = 29 * hash + Objects.hashCode(this.time_modification);
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
        final SprintRetrospective other = (SprintRetrospective) obj;
        if (this.id_retro != other.id_retro) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.startdoing, other.startdoing)) {
            return false;
        }
        if (!Objects.equals(this.stopdoing, other.stopdoing)) {
            return false;
        }
        if (!Objects.equals(this.continuedoing, other.continuedoing)) {
            return false;
        }
        if (!Objects.equals(this.date_creation, other.date_creation)) {
            return false;
        }
        if (!Objects.equals(this.time_creation, other.time_creation)) {
            return false;
        }
        if (!Objects.equals(this.date_modification, other.date_modification)) {
            return false;
        }
        if (!Objects.equals(this.time_modification, other.time_modification)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SprintRetrospective{" + "id_retro=" + id_retro + ", title=" + title + ", startdoing=" + startdoing + ", stopdoing=" + stopdoing + ", continuedoing=" + continuedoing + ", date_creation=" + date_creation + ", time_creation=" + time_creation + ", date_modification=" + date_modification + ", time_modification=" + time_modification + '}';
    }

}
