/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entite.Affect;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class AffectService {
    
    
      Connection cn2;
    Statement st;

    public AffectService() {
        
                        cn2 = DataBase.getInstance().getConnection();

    }
    
     public void AffectUser(Affect u) {

        try {
            String requet2 = "INSERT INTO meeting_user (meeting_id,user_id)VALUES (?,?)";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setInt(1, u.getIdMeeting());
            pst.setInt(2, u.getIdUser());
         
            pst.executeUpdate();
            System.out.println("Affected !!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
