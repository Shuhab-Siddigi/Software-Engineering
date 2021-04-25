package dtu.pma.GUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dtu.pma.PMA;

public class Window {
    
    public Window(){
        
    }

    public void initialize(PMA pma){
        
        JPanel panel = new JPanel();
        JButton btn = new JButton("List Workers");
        pma.addDatabase();


        Frame frame = new Frame("Project Management System");
        frame.setVisible(true);
        WorkerTable workerTable = new WorkerTable(pma);
      
        panel.add(new JScrollPane(workerTable));
       
    
        panel.add(btn);
    
        btn.setVisible(true);
        frame.add(panel);
      }
}
