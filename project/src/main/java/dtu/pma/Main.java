package dtu.pma;

import java.awt.*;
public class Main {
  
  public static void main(String[] args) throws OperationNotAllowedException {

    Application application = new Application();
    PMA pma = new PMA();
    pma.addDatabase();
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