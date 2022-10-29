/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lenovo
 */
public class ProjectPDF {

    Connection cn2;
    Statement ste;

    public ProjectPDF() {

        cn2 = DataBase.getInstance().getConnection();

    }

    Document doc = new Document();

    public void listProjects() throws SQLException, FileNotFoundException, DocumentException, IOException {
        ste = cn2.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * from project");
        PdfWriter.getInstance(doc, new FileOutputStream("./Project.pdf"));

        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste project:  "));
        doc.add(new Paragraph("   "));

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase("Id  Project", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Project name", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("description", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Creation Date", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Creation Time", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell); 
        
        cell = new PdfPCell(new Phrase("deadline", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);

        while (rs.next()) {

            Project a = new Project();
            a.setId(rs.getInt(1));
            a.setTitle(rs.getString(2));
            a.setDescription(rs.getString(3));
            a.setDate_creation(rs.getDate(4));
            a.setTime_creation(rs.getTime(5));
            a.setDeadline(rs.getString(6));

            /*DateFormat df = new SimpleDateFormat("hh:mm:ss");
             String rec = df.format(a.getId());
             String rank = Integer.toString(a.getId());*/
            cell = new PdfPCell(new Phrase(String.valueOf(a.getId()), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getTitle(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getDescription(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
      

            cell = new PdfPCell(new Phrase(a.getDate_creation().toString(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getTime_creation().toString(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(a.getDeadline(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

        }

        doc.add(table);
        doc.close();
        Desktop.getDesktop().open(new File("./Project.pdf"));
    }

}
