package dtu.pma.GUI.Panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import dtu.pma.PMA;
import dtu.pma.GUI.GUITools;
import dtu.pma.GUI.TablePanels.GenerateReportTable;
import dtu.pma.GUI.TablePanels.ProjectTable;
import dtu.pma.GUI.TablePanels.ProjectWithoutProjectLeaderTable;
import dtu.pma.GUI.TreePanels.ProjectTree;

/*
* [T] = Top Panel      [T][T][T][T] 
* [L] = Left Panel     [L][P][C][C] 
* [P] = Project Panel  [L][P][C][C] 
* [C] = Calender Panel
*/
public class MainPanel extends JPanel {

    ProjectTree projectTree;
    ProjectTable projectTable;
    GenerateReportTable generateReportTable;
    ProjectWithoutProjectLeaderTable projectWithoutProjectLeaderTable;

    public MainPanel(PMA pma, Frame frame) {

        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
        GridBagConstraints constrain = new GridBagConstraints();

        projectTree = new ProjectTree(pma, 340, 730);
        projectTable = new ProjectTable(pma, 890, 790);
        // @WIP
        generateReportTable = new GenerateReportTable(pma, 890, 790);
        //@WIP
        projectWithoutProjectLeaderTable = new ProjectWithoutProjectLeaderTable(pma, 890, 690);

        IntroPanel introPanel = new IntroPanel();
        introPanel.setPreferredSize(new Dimension(900, 800));

        AddProjectPanel addProjectPanel = new AddProjectPanel(pma, projectTree, projectTable,projectWithoutProjectLeaderTable);
        addProjectPanel.setPreferredSize(new Dimension(900, 800));

        ShowProjectsPanel showProjectsPanel = new ShowProjectsPanel(pma, projectTable);
        showProjectsPanel.setPreferredSize(new Dimension(900, 800));

        GenerateReportPanel generateReportPanel = new GenerateReportPanel(pma, generateReportTable);
        showProjectsPanel.setPreferredSize(new Dimension(900, 800));

        SetProjectLeader setProjectLeader = new SetProjectLeader(pma,projectWithoutProjectLeaderTable,projectTable,projectTree);
        setProjectLeader.setPreferredSize(new Dimension(900, 800));

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

        JPanel cardLayoutPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardLayoutPanel.setLayout(cardLayout);
        constrain.gridx = 2;
        constrain.gridy = 1;
        guiTool.showBorder(cardLayoutPanel);
        this.add(cardLayoutPanel, constrain);

        cardLayoutPanel.add(introPanel, "intro");
        cardLayoutPanel.add(addProjectPanel, "add-project");
        cardLayoutPanel.add(showProjectsPanel, "show-projects");
        cardLayoutPanel.add(generateReportPanel, "generate-report");
        cardLayoutPanel.add(setProjectLeader, "set-project-leader");

        this.setVisible(true);

        topPanel.getHomeBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "intro");
            }
        });

        topPanel.getAddProjectBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "add-project");
            }
        });

        topPanel.showProjectsBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "show-projects");
            }
        });

        topPanel.generateReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "generate-report");
            }
        });

        topPanel.setProjectLeaderBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "set-project-leader");
            }
        });

    }

}
