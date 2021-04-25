package dtu.pma;

import dtu.pma.GUI.Window;


import java.awt.*;


public class Main {
  
  public static void main(String[] args) {

    Window window = new Window();
    PMA pma = new PMA();
    pma.addDatabase();

    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          window.initialize(pma);

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

  }


 

}