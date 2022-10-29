/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Document;
import Entite.Planning;
import Entite.SprintRetrospective;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deku
 */
public class ServiceSprintRetro {
    
    private final Connection con;
    private Statement ste;
    PreparedStatement pre;

    public ServiceSprintRetro() {
        con = DataBase.getInstance().getConnection();

    }


    public void ajouterRetro(SprintRetrospective d) throws SQLException {
                String req = "insert into retrospective(title,"
                + "startdoing,stopdoing,continuedoing"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(?,"
                + "?,?,?,"
                + "?,?,?,?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre1.setString(1, d.getTitle());
        
        pre1.setString(2, d.getStartdoing());
        pre1.setString(3, d.getStopdoing());
        pre1.setString(4, d.getContinuedoing());
        
        pre1.setDate(5, d.getDate_creation());
        pre1.setTime(6, d.getTime_creation());
        pre1.setDate(7, d.getDate_modification());
        pre1.setTime(8, d.getTime_modification());
        
        pre1.execute();
    }

   
    public void deleteRetro(SprintRetrospective t) throws SQLException {

        String cmd = ("DELETE FROM retrospective WHERE id_retro = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, t.getId_retro());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void deleteAllRetro() throws SQLException {

        String cmd = ("delete from retrospective");
        try {
            pre = con.prepareStatement(cmd);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    
    public void updateRetro(SprintRetrospective t,String selected) throws SQLException {

        String upd = "UPDATE retrospective SET title = ?, startdoing = ?, stopdoing = ?,  continuedoing = ? , date_modification = ?, time_modification = ? WHERE title = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getTitle());
            
            pre.setString(2, t.getStartdoing());
            pre.setString(3, t.getStopdoing());
            pre.setString(4, t.getContinuedoing());
            
            pre.setDate(5, t.getDate_modification());
            pre.setTime(6, t.getTime_modification());

            pre.setString(7, selected);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public boolean isExiste(String nom) throws SQLException {
        ResultSet res = null;
        String req = "select * from retrospective where title = ? ";
        PreparedStatement psmt = con.prepareStatement(req);
        psmt.setString(1, nom);

        res = psmt.executeQuery();

        if (res.next() == false) {
            return false;
        } else {
            return true;
        }

    }


    public List<SprintRetrospective> readAllRetro() throws SQLException {
        List<SprintRetrospective> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from retrospective");
        while (rs.next()) {
            
            int id_plan = rs.getInt(1);
            String title = rs.getString("title");
            
            String startdoing = rs.getString("startdoing");
            String stopdoing = rs.getString("stopdoing");
            String continuedoing = rs.getString("continuedoing");  
                
            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");
            
            int id_type = rs.getInt("id_type");
            

            SprintRetrospective d = new SprintRetrospective(id_plan, title, startdoing, stopdoing, continuedoing, date_creation, time_creation, date_modification, time_modification, id_type);

            arr.add(d);
        }
        return arr;
    }
    
    
       public SprintRetrospective readRetro(String titlex) throws SQLException {
        SprintRetrospective rr = null;
        String requete1 = "select * from retrospective where title = ?";
        pre = con.prepareStatement(requete1);

        pre.setString(1, titlex);
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {

            int id_retro = rs.getInt(1);
            String title = rs.getString("title");
            String startdoing = rs.getString("startdoing");
            String stopdoing = rs.getString("stopdoing");
            String continuedoing = rs.getString("continuedoing");

            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");

            int id_type = rs.getInt("id_type");

            rr = new SprintRetrospective(id_retro, title, startdoing, stopdoing, continuedoing, date_creation, time_creation, date_modification, time_modification, id_type);

        }
        return rr;
    }
}
