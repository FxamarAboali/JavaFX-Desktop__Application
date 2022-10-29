/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class Meeting {

    private int id;
    private String title;
    private String goal;
    private String issues;
    private String type;
    private String date;
    private String time;
    private int project;
    private String duration;
    private String location;
    private String organizedBy;

    public Meeting() {
    }

    public Meeting(String title, String goal, String issues, int project, String type, String date, String time, String duration, String location) {
        this.title = title;
        this.goal = goal;
        this.issues = issues;
        this.type = type;
        this.date = date;
        this.time = time;
        this.project = project;
        this.duration = duration;
        this.location = location;
    }

    public Meeting(String title, String goal, String issues, int project, String type, String date, String time, String duration, String location, String organizedBy) {
        this.title = title;
        this.goal = goal;
        this.issues = issues;
        this.type = type;
        this.date = date;
        this.time = time;
        this.project = project;
        this.duration = duration;
        this.location = location;
        this.organizedBy = organizedBy;
    }

    public Meeting(String title, String goal, String issues, String type, String date, String time, String duration, String location) {
        this.title = title;
        this.goal = goal;
        this.issues = issues;
        this.type = type;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.location = location;
    }

    public Meeting(int id, String title, String goal, String issues, String duration, String location) {
        this.id = id;
        this.title = title;
        this.goal = goal;
        this.issues = issues;
        this.duration = duration;
        this.location = location;
    }
    public Meeting(int id, String title, String goal, String issues, String location) {
        this.id = id;
        this.title = title;
        this.goal = goal;
        this.issues = issues;
         this.location = location;
    }

    public Meeting(String title, String goal, String issues, String type, String date, String time, String duration, String location, String organizedBy) {

        this.title = title;
        this.goal = goal;
        this.issues = issues;
        this.type = type;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.location = location;
        this.organizedBy=organizedBy;
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

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizedBy() {
        return organizedBy;
    }

    public void setOrganizedBy(String organizedBy) {
        this.organizedBy = organizedBy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + Objects.hashCode(this.goal);
        hash = 59 * hash + Objects.hashCode(this.issues);
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + Objects.hashCode(this.date);
        hash = 59 * hash + Objects.hashCode(this.time);
        hash = 59 * hash + Objects.hashCode(this.project);
        hash = 59 * hash + Objects.hashCode(this.duration);
        hash = 59 * hash + Objects.hashCode(this.location);
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
        final Meeting other = (Meeting) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.goal, other.goal)) {
            return false;
        }
        if (!Objects.equals(this.issues, other.issues)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.project, other.project)) {
            return false;
        }

        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Meeting{" + "id=" + id + ", title=" + title + ", goal=" + goal + ", issues=" + issues + ", type=" + type + ", date=" + date + ", time=" + time + ", Project=" + project + ", duration=" + duration + ", location=" + location + '}';
    }

}
