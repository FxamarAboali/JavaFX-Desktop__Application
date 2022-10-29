/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.DailyScrum;
import Entite.Planning;
import Entite.SprintRetrospective;
import Service.ServiceDailyScrum;
import Service.ServicePlanning;
import Service.ServiceSprintRetro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deku
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        SprintRetrospective p = new SprintRetrospective("qsdfd", "dfsdfsdfs", "dfsdfsdf", "sdfsdfs");
        ServiceSprintRetro ser = new ServiceSprintRetro();
        
       /* try {
            ser.ajouterDoc(d);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
        
       ser.ajouterRetro(p);
    }
    
   
    
}
