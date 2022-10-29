/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entite.Meeting;
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
public class MeetingService {
    
    
     Connection cn2;
    Statement st;
        PreparedStatement pre;


    public MeetingService() {
        
                cn2 = DataBase.getInstance().getConnection();

    }
    
    
    public void insert(Meeting m) {

        try {
            String requet2 = "INSERT INTO meeting (title,goal,issues,project_id,type,date,time,duration,location,organizedBy)VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setString(1, m.getTitle());
            pst.setString(2, m.getGoal());
            pst.setString(3, m.getIssues());
            pst.setInt(4, m.getProject());
            pst.setString(5, m.getType());
           // pst.setString(6, m.getMember());
            pst.setString(6, m.getDate());
            pst.setString(7, m.getTime());
            pst.setString(8, m.getDuration());
            pst.setString(9, m.getLocation());
            pst.setString(10, m.getOrganizedBy());
            pst.executeUpdate();
            System.out.println("Meeting added!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      public List<Meeting> selectAll() {
        ArrayList<Meeting> meet = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM meeting";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Meeting p = new Meeting();
                p.setTitle(rs.getString("title"));
                p.setGoal(rs.getString("goal"));
                p.setIssues(rs.getString("issues"));
                p.setProject(rs.getInt("project_id"));
                p.setType(rs.getString("type"));
                p.setDate(rs.getString("date"));
                p.setTime(rs.getString("time"));
                p.setDuration(rs.getString("duration"));
                p.setLocation(rs.getString("location"));
                p.setLocation(rs.getString("organizedBy"));
                p.setId(rs.getInt("id"));
                meet.add(p);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return meet;
    }
      
      
       public List<Meeting> selectAllDaily() {
        ArrayList<Meeting> meet = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM meeting WHERE   type='Daily'";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Meeting p = new Meeting();
                p.setTitle(rs.getString("title"));
                p.setGoal(rs.getString("goal"));
                p.setIssues(rs.getString("issues"));
                p.setProject(rs.getInt("project_id"));
                p.setType(rs.getString("type"));
                p.setDate(rs.getString("date"));
                p.setTime(rs.getString("time"));
                p.setDuration(rs.getString("duration"));
                p.setLocation(rs.getString("location"));
                p.setOrganizedBy(rs.getString("organizedBy"));
                p.setId(rs.getInt("id"));
                
                meet.add(p);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return meet;
    }
       public List<Meeting> selectAllReview() {
        ArrayList<Meeting> meet = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM meeting WHERE   type='Review'";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Meeting p = new Meeting();
                p.setTitle(rs.getString("title"));
                p.setGoal(rs.getString("goal"));
                p.setIssues(rs.getString("issues"));
                p.setProject(rs.getInt("project_id"));
                p.setType(rs.getString("type"));
                p.setDate(rs.getString("date"));
                p.setTime(rs.getString("time"));
                p.setDuration(rs.getString("duration"));
                p.setLocation(rs.getString("location"));
                p.setOrganizedBy(rs.getString("organizedBy"));
                p.setId(rs.getInt("id"));
                
                meet.add(p);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return meet;
    }
       public List<Meeting> selectAllRetrospective() {
        ArrayList<Meeting> meet = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM meeting WHERE   type='Retrospective'";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Meeting p = new Meeting();
                p.setTitle(rs.getString("title"));
                p.setGoal(rs.getString("goal"));
                p.setIssues(rs.getString("issues"));
                p.setProject(rs.getInt("project_id"));
                p.setType(rs.getString("type"));
                p.setDate(rs.getString("date"));
                p.setTime(rs.getString("time"));
                p.setDuration(rs.getString("duration"));
                p.setLocation(rs.getString("location"));
                p.setOrganizedBy(rs.getString("organizedBy"));
                p.setId(rs.getInt("id"));
                
                meet.add(p);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return meet;
    }
       public List<Meeting> selectAllSprint() {
        ArrayList<Meeting> meet = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM meeting WHERE   type='Sprint'";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Meeting p = new Meeting();
                p.setTitle(rs.getString("title"));
                p.setGoal(rs.getString("goal"));
                p.setIssues(rs.getString("issues"));
                p.setProject(rs.getInt("project_id"));
                p.setType(rs.getString("type"));
                p.setDate(rs.getString("date"));
                p.setTime(rs.getString("time"));
                p.setDuration(rs.getString("duration"));
                p.setLocation(rs.getString("location"));
                p.setOrganizedBy(rs.getString("organizedBy"));
                p.setId(rs.getInt("id"));
                
                meet.add(p);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return meet;
    }
      public void EditMeeting(Meeting m) {
          try {
            String req = "UPDATE meeting SET title=?,goal=?,issues=?"
                    + ",location=? "
                    + "WHERE id=?";
            PreparedStatement pst=cn2.prepareStatement(req);
            pst.setString(1,m.getTitle());
            pst.setString(2,m.getGoal());
            pst.setString(3,m.getIssues());
            pst.setString(4,m.getLocation());
            pst.setInt(5,m.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
        }   
    
    }



    
    
    public void Delete(Meeting m) {
        
     try {
            String req = "DELETE from meeting where id=? ";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.setInt(1, m.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    }


    public void DeleteAll() {
 
        try {
            String req = "DELETE from meeting ";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void DeleteAllSprint() {
 
        try {
            String req = "DELETE from meeting where type='Sprint'";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void DeleteAllRetrospective() {
 
        try {
            String req = "DELETE from meeting where type='Retrospective'";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void DeleteAllReview() {
 
        try {
            String req = "DELETE from meeting where type='Review'";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void DeleteAllDaily() {
 
        try {
            String req = "DELETE from meeting where type='Daily'";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     public List<String> selectTitle() {
        ArrayList<String> proj = new ArrayList<>();

        try {
            String requet3 = "SELECT title FROM meeting";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Meeting p = new Meeting();
                p.setTitle(rs.getString("title"));
                proj.add(p.getTitle());

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return proj;
    }
     
     
      public Meeting readMeeting(String titlee) throws SQLException {
 Meeting dd=null;
        String requete1 = "select * from meeting where title = ?";

        pre = cn2.prepareStatement(requete1);

        pre.setString(1, titlee);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);

        String title = rs.getString("title");
        String goal = rs.getString("goal");
        String issues = rs.getString("issues");
        String type = rs.getString("type");
        String date = rs.getString("date");
        String time = rs.getString("time");
        String duration = rs.getString("duration");
        String location = rs.getString("location");
        String organizedBy= rs.getString("organizedBy");

        

      


         dd = new Meeting( title, goal, issues,type,date,time,duration,location,organizedBy);
        }
        return dd;
    
      }
}
