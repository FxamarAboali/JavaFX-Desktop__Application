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
public class SprintReview extends Document{
    
    private int id_review;
    private String title;

    private String projectname;
    private String thingstodemo;
    private String quickupdates;
    private String whatisnext;
    
    private Date date_creation;
    private Time time_creation;
    private Date date_modification;
    private Time time_modification;

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type, String nom_type) {
        super(id_type, nom_type);
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String nom_type) {
        super(nom_type);
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String nom_type) {
        super(nom_type);
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(String title, int id_type) {
        super(id_type);
        this.title = title;
    }

    public SprintReview(String title) {
        this.title = title;
    }

    public SprintReview(String title, String projectname, String thingstodemo, String quickupdates, String whatisnext) {
    
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
    }

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification) {
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext) {
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
    }
    
    

    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getThingstodemo() {
        return thingstodemo;
    }

    public void setThingstodemo(String thingstodemo) {
        this.thingstodemo = thingstodemo;
    }

    public String getQuickupdates() {
        return quickupdates;
    }

    public void setQuickupdates(String quickupdates) {
        this.quickupdates = quickupdates;
    }

    public String getWhatisnext() {
        return whatisnext;
    }

    public void setWhatisnext(String whatisnext) {
        this.whatisnext = whatisnext;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id_review;
        hash = 41 * hash + Objects.hashCode(this.title);
        hash = 41 * hash + Objects.hashCode(this.projectname);
        hash = 41 * hash + Objects.hashCode(this.thingstodemo);
        hash = 41 * hash + Objects.hashCode(this.quickupdates);
        hash = 41 * hash + Objects.hashCode(this.whatisnext);
        hash = 41 * hash + Objects.hashCode(this.date_creation);
        hash = 41 * hash + Objects.hashCode(this.time_creation);
        hash = 41 * hash + Objects.hashCode(this.date_modification);
        hash = 41 * hash + Objects.hashCode(this.time_modification);
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
        final SprintReview other = (SprintReview) obj;
        if (this.id_review != other.id_review) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.projectname, other.projectname)) {
            return false;
        }
        if (!Objects.equals(this.thingstodemo, other.thingstodemo)) {
            return false;
        }
        if (!Objects.equals(this.quickupdates, other.quickupdates)) {
            return false;
        }
        if (!Objects.equals(this.whatisnext, other.whatisnext)) {
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
        return "SprintReview{" + "id_review=" + id_review + ", title=" + title + ", projectname=" + projectname + ", thingstodemo=" + thingstodemo + ", quickupdates=" + quickupdates + ", whatisnext=" + whatisnext + ", date_creation=" + date_creation + ", time_creation=" + time_creation + ", date_modification=" + date_modification + ", time_modification=" + time_modification + '}';
    }
    
    
    
}
