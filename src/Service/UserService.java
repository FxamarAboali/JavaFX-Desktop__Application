/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entite.User;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class UserService {
    
    
     Connection cn2;
    Statement st;

    public UserService() {
        
                cn2 = DataBase.getInstance().getConnection();

    }

       public List<String> selectName() {
        ArrayList<String> proj = new ArrayList<>();

        try {
            String requet3 = "SELECT username FROM user";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                User p = new User();
                p.setUserName(rs.getString("username"));
                proj.add(p.getUserName());

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return proj;
    }
       
       
        public String readRole() throws SQLException{
 String requet3 = "SELECT roles FROM user";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                User p = new User();
                p.setRoles(rs.getString("roles"));
      }
         return requet3;
            
        }
     
        
         public User chercherUtilisateurByid(Integer id) {
        String sql = "SELECT * FROM fosuser WHERE id=?";
           User user = null;
        try {
            PreparedStatement pst2 = cn2.prepareStatement(sql);
            pst2.setInt(1, id);
            ResultSet resultSet = pst2.executeQuery();
            if (resultSet.next()) {

                 user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("pseudoName"),
                        resultSet.getString("email"),
                        resultSet.getString("user_password"),
                        resultSet.getString("roles"));
              
             
            }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return user;
    }
    
}
