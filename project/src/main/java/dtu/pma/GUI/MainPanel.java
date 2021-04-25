package dtu.pma.GUI;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dtu.pma.PMA;

public class MainPanel extends JPanel{

    public MainPanel(PMA pma){

        JButton btn = new JButton("List Workers");
        WorkerTable workerTable = new WorkerTable(pma);

        this.add(new JScrollPane(workerTable));
        this.add(btn);
    }
}
