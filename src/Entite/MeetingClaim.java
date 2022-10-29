/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class MeetingClaim {
    
    private int id;
    private int user;
    private int meeting;
    private String name;
    private String email;
    private String lastname;
    private String tel;
    private String available;
    private String other;
    private String reason;
    private String date;

    public MeetingClaim() {
    }

    public MeetingClaim(int id, int user, int meeting, String name, String email, String lastname, String tel, String available, String other, String reason, String date) {
        this.id = id;
        this.user = user;
        this.meeting = meeting;
        this.name = name;
        this.email = email;
        this.lastname = lastname;
        this.tel = tel;
        this.available = available;
        this.other = other;
        this.reason = reason;
        this.date = date;
    }
    
    
     public MeetingClaim(int id, String email,  String tel,  String other, String reason) {
        this.id = id;
    
        this.email = email;
        this.tel = tel;
        this.other = other;
        this.reason = reason;
    }
  public MeetingClaim( int user, String name, String lastname,String email, String tel, int meeting,String date,  String available, String other, String reason) {
        this.user = user;
        this.meeting = meeting;
        this.name = name;
        this.email = email;
        this.lastname = lastname;
        this.tel = tel;
        this.available = available;
        this.other = other;
        this.reason = reason;
        this.date = date;
    }
  public MeetingClaim( String name, String lastname,String email, String tel, int meeting,String date,  String available, String other, String reason) {
        this.meeting = meeting;
        this.name = name;
        this.email = email;
        this.lastname = lastname;
        this.tel = tel;
        this.available = available;
        this.other = other;
        this.reason = reason;
        this.date = date;
    }
  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getMeeting() {
        return meeting;
    }

    public void setMeeting(int meeting) {
        this.meeting = meeting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.meeting);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.lastname);
        hash = 29 * hash + Objects.hashCode(this.tel);
        hash = 29 * hash + Objects.hashCode(this.available);
        hash = 29 * hash + Objects.hashCode(this.other);
        hash = 29 * hash + Objects.hashCode(this.reason);
        hash = 29 * hash + Objects.hashCode(this.date);
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
        final MeetingClaim other = (MeetingClaim) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.meeting, other.meeting)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.available, other.available)) {
            return false;
        }
        if (!Objects.equals(this.other, other.other)) {
            return false;
        }
        if (!Objects.equals(this.reason, other.reason)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeetingClaim{" + "id=" + id + ", user=" + user + ", meeting=" + meeting + ", name=" + name + ", email=" + email + ", lastname=" + lastname + ", tel=" + tel + ", available=" + available + ", other=" + other + ", reason=" + reason + ", date=" + date + '}';
    }
    
    
    
    
    
    
}
