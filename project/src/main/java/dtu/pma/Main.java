package dtu.pma;

import java.awt.*;
import java.sql.Date;

public class Main {
  
  public static void main(String[] args) throws OperationNotAllowedException {

    Application application = new Application();
    PMA pma = new PMA();
    pma.addDatabase();
    Project p = new Project("Extreme Programming",0001);

  
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          application.initialize(pma);

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

  }


 

}