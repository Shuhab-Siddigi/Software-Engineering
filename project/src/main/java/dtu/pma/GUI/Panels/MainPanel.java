package dtu.pma.GUI.Panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import dtu.pma.PMA;
import dtu.pma.GUI.GUITools;
import dtu.pma.GUI.TablePanels.AddActivityTable;

import dtu.pma.GUI.TablePanels.GenerateReportTable;
import dtu.pma.GUI.TablePanels.RegisterhoursTable;
import dtu.pma.GUI.TablePanels.SetProjectLeaderTable;
import dtu.pma.GUI.TablePanels.ShowProjectActivitysTable;
import dtu.pma.GUI.TablePanels.ShowAvailableWorkersTable;
import dtu.pma.GUI.TablePanels.ShowProjectsTable;
import dtu.pma.GUI.TreePanels.ProjectTree;

/*
* [T] = Top Panel      [T][T][T][T] 
* [L] = Left Panel     [L][P][C][C] 
* [P] = Project Panel  [L][P][C][C] 
* [C] = Calender Panel
*/
public class MainPanel extends JPanel {

    private ProjectTree projectTree;
    private ShowProjectsTable showProjectsTable;
    private GenerateReportTable generateReportTable;
    private SetProjectLeaderTable setProjectLeaderTable;
    private AddActivityTable addActivityTable;
    private ShowProjectActivitysTable showProjectActivitysTable;
    private ShowAvailableWorkersTable showAvailableWorkersTable;
    private RegisterhoursTable registerhoursTable;


    private IntroPanel introPanel;
    private GenerateReportPanel generateReportPanel;
    private AddProjectPanel addProjectPanel;
    private ShowProjectsPanel showProjectsPanel;
    private SetProjectLeader setProjectLeader;
    private AddActivityPanel addActivityPanel;
    private ShowProjectActivitysPanel showProjectActivitysPanel;
    private ShowAvailableWorkersPanel showAvailableWorkersPanel;
    private RegisterHoursPanel registerHoursPanel;

    public MainPanel(PMA pma, Frame frame) {
 

        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
        GridBagConstraints constrain = new GridBagConstraints();

        projectTree = new ProjectTree(pma, 340, 730);
        showProjectsTable = new ShowProjectsTable(pma, 890, 790);
        generateReportTable = new GenerateReportTable(pma, 890, 790);
        setProjectLeaderTable = new SetProjectLeaderTable(pma, 890, 690);
        addActivityTable = new AddActivityTable(pma, 890, 690);
        showProjectActivitysTable = new ShowProjectActivitysTable(pma,890,790);
        showAvailableWorkersTable = new ShowAvailableWorkersTable(pma, 890, 790);
        registerhoursTable = new RegisterhoursTable(pma,890,790);

        introPanel = new IntroPanel();
        addProjectPanel = new AddProjectPanel(pma, projectTree);
        showProjectsPanel = new ShowProjectsPanel(pma, showProjectsTable);
        setProjectLeader = new SetProjectLeader(pma, setProjectLeaderTable);
        generateReportPanel = new GenerateReportPanel(pma, generateReportTable);
        addActivityPanel = new AddActivityPanel(pma, addActivityTable);
        showProjectActivitysPanel = new ShowProjectActivitysPanel(pma,showProjectActivitysTable);
        showAvailableWorkersPanel = new ShowAvailableWorkersPanel(pma, showAvailableWorkersTable);
        registerHoursPanel = new RegisterHoursPanel(pma,registerhoursTable);

        showProjectsPanel.setPreferredSize(new Dimension(900, 800));
        introPanel.setPreferredSize(new Dimension(900, 800));
        addProjectPanel.setPreferredSize(new Dimension(900, 800));
        showProjectsPanel.setPreferredSize(new Dimension(900, 800));
        setProjectLeader.setPreferredSize(new Dimension(900, 800));
        addActivityPanel.setPreferredSize(new Dimension(900, 800));
        showProjectActivitysPanel.setPreferredSize(new Dimension(900, 800));
        showAvailableWorkersPanel.setPreferredSize(new Dimension(900, 800));
        registerHoursPanel.setPreferredSize(new Dimension(900, 800));
            

        TopPanel topPanel = new TopPanel();
        topPanel.setPreferredSize(new Dimension(1003, 50));
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
        bottomPanel.setPreferredSize(new Dimension(1003, 50));
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
        cardLayoutPanel.add(addActivityPanel, "add-activity");
        cardLayoutPanel.add(showProjectActivitysPanel, "show-activity");
        cardLayoutPanel.add(showAvailableWorkersPanel, "show-available-workers");
        cardLayoutPanel.add(registerHoursPanel, "register-hours");
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

        topPanel.getShowProjectsBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "show-projects");
                showProjectsTable.update(pma);
            }
        });

        topPanel.getGenerateReportBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "generate-report");
                generateReportTable.update(pma);
            }
        });

        topPanel.getSetProjectLeaderBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "set-project-leader");
                setProjectLeaderTable.update(pma);
            }
        });

        topPanel.getAddWorkerToActivity().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "add-worker-to-activity");
                
            }
        });
        
        topPanel.getAddActivityBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "add-activity");
              addActivityTable.update(pma);
            }
        });

        topPanel.getShowProjectActivities().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "show-activity");
                showProjectActivitysTable.update(pma);
            }
        });

        topPanel.getShowAvailableWorkersBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "show-available-workers");
                showAvailableWorkersTable.update(pma);
            }
        });

        topPanel.getRegisterHoursBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutPanel, "register-hours");
                registerhoursTable.update(pma);
            }
        });

       
    }

}
