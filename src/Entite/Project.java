/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class Project {

    private int id;
    private String title;
    private String description;
    private Date date_creation;
    private Time time_creation;
    private String deadline;
    private String category;
    private int version;

    public Project() {
    }

    public Project(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;

    }
 
    public Project(int id, String title, String description, Date date_creation, Time time_creation, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.deadline = deadline;
    }

    public Project(String title, String description, String deadline, String category, int version) {
        this.title = title;
        this.description = description;

        this.date_creation = Date.valueOf(LocalDate.now());
        this.time_creation = Time.valueOf(LocalTime.now());

        this.deadline = deadline;
        this.category = category;
        this.version = version;
    }

    public Project(String title, String description, Date date_creation, Time time_creation, String deadline, String category, int version) {
        this.title = title;
        this.description = description;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.deadline = deadline;
    }

    public Project(int id, String title, String description, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public Project(int id, String title, String description, Date date_creation, Time time_creation, String deadline, String category, int version) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date_creation = Date.valueOf(LocalDate.now());
        this.time_creation = Time.valueOf(LocalTime.now());
        this.deadline = deadline;
        this.category = category;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Time getTime_creation() {
        return time_creation;
    }

    public void setTime_creation(Time time_creation) {
        this.time_creation = time_creation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.date_creation);
        hash = 89 * hash + Objects.hashCode(this.time_creation);
        hash = 89 * hash + Objects.hashCode(this.deadline);
        hash = 89 * hash + Objects.hashCode(this.category);
        hash = 89 * hash + this.version;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Project other = (Project) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date_creation, other.date_creation)) {
            return false;
        }
        if (!Objects.equals(this.time_creation, other.time_creation)) {
            return false;
        }
        if (!Objects.equals(this.deadline, other.deadline)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", title=" + title + ", description=" + description + ", date_creation=" + date_creation + ", time_creation=" + time_creation + ", deadline=" + deadline + ", category=" + category + ", version=" + version + '}';
    }

}
