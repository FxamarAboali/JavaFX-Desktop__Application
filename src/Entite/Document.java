/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Objects;


/**
 *
 * @author Deku
 */
public class Document {
    
    int id_type;
    private String nom_type;

    public Document(int id_type, String nom_type) {
        this.id_type = id_type;
        this.nom_type = nom_type;
    }

    public Document() {
    }
    
    

    public Document(String nom_type) {
        this.nom_type = nom_type;
    }

    public Document(int id_type) {
        this.id_type = id_type;
    }
    

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id_type;
        hash = 83 * hash + Objects.hashCode(this.nom_type);
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
        final Document other = (Document) obj;
        if (this.id_type != other.id_type) {
            return false;
        }
        if (!Objects.equals(this.nom_type, other.nom_type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Document{" + "id_type=" + id_type + ", nom_type=" + nom_type + '}';
    }
    
    
}
