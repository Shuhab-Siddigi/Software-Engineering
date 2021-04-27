package dtu.pma.GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import dtu.pma.PMA;

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
       // setSize(new Dimension(1000, 800));
        
        showBorder(this);

        TopPanel topPanel = new TopPanel();
        showBorder(topPanel);
        topPanel.setPreferredSize(new Dimension(800, 50));
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 3;
        showBorder(topPanel);
        topPanel.getLeftBtn().setVisible(false);
        topPanel.getRightBtn().setVisible(false);
        this.add(topPanel, constrain);
        guiTool.resetConstrains(constrain);

        LeftPanel leftPanel = new LeftPanel();
        showBorder(leftPanel);
        leftPanel.setPreferredSize(new Dimension(100, 800));
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.gridheight = 1;
        showBorder(leftPanel);
        this.add(leftPanel, constrain);
        guiTool.resetConstrains(constrain);

        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 50));
        constrain.gridx = 0;
        constrain.gridy = 2;
        constrain.gridwidth = 3;
        constrain.fill = GridBagConstraints.VERTICAL;
        this.add(bottomPanel, constrain);


        IntroPanel introPanel = new IntroPanel();
        introPanel.setPreferredSize(new Dimension(700, 800));
        constrain.gridx = 2;
        constrain.gridy = 1;
        showBorder(introPanel);
        this.add(introPanel, constrain);
        guiTool.resetConstrains(constrain);


        // WorkerTable workerTable = new WorkerTable(pma, 200, 800);
        // workerTable.setPreferredSize(new Dimension(200, 800));
        // constrain.gridx = 1;
        // constrain.gridy = 1;
        // showBorder(workerTable);
        // this.add(workerTable, constrain);
        // workerTable.setVisible(false);
        // guiTool.resetConstrains(constrain);

        // ProjectTree projectTree = new ProjectTree(pma, 200, 800);
        // this.setPreferredSize(new Dimension(1000, 800));
        // constrain.gridx = 1;
        // constrain.gridy = 1;
        // showBorder(projectTree);
        // projectTree.setVisible(false);
        // this.add(projectTree, constrain);

        // ChartPanel chartPanel = new ChartPanel(pma);
        // //chartPanel.setPreferredSize(new Dimension(750, 800));
        // constrain.gridx = 2;
        // constrain.gridy = 1;
        // constrain.gridwidth = 3;
        // showBorder(chartPanel);
        // this.add(chartPanel, constrain);


        this.setVisible(true);

        // leftPanel.getForgotBtn().addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         if (leftPanel.getForgotBtn().isSelected()) {
        //             workerTable.setVisible(true);
        //             projectTree.setVisible(false);
        //         } else {
        //             workerTable.setVisible(false);
        //             projectTree.setVisible(true);
        //         }
        //     }
        // });

    }

    // Visual Debuging to show border around panel
    private void showBorder(JPanel panel) {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);
    }

}
