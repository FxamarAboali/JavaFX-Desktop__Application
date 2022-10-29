/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Document;
import Entite.SprintRetrospective;
import Entite.SprintReview;
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
public class ServiceSprintReview {
    
    private final Connection con;
    private Statement ste;
    PreparedStatement pre;

    public ServiceSprintReview() {
    con = DataBase.getInstance().getConnection();

    }


    public void ajouterReview(SprintReview d) throws SQLException {
                String req = "insert into sprintreview(id_review,title,"
                + "projectname, thingstodemo, quickupdates, whatisnext"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(NULL,?,"
                + "?,?,?,?,"
                + "?,?,?,?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre.setString(1, d.getTitle());
        
        pre1.setString(2, d.getProjectname());
        pre1.setString(3, d.getThingstodemo());
        pre1.setString(4, d.getQuickupdates());
        pre1.setString(5, d.getWhatisnext());
        
        
        pre1.setDate(6, d.getDate_creation());
        pre1.setTime(7, d.getTime_creation());
        pre1.setDate(8, d.getDate_modification());
        pre1.setTime(9, d.getTime_modification());
        
        pre1.execute();
    }

    public void deleteRetro(SprintReview t) throws SQLException {

        String cmd = ("DELETE FROM sprintreview WHERE id_review = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, t.getId_review());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void deleteAllRetro() throws SQLException {

        String cmd = ("delete from sprintreview");
        try {
            pre = con.prepareStatement(cmd);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    
    public void updateReview(SprintReview t) throws SQLException {

        String upd = "UPDATE sprintreview SET title = ?, projectname = ?, thingstodemo = ?,  quickupdates = ? , whatisnext = ?, date_modification = ?, time_modification = ? WHERE id_review = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getTitle());
            
            pre.setString(2, t.getProjectname());
            pre.setString(3, t.getThingstodemo());
            pre.setString(4, t.getQuickupdates());
            pre.setString(5, t.getWhatisnext());
            
            pre.setDate(6, t.getDate_modification());
            pre.setTime(7, t.getTime_modification());

            pre.setInt(8, t.getId_review());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public boolean isExiste(String nom) throws SQLException {
        ResultSet res = null;
        String req = "select * from sprintreview where title = ? ";
        PreparedStatement psmt = con.prepareStatement(req);
        psmt.setString(1, nom);

        res = psmt.executeQuery();

        if (res.next() == false) {
            return false;
        } else {
            return true;
        }

    }


    public List<SprintReview> readAllPlan() throws SQLException {
        List<SprintReview> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from sprintreview");
        while (rs.next()) {
            
            int id_plan = rs.getInt(1);
            String title = rs.getString("title");
            
            String projectname = rs.getString("projectname");
            String thingstodemo = rs.getString("thingstodemo");
            String quickupdates = rs.getString("quickupdates");
            String whatisnext = rs.getString("whatisnext");
                
            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");
            
            int id_type = rs.getInt("id_type");
            

            SprintReview d = new SprintReview(id_plan, title, projectname, thingstodemo, quickupdates, whatisnext, date_creation, time_creation, date_modification, time_modification, id_type);

            arr.add(d);
        }
        return arr;
    }
    
     public SprintReview readReview(String titlex) throws SQLException {
        SprintReview rv = null;
        String requete1 = "select * from sprintreview where title = ?";
        pre = con.prepareStatement(requete1);

        pre.setString(1, titlex);
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {

            int id_retro = rs.getInt(1);
            String title = rs.getString("title");
            
            String projectname = rs.getString("projectname");
            String thingstodemo = rs.getString("thingstodemo");
            String quickupdates = rs.getString("quickupdates");
            String whatisnext = rs.getString("whatisnext");

            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");

            int id_type = rs.getInt("id_type");

            rv = new SprintReview(id_retro, title, projectname, thingstodemo, quickupdates, whatisnext, date_creation, time_creation, date_modification, time_modification, id_type);

        }
        return rv;
    }
}
