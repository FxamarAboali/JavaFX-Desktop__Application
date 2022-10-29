/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entite.DailyScrum;
import Utils.DataBase;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import Entite.Planning;
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
import java.text.SimpleDateFormat;

/**
 *
 * @author Deku
 */
public class PDFDailyScrum {

    Connection cn2;
    Statement ste;

    public PDFDailyScrum() {
        cn2 = DataBase.getInstance().getConnection();
    }

    Document doc = new Document();

    public void listActivite() throws SQLException, FileNotFoundException, DocumentException, IOException {
        ste = cn2.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * from dailyscrum");
        PdfWriter.getInstance(doc, new FileOutputStream("./dailyscrum.pdf"));

        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste dailyscrum:  "));
        doc.add(new Paragraph("   "));

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase("id_daily", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.WHITE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Title", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.WHITE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Yesterday work", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.WHITE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Today plan", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.WHITE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Blockers", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.WHITE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Hours brunt", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.WHITE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Hours completed", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.WHITE);
        table.addCell(cell);

        while (rs.next()) {

            DailyScrum a = new DailyScrum();
            a.setId_daily(rs.getInt(1));
            a.setTitle(rs.getString(2));
            a.setYesterdaywork(rs.getString(3));
            a.setTodayplan(rs.getString(4));
            a.setBlockers(rs.getString(5));
            a.setHrsbrunt(rs.getInt(6));
            a.setHrscompleted(rs.getInt(7));

            /*DateFormat df = new SimpleDateFormat("hh:mm:ss");
               String rec = df.format(a.getId());
                String rank = Integer.toString(a.getId());*/
            cell = new PdfPCell(new Phrase(String.valueOf(a.getId_daily()), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getTitle(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getYesterdaywork(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getTodayplan(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(a.getBlockers(), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(a.getHrsbrunt()), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(a.getHrscompleted()), FontFactory.getFont("Comic Sans MS", 12)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.WHITE);
            table.addCell(cell);

        }

        doc.add(table);
        doc.close();
        Desktop.getDesktop().open(new File("./dailyscrum.pdf"));
    }
}
