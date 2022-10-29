package Utils;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class TrayIconDemo {
    
    
 public void EditClaimTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "There is a change in the Meeting Claim", MessageType.INFO);
    }
 public void AddClaimTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "There is a new Meeting Claim", MessageType.INFO);
    }
 public void DeleteClaimTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "Meeting Claim was deleted", MessageType.INFO);
    }
 public void DeleteAllClaimTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "All Meetings Claim was deleted", MessageType.INFO);
    }
    
     public void DeleteProjectTray(String title) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", title+" Project was deleted", MessageType.INFO);
    }
     
      public void DeleteAllProjectsTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "All Projects was deleted", MessageType.INFO);
    }
      
      public void DeleteMeetingTray(String title) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", title+ " Meeting was deleted", MessageType.INFO);
    }
      public void DeleteAllMeetingsTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "All Meetings was deleted", MessageType.INFO);
    }
      public void EditMeetingTray(String title) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "There is a change in "+title+" Meeting", MessageType.INFO);
    }
      
      public void AddProjectTray(String title) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "There is a new Project titled "+title, MessageType.INFO);
    }
      public void EditProjectTray(String title) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "There is a change in  "+title+" Project", MessageType.INFO);
    }


    public void NewMeetingTray(String title) throws AWTException {
  SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "There is a change in  "+title+" Project", MessageType.INFO);    }

   public void AddMeetingTray(String title) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("");

        TrayIcon trayIcon = new TrayIcon(image, "Tray ajout");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray ajout");
        tray.add(trayIcon);

        trayIcon.displayMessage("Admin", "There is a new Meeting titled "+title, MessageType.INFO);
    }
}