/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entite.Meeting;
import Entite.MeetingClaim;
import Entite.Project;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class ClaimPDF {
    
        Connection cn2;
    Statement ste;

    public ClaimPDF() {
                cn2 = DataBase.getInstance().getConnection();

    }
    
    
    
     Document doc = new Document();

    public void listClaims() throws SQLException, FileNotFoundException, DocumentException, IOException {
        ste = cn2.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * from claim_meeting");
        PdfWriter.getInstance(doc, new FileOutputStream("./Claim.pdf"));

        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste Claim:  "));
        doc.add(new Paragraph("   "));

        PdfPTable table = new PdfPTable(11);
        table.setWidthPercentage(100);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase("Id  claim", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

      

        cell = new PdfPCell(new Phrase("Username", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("lastname", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("email", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell); 
        
        cell = new PdfPCell(new Phrase("phone", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        
           cell = new PdfPCell(new Phrase("date", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell); 
        
        cell = new PdfPCell(new Phrase("available", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("other", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("reason", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

     
        cell = new PdfPCell(new Phrase("meeting", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("user", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell); 

        
        
     

        while (rs.next()) {

            MeetingClaim a = new MeetingClaim();
            a.setId(rs.getInt(1));
            a.setName(rs.getString(4));
            a.setUser(rs.getInt(2));
            a.setLastname(rs.getString(6));
            a.setEmail(rs.getString(5));
            a.setTel(rs.getString(7));
            a.setAvailable(rs.getString(8));
            a.setOther(rs.getString(9));
            a.setReason(rs.getString(10));
            a.setDate(rs.getString(11));
            a.setMeeting(rs.getInt(3));

            
            cell = new PdfPCell(new Phrase(String.valueOf(a.getId()), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getName(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getLastname(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
      

            cell = new PdfPCell(new Phrase(a.getEmail(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getTel(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getDate(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getAvailable(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getOther(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getReason(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf(a.getMeeting()), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf(a.getUser()), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

        }

        doc.add(table);
        doc.close();
        Desktop.getDesktop().open(new File("./Claim.pdf"));
    }

    
}
