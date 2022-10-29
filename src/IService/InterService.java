/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Document;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Deku
 */
public interface InterService {
    public List<Document> readAllDoc() throws SQLException;
    public void ajouterDoc(Document t) throws SQLException;
    
    public void deleteDoc(Document t) throws SQLException;
    public void deleteDocById(int id) throws SQLException;
    public void deleteDocByName(String name) throws SQLException;
    public void deleteAllDoc() throws SQLException;
    
    public void updateDoc(Document t, int id) throws SQLException;


    
    //searshing by all attrib
    public int getLastDocId();
    public Document getDocumentById(int id);
    public Document getDocumentByNom(String nom); 

}
