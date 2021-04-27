package dtu.pma.GUI;

import dtu.pma.PMA;
import java.awt.*;

public class Application {

  public Application() {

  }

  public void initialize(PMA pma) {
    Frame frame = new Frame("Project Management System");
    
    MainPanel mainpanel = new MainPanel(pma);
    frame.getContentPane().add(mainpanel, BorderLayout.CENTER);

    //frame.add(mainpanel);

    frame.setVisible(true);

  }

}
