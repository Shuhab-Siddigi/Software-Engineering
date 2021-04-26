package dtu.pma.GUI;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dtu.pma.PMA;

public class Window {

  public Window() {

  }

  public void initialize(PMA pma) {
    Frame frame = new Frame("Project Management System");
    MainPanel mainpanel = new MainPanel(pma);
   
    frame.add(mainpanel);
    
    frame.setVisible(true);
  }
}
