/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Project;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ProjectService {

    PreparedStatement pre;

    Connection cn2;
    Statement st;

    public ProjectService() {

        cn2 = DataBase.getInstance().getConnection();

    }

//    public static java.sql.Timestamp getCurrentTime() {
//        java.util.Date today = new java.util.Date();
//        return new java.sql.Timestamp(today.getTime());
//
//    }
//
//    private static java.sql.Date getCurrentDate() {
//        java.util.Date today = new java.util.Date();
//        return new java.sql.Date(today.getTime());
//    }
    public void insert(Project p) {

        try {
            String requet2 = "INSERT INTO project (ProjectTitle, description,date_creation,time_creation,deadline,category,version)VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setString(1, p.getTitle());
            pst.setString(2, p.getDescription());
            pst.setDate(3, p.getDate_creation());
            pst.setTime(4, p.getTime_creation());
            pst.setString(5, p.getDeadline());
            pst.setString(6, p.getCategory());
            pst.setInt(7, p.getVersion());
            pst.executeUpdate();
            System.out.println("Project added!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Project> selectAll() {
        ArrayList<Project> proj = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM project";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Project p = new Project();
                p.setId(rs.getInt(1));
                p.setTitle(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setDate_creation(rs.getDate(4));
                p.setTime_creation(rs.getTime(5));
                p.setDeadline(rs.getString(6));
                p.setCategory(rs.getString(7));
                p.setVersion(rs.getInt(8));
                proj.add(p);
                System.out.println(proj);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return proj;
    }

    public List<String> selectTitle() {
        ArrayList<String> proj = new ArrayList<>();

        try {
            String requet3 = "SELECT ProjectTitle FROM project";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Project p = new Project();
                p.setTitle(rs.getString("ProjectTitle"));
                proj.add(p.getTitle());

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return proj;
    }

    public void updateProject(Project p) {
        String req3 = "UPDATE project set ProjectTitle=? ,description=?, deadline=? , category=? , version=? where idProject= ? ; ";
        try {
            PreparedStatement pre = cn2.prepareStatement(req3);
            pre.setString(1, p.getTitle());
            pre.setString(2, p.getDescription());
            pre.setString(3, p.getDeadline());
            pre.setString(4, p.getCategory());
            pre.setInt(5, p.getVersion());
            pre.setInt(6, p.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProjectById(int id) {
        try {
            String req = "DELETE from project WHERE idProject =?";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteProject(Project p) {

        try {
            String req = "DELETE from project where idProject=? ";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.setInt(1, p.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteAllProjects() {

        try {
            String req = "DELETE from project ";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void CountProjects() {

        try {
            String req = "select count(*) from project ";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Project readProject(String titlex) throws SQLException {
        Project dd = null;
        String requete1 = "select * from project where ProjectTitle = ?";
        pre = cn2.prepareStatement(requete1);

        pre.setString(1, titlex);
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {

            int id = rs.getInt(1);
            String title = rs.getString("ProjectTitle");
            String description = rs.getString("description");
            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            String deadline = rs.getString("deadline");
            String category = rs.getString("category");
            int version = rs.getInt("version");

            dd = new Project(id, title, description, date_creation, time_creation, deadline,category,version);

        }
        return dd;
    }
}
