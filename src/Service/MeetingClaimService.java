/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Meeting;
import Entite.MeetingClaim;
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
public class MeetingClaimService {

    Connection cn2;
    Statement st;
    PreparedStatement pre;

    public MeetingClaimService() {
        cn2 = DataBase.getInstance().getConnection();

    }

    public void insert(MeetingClaim m) {

        try {
            String requet2 = "INSERT INTO claim_meeting (user,meeting,name,mail,lastname,tel,available,other,reason,date)VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cn2.prepareStatement(requet2);
            pst.setInt(1, m.getUser());
            pst.setInt(2, m.getMeeting());
            pst.setString(3, m.getName());
            pst.setString(4, m.getEmail());
            pst.setString(5, m.getLastname());
            pst.setString(6, m.getTel());
            pst.setString(7, m.getAvailable());
            pst.setString(8, m.getOther());
            pst.setString(9, m.getReason());
            pst.setString(10, m.getDate());
            pst.executeUpdate();
            System.out.println("Meeting claim added!!!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

    public List<MeetingClaim> selectAll() {
        ArrayList<MeetingClaim> meet = new ArrayList<>();

        try {
            String requet3 = "SELECT * FROM claim_meeting";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                MeetingClaim p = new MeetingClaim();
                p.setUser(rs.getInt("user"));
                p.setMeeting(rs.getInt("meeting"));
                p.setName(rs.getString("name"));
                p.setLastname(rs.getString("lastname"));
                p.setEmail(rs.getString("mail"));
                p.setTel(rs.getString("tel"));
                p.setAvailable(rs.getString("available"));
                p.setOther(rs.getString("other"));
                p.setReason(rs.getString("reason"));
                p.setDate(rs.getString("date"));
                p.setId(rs.getInt("id"));
                meet.add(p);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return meet;
    }

    public void EditClaim(MeetingClaim m) {
        try {
            String req = "UPDATE claim_meeting SET mail=?,tel=?,"
                    + "other=?"
                    + ",reason=? "
                    + "WHERE id=?";
            PreparedStatement pst = cn2.prepareStatement(req);
            pst.setString(1, m.getEmail());
            pst.setString(2, m.getTel());
            pst.setString(3, m.getOther());
            pst.setString(4, m.getReason());
            pst.setInt(5, m.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingClaimService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Delete(MeetingClaim m) {

        try {
            String req = "DELETE from claim_meeting where id=? ";
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
            String req = "DELETE from claim_meeting ";
            PreparedStatement pst;
            pst = cn2.prepareStatement(req);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MeetingClaim readClaim(int idd) throws SQLException {
        MeetingClaim dd = null;
        String requete1 = "select * from claim_meeting where id = ?";

        pre = cn2.prepareStatement(requete1);

        pre.setInt(1, idd);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            int user = rs.getInt("user");
            int meeting = rs.getInt("meeting");

            String name = rs.getString("name");
            String lastname = rs.getString("lastname");
            String email = rs.getString("mail");
            String phone = rs.getString("tel");
            String available = rs.getString("available");
            String other = rs.getString("other");
            String reason = rs.getString("reason");
            String date = rs.getString("date");

            dd = new MeetingClaim(user, name, lastname, email, phone, meeting, date, available, other, reason);
        }
        return dd;

    }

}
