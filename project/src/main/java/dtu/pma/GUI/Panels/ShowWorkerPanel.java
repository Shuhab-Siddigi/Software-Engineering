package dtu.pma.GUI.Panels;

import javax.swing.JPanel;
import java.awt.*;
import dtu.pma.PMA;
import dtu.pma.GUI.TablePanels.WorkerTable;

public class ShowWorkerPanel extends JPanel{

    public ShowWorkerPanel(PMA pma,WorkerTable workerTable){
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

       
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 0;
        constrain.gridy = 0;

        this.add(workerTable,constrain);
        
    }
}
