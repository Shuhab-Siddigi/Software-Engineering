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
<<<<<<< HEAD
=======


>>>>>>> d3c971d7273373dc5f395b9dfba476efa8c8cf35
    
    frame.setVisible(true);

  }

}
