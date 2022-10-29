/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.DailyScrum;
import Entite.Document;
import Entite.Planning;
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
public class ServicePlanning {

    private final Connection con;
    private Statement ste;
    PreparedStatement pre;

    public ServicePlanning() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouterDoc(Planning d) throws SQLException {
        String req = "insert into planning(title"
                + ",analyse,evaluate,product,sprintgoal,tasks"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(?"
                + ",?,?,?,?,?"
                + ",?,?,?,?)";

        PreparedStatement pre1 = con.prepareStatement(req);
        pre1.setString(1, d.getTitle());

        pre1.setString(2, d.getAnalyse());
        pre1.setString(3, d.getEvaluate());
        pre1.setString(4, d.getProduct());
        pre1.setString(5, d.getSprintgoal());
        pre1.setString(6, d.getTasks());

        pre1.setDate(7, d.getDate_creation());
        pre1.setTime(8, d.getTime_creation());
        pre1.setDate(9, d.getDate_modification());
        pre1.setTime(10, d.getTime_modification());
        
        pre1.execute();
    }

    public void deletePlanning(Planning t) throws SQLException {

        String cmd = ("DELETE FROM planning WHERE id_plan = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, t.getId_plan());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteAllPlan() throws SQLException {

        String cmd = ("delete from planning");
        try {
            pre = con.prepareStatement(cmd);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void updatePlan(Planning t, int id) throws SQLException {

        String upd = "UPDATE planning SET title = ?, analyse = ?, evaluate = ?,  product = ? , sprintgoal = ? , tasks = ? , date_modification = ?, time_modification = ? WHERE id_plan = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getTitle());

            pre.setString(2, t.getAnalyse());
            pre.setString(3, t.getEvaluate());
            pre.setString(4, t.getProduct());
            pre.setString(5, t.getSprintgoal());
            pre.setString(6, t.getTasks());

            pre.setDate(7, t.getDate_modification());
            pre.setTime(8, t.getTime_modification());

            pre.setInt(9, id);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
       public void updatePlan(Planning t, String titlex) throws SQLException {

               String upd = "UPDATE planning SET title = ?, analyse = ?, evaluate = ?,  product = ? , sprintgoal = ? , tasks = ? , date_modification = ?, time_modification = ? WHERE title = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getTitle());

            pre.setString(2, t.getAnalyse());
            pre.setString(3, t.getEvaluate());
            pre.setString(4, t.getProduct());
            pre.setString(5, t.getSprintgoal());
            pre.setString(6, t.getTasks());

            pre.setDate(7, t.getDate_modification());
            pre.setTime(8, t.getTime_modification());

            pre.setString(9, titlex);
            // pre.setInt(10, id_type);

            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Planning> readAllPlan() throws SQLException {
        List<Planning> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from planning");
        while (rs.next()) {

            int id_plan = rs.getInt(1);
            String title = rs.getString("title");
            String analyse = rs.getString("analyse");
            String evaluate = rs.getString("evaluate");
            String product = rs.getString("product");
            String sprintgoal = rs.getString("sprintgoal");
            String tasks = rs.getString("tasks");

            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");

            String createdby = rs.getString("createdby");
            int id_type = rs.getInt("id_type");

            Planning d = new Planning(id_plan, title, analyse, evaluate, product, sprintgoal, tasks, date_creation, time_creation, date_modification, time_modification, createdby, id_type);

            arr.add(d);
        }
        return arr;
    }

    public boolean isExiste(String nom) throws SQLException {
        ResultSet res = null;
        String req = "select * from dailyscrum where title = ? ";
        PreparedStatement psmt = con.prepareStatement(req);
        psmt.setString(1, nom);

        res = psmt.executeQuery();

        if (res.next() == false) {
            return false;
        } else {
            return true;
        }

    }

    public String listActivite() {
        String mail = "";
        try {
            String requete2 = "SELECT * FROM planning";
            PreparedStatement pst = con.prepareStatement(requete2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mail += "\n\n";
                Planning a = new Planning();
                a.setId_plan(rs.getInt(1));
                a.setTitle(rs.getString(2));
                a.setAnalyse(rs.getString(3));

                mail += "L'activite numero " + a.getId_plan();
                mail += "\n  Libelle = " + a.getAnalyse();
                mail += "\n  Description = " + a.getTitle();

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mail;
    }

    public Planning readDaily(String titlex) throws SQLException {
        Planning pp = null;
        String requete1 = "select * from planning where title = ?";
        pre = con.prepareStatement(requete1);

        pre.setString(1, titlex);
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {

            int id_plan = rs.getInt(1);
            String title = rs.getString("title");
            String analyse = rs.getString("analyse");
            String evaluate = rs.getString("evaluate");
            String product = rs.getString("product");
            String sprintgoal = rs.getString("sprintgoal");
            String tasks = rs.getString("tasks");

            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");

            int id_type = rs.getInt("id_type");

            pp = new Planning(id_plan, title, analyse, evaluate, product, sprintgoal, tasks, date_creation, time_creation, date_modification, time_modification, id_type);

        }
        return pp;
    }

}
