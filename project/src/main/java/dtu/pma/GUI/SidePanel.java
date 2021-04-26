package dtu.pma.GUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.*;

import dtu.pma.PMA;

public class SidePanel extends JPanel{
    
    public SidePanel(PMA pma) {
       
        Dimension size = getPreferredSize();
        size.width = 100;
        size.height = 100;
        setPreferredSize(size);

        GridBagConstraints gc = new GridBagConstraints();

        WorkerTable workerTable = new
        WorkerTable(pma); 
        // Side Panel
        gc.gridx = 0;
        gc.gridy = 0;
        
        this.add(workerTable);
    }
}
