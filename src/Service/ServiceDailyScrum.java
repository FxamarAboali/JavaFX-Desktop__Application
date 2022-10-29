/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.DailyScrum;
import Entite.Document;
import Entite.Planning;
import IService.InterService;
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
public class ServiceDailyScrum {

    private final Connection con;
    private Statement ste;
    PreparedStatement pre;

    public ServiceDailyScrum() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouterDoc(DailyScrum d) throws SQLException {
        String req = "insert into dailyscrum(title,"
                + "yesterdaywork,todayplan,blockers,hrsbrunt,hrscompleted"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(?,"
                + "?,?,?,?,?,"
                + "?,?,?,?)";

        PreparedStatement pre1 = con.prepareStatement(req);
        pre1.setString(1, d.getTitle());

        pre1.setString(2, d.getYesterdaywork());
        pre1.setString(3, d.getTodayplan());
        pre1.setString(4, d.getBlockers());
        pre1.setInt(5, d.getHrsbrunt());
        pre1.setInt(6, d.getHrscompleted());

        pre1.setDate(7, d.getDate_creation());
        pre1.setTime(8, d.getTime_creation());
        pre1.setDate(9, d.getDate_modification());
        pre1.setTime(10, d.getTime_modification());

        pre1.execute();
    }

    public void deleteDaily(DailyScrum t) throws SQLException {

        String cmd = ("DELETE FROM dailyscrum WHERE id_daily = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, t.getId_daily());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteAllDaily() throws SQLException {

        String cmd = ("delete from dailyscrum");
        try {
            pre = con.prepareStatement(cmd);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateDaily(DailyScrum t, String titlex) throws SQLException {

        String upd = "UPDATE dailyscrum SET title = ?, yesterdaywork = ?, todayplan = ?, blockers = ? , hrsbrunt = ? , hrscompleted = ? , date_modification = ?, time_modification = ? WHERE title = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getTitle());

            pre.setString(2, t.getYesterdaywork());
            pre.setString(3, t.getTodayplan());
            pre.setString(4, t.getBlockers());

            pre.setInt(5, t.getHrsbrunt());
            pre.setInt(6, t.getHrscompleted());

            pre.setDate(7, t.getDate_modification());
            pre.setTime(8, t.getTime_modification());

            pre.setString(9, titlex);
            // pre.setInt(10, id_type);

            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<DailyScrum> readAllDaily() throws SQLException {
        List<DailyScrum> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from dailyscrum");
        while (rs.next()) {

            int id_daily = rs.getInt(1);
            String title = rs.getString("title");
            String yesterdaywork = rs.getString("yesterdaywork");
            String todayplan = rs.getString("todayplan");
            String blockers = rs.getString("blockers");

            int hrsbrunt = rs.getInt("hrsbrunt");
            int hrscompleted = rs.getInt("hrscompleted");

            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");

            String createdby = rs.getString("createdby");
            int id_type = rs.getInt("id_type");

            DailyScrum d = new DailyScrum(id_daily, title, yesterdaywork, todayplan, blockers, hrsbrunt, hrscompleted, date_creation, time_creation, date_modification, time_modification, createdby , id_type);

            arr.add(d);
        }
        return arr;
    }

    public DailyScrum readDaily(int id) throws SQLException {

        String requete1 = "select * from dailyscrum where id_daily = ?";

        pre = con.prepareStatement(requete1);

        pre.setInt(1, id);
        ResultSet rs = pre.executeQuery();

        int id_daily = rs.getInt(1);
        String title = rs.getString("title");
        String yesterdaywork = rs.getString("yesterdaywork");
        String todayplan = rs.getString("todayplan");
        String blockers = rs.getString("blockers");

        int hrsbrunt = rs.getInt("hrsbrunt");
        int hrscompleted = rs.getInt("hrscompleted");

        Date date_creation = rs.getDate("date_creation");
        Time time_creation = rs.getTime("time_creation");
        Date date_modification = rs.getDate("date_modification");
        Time time_modification = rs.getTime("time_modification");

        int id_type = rs.getInt("id_type");

        DailyScrum dd = new DailyScrum(id_daily, title, yesterdaywork, todayplan, blockers, hrsbrunt, hrscompleted, date_creation, time_creation, date_modification, time_modification, id_type);

        return dd;
    }

    public DailyScrum readDaily(String titlex) throws SQLException {
        DailyScrum dd = null;
        String requete1 = "select * from dailyscrum where title = ?";
        pre = con.prepareStatement(requete1);

        pre.setString(1, titlex);
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {

            int id_daily = rs.getInt(1);
            String title = rs.getString("title");
            String yesterdaywork = rs.getString("yesterdaywork");
            String todayplan = rs.getString("todayplan");
            String blockers = rs.getString("blockers");

            int hrsbrunt = rs.getInt("hrsbrunt");
            int hrscompleted = rs.getInt("hrscompleted");

            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");

            int id_type = rs.getInt("id_type");

            dd = new DailyScrum(id_daily, title, yesterdaywork, todayplan, blockers, hrsbrunt, hrscompleted, date_creation, time_creation, date_modification, time_modification, id_type);

        }
        return dd;
    }

    public DailyScrum getFileByNom(String nom) {
        DailyScrum d = null;
        try {
            String req = "select * from dailyscrum where title = ? ";
            PreparedStatement psmt = con.prepareStatement(req);
            psmt.setString(1, nom);

            ResultSet res = psmt.executeQuery();
            while (res.next()) {
                d = new DailyScrum(res.getString("title"), res.getString("yesterdaywork"), res.getString("todayplan"), res.getString("blockers"), res.getInt("hrsbrunt"), res.getInt("hrscompleted"));

            }
            return d;
        } catch (SQLException e) {
            return d;
        }

    }

    public boolean isExiste(String nom) throws SQLException {
        ResultSet res = null;
        String req = "select * from dailyscrum where title = ? ";
        PreparedStatement psmt = con.prepareStatement(req);
        psmt.setString(1, nom);

         res = psmt.executeQuery();
        
        
      if (res.next() == false) {
       return false;
      }else {
       return true;
      }

        

    }
    
      public String listActivite(){
        String mail="";
        try {
            String requete2 = "SELECT * FROM dailyscrum";
            PreparedStatement pst = con.prepareStatement(requete2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mail +="\n\n";
                DailyScrum a = new DailyScrum();
                a.setId_daily(rs.getInt(1));
                a.setTitle(rs.getString(2));
                a.setYesterdaywork(rs.getString(3));
                a.setTodayplan(rs.getString(4));
                a.setBlockers(rs.getString(5));
                a.setHrsbrunt(rs.getInt(6));
                a.setHrsbrunt(rs.getInt(7));

                mail +="Daily Scrum Id " + a.getId_daily();
                mail +="\n  Title = " + a.getTitle();
                mail +="\n  Yesterday Work = " + a.getYesterdaywork();
                mail +="\n Today Plan " + a.getTodayplan();
                mail +="\n  Blockers = " + a.getBlockers();
                mail +="\n  Hours Brunt = " + a.getHrsbrunt();
                mail +="\n  Hours Completed = " + a.getHrscompleted();
                

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mail;
    }

}
