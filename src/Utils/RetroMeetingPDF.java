/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entite.Meeting;
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
public class RetroMeetingPDF {
    
        Connection cn2;
    Statement ste;

    public RetroMeetingPDF() {
                cn2 = DataBase.getInstance().getConnection();

    }
    
    
    
     Document doc = new Document();

    public void listMeetings() throws SQLException, FileNotFoundException, DocumentException, IOException {
        ste = cn2.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * from meeting where type='Retrospective'");
        PdfWriter.getInstance(doc, new FileOutputStream("./Meeting.pdf"));

        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste Meeting:  "));
        doc.add(new Paragraph("   "));

        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase("Id  Meeting", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

      

        cell = new PdfPCell(new Phrase("title", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("goal", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("issues", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell); 
        
        cell = new PdfPCell(new Phrase("type", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Date", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Time", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Duration", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Location", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell); 

        
        
     

        while (rs.next()) {

            Meeting a = new Meeting();
            a.setId(rs.getInt(1));
            a.setTitle(rs.getString(5));
            a.setGoal(rs.getString(6));
            a.setIssues(rs.getString(7));
            a.setType(rs.getString(8));
            a.setDate(rs.getString(3));
            a.setTime(rs.getString(4));
            a.setDuration(rs.getString(9));
            a.setLocation(rs.getString(10));

            
            cell = new PdfPCell(new Phrase(String.valueOf(a.getId()), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getTitle(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getGoal(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
      

            cell = new PdfPCell(new Phrase(a.getIssues(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getType(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getDate(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getTime(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getDuration(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getLocation(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

        }

        doc.add(table);
        doc.close();
        Desktop.getDesktop().open(new File("./Meeting.pdf"));
    }

    
}
