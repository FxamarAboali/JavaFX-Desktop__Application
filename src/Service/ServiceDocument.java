/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Document;
import IService.InterService;
import Utils.DataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deku
 */
public class ServiceDocument implements InterService {

    private final Connection con;
    private Statement ste;
    PreparedStatement pre;

    public ServiceDocument() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouterDoc(Document t) throws SQLException {

        String req = "insert into type(id_type,nom_type) values(NULL,?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        //pre1.setString(1, t.getNom());
        pre1.setString(1, t.getNom_type()); 
        
        pre1.execute();
    }

    @Override
    public void deleteDoc(Document t) throws SQLException {

        String cmd = ("DELETE FROM type WHERE id_type = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, t.getId_type());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    @Override
    public void deleteDocById(int id) throws SQLException {
            String cmd = ("DELETE FROM type WHERE id_type = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, id);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDocByName(String name) throws SQLException {
            String cmd = ("DELETE FROM type WHERE nom_type = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setString(1, name);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
        public void deleteAllDoc() throws SQLException {

        String cmd = ("delete from type");
        try {
            pre = con.prepareStatement(cmd);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateDoc(Document t, int id) throws SQLException {

        String upd = "UPDATE  type SET nom_type = ? WHERE id_type = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getNom_type());
            pre.setInt(2, t.getId_type());

            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   

    @Override
    public List<Document> readAllDoc() throws SQLException {
        List<Document> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from type");
        while (rs.next()) {
            
            int id_type = rs.getInt(1);
            String nom_type = rs.getString("nom_type");

            Document p = new Document(id_type, nom_type);

            arr.add(p);
        }
        return arr;
    }

    @Override
    public int getLastDocId(){
        Document d = null;
        try {
            String req = "select id_type from type order by id_type DESC limit 1";
            PreparedStatement preid = con.prepareStatement(req);
            ResultSet res = preid.executeQuery();
            while (res.next()) {
                
            d = new Document(res.getInt("id_type"));  
            }
            return d.getId_type();
        } catch (SQLException e) {
            return 0;
        }
    
    }
        
    
    @Override
    public Document getDocumentById(int id_type) {
        Document d = null;
        try {
            String req = "select * from type where id_type = ? ";
            PreparedStatement preid = con.prepareStatement(req);
            preid.setInt(1, id_type);

            ResultSet res = preid.executeQuery();
            while (res.next()) {
                d = new Document(res.getInt("id_type"),
                        res.getString("nom_type")
                );
            }
            return d;
        } catch (SQLException e) {
            return d;
        }
    }

    @Override
    public Document getDocumentByNom(String nom_type) {
        Document d = null;
        try {
            String req = "select * from type where nom_type = ? ";
            PreparedStatement psmt = con.prepareStatement(req);
            psmt.setString(1, nom_type);

            ResultSet res = psmt.executeQuery();
            while (res.next()) {
                d = new Document(res.getInt("id_type"),
                        res.getString("nom_type")
                );
            }
            return d;
        } catch (SQLException e) {
            return d;
        }
    }











}
