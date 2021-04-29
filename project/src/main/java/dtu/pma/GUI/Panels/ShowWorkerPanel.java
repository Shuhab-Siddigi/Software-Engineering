package dtu.pma.GUI.Panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dtu.pma.PMA;
import dtu.pma.GUI.GUITools;
import dtu.pma.GUI.Tables.WorkerTable;

public class ShowWorkerPanel extends JPanel{

    public ShowWorkerPanel(PMA pma,WorkerTable workerTable){
        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
        GridBagConstraints constrain = new GridBagConstraints();

       
        //constrain.fill = GridBagConstraints.BOTH;
        ///constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 1;
        constrain.gridy = 1;

        this.add(workerTable,constrain);
        
    }
}
