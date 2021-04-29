package dtu.pma.GUI.Panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dtu.pma.PMA;
import dtu.pma.GUI.GUITools;

public class ShowProjectsPanel extends JPanel{

    JButton updateTableBtn;
    public ShowProjectsPanel(PMA pma,ProjectTable projectTable){
        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
        GridBagConstraints constrain = new GridBagConstraints();

       
        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(10, 0, 10, 10);
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 1;
        constrain.gridy = 1;

        this.add(projectTable,constrain);

        updateTableBtn = new JButton();
        updateTableBtn.setText("ADD PROJECT");

        constrain.gridx = 0;
        constrain.gridy = 6;
        constrain.gridwidth = 2;
        constrain.fill = GridBagConstraints.VERTICAL;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.weightx = 0.5;

       // this.add(updateTableBtn,constrain);

        updateTableBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               // projectTable.updateWorkerTable(pma);
            }
        });

        
    }
}
