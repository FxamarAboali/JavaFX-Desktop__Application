/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Lenovo
 */
public class Affect {
    
    private int idUser;
    private int idMeeting;

    public Affect() {
    }

    public Affect(int idUser, int idMeeting) {
        this.idUser = idUser;
        this.idMeeting = idMeeting;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.idUser;
        hash = 71 * hash + this.idMeeting;
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
        final Affect other = (Affect) obj;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idMeeting != other.idMeeting) {
            return false;
        }
        return true;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(int idMeeting) {
        this.idMeeting = idMeeting;
    }
    
    
    
    
    
    
}
