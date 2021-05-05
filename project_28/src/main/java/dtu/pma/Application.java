package dtu.pma;

import dtu.pma.GUI.Frame;
import dtu.pma.GUI.Panels.MainPanel;

import java.awt.*;

public class Application {

  public Application() {

  }

  public void initialize(PMA pma) {
    Frame frame = new Frame("Project Management System");
    
    MainPanel mainpanel = new MainPanel(pma,frame);
    frame.getContentPane().add(mainpanel, BorderLayout.CENTER);

   

    frame.setVisible(true);

  }

}
