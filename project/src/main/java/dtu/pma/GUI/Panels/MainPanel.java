package dtu.pma.GUI.Panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import dtu.pma.PMA;
import dtu.pma.GUI.GUITools;

/*
* [T] = Top Panel      [T][T][T][T] 
* [L] = Left Panel     [L][P][C][C] 
* [P] = Project Panel  [L][P][C][C] 
* [C] = Calender Panel
*/
public class MainPanel extends JPanel {

    public MainPanel(PMA pma) {

        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
        GridBagConstraints constrain = new GridBagConstraints();

        guiTool.showBorder(this);

        TopPanel topPanel = new TopPanel();
        topPanel.setPreferredSize(new Dimension(1000, 50));
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 3;
        this.add(topPanel, constrain);
        guiTool.resetConstrains(constrain);

        LeftPanel leftPanel = new LeftPanel();
        leftPanel.setPreferredSize(new Dimension(100, 800));
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.gridheight = 1;
        this.add(leftPanel, constrain);
        guiTool.resetConstrains(constrain);

        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.setPreferredSize(new Dimension(1000, 50));
        constrain.gridx = 0;
        constrain.gridy = 2;
        constrain.gridwidth = 3;
        constrain.fill = GridBagConstraints.VERTICAL;
        this.add(bottomPanel, constrain);

        IntroPanel introPanel = new IntroPanel();
        introPanel.setPreferredSize(new Dimension(900, 800));
        guiTool.showBorder(introPanel);
        constrain.gridx = 2;
        constrain.gridy = 1;

        this.add(introPanel, constrain);
        guiTool.resetConstrains(constrain);

        AddProjectPanel addProjectPanel = new AddProjectPanel(pma);
        addProjectPanel.setPreferredSize(new Dimension(900, 800));
        guiTool.showBorder(addProjectPanel);
        constrain.gridx = 2;
        constrain.gridy = 1;
        addProjectPanel.setVisible(false);
        this.add(addProjectPanel, constrain);
        guiTool.resetConstrains(constrain);

        // WorkerTable workerTable = new WorkerTable(pma, 200, 800);
        // workerTable.setPreferredSize(new Dimension(200, 800));
        // constrain.gridx = 1;
        // constrain.gridy = 1;
        // this.add(workerTable, constrain);
        // workerTable.setVisible(false);
        // guiTool.resetConstrains(constrain);

        // ProjectTree projectTree = new ProjectTree(pma, 200, 800);
        // this.setPreferredSize(new Dimension(1000, 800));
        // constrain.gridx = 1;
        // constrain.gridy = 1;
        // showBorder(projectTree);
        // //projectTree.setVisible(false);
        // this.add(projectTree, constrain);

        // ChartPanel chartPanel = new ChartPanel(pma);
        // //chartPanel.setPreferredSize(new Dimension(750, 800));
        // constrain.gridx = 2;
        // constrain.gridy = 1;
        // constrain.gridwidth = 3;
        // showBorder(chartPanel);
        // this.add(chartPanel, constrain);

        this.setVisible(true);
        
        topPanel.getHomeBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                introPanel.setVisible(true);
                addProjectPanel.setVisible(false);
            }
        });

        topPanel.getAddProjectBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                introPanel.setVisible(false);
                addProjectPanel.setVisible(true);
            }
        });

    

    }

}
