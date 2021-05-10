package dtu.pma.GUI.Panels;

import java.awt.*;
import javax.swing.*;


public class TopPanel extends JPanel {

    private JButton homeBtn;
    private JButton registerHoursBtn;
    private JButton addProjectBtn;
    private JButton addActivityBtn;
    private JButton setIDBtn;
    private JButton showProjectsBtn;
    private JButton setWorkerToActivityBtn;
    private JButton showProjectActivitiesBtn;
    private JButton generateReportBtn;
    private JButton setProjectLeaderBtn;

    public TopPanel() {

        this.setBackground(new Color(58, 62, 69, 255));
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        homeBtn = new JButton();
        registerHoursBtn = new JButton();
        addProjectBtn = new JButton();
        showProjectsBtn = new JButton();
        addActivityBtn = new JButton();
        showProjectActivitiesBtn = new JButton();
        setWorkerToActivityBtn = new JButton();
        setProjectLeaderBtn = new JButton();
        generateReportBtn = new JButton();
        
        homeBtn.setText("Home");
        registerHoursBtn.setText("Register Hours");

        addProjectBtn.setText("1. Add Project");
        showProjectsBtn.setText("Show Projects");
        
        addActivityBtn.setText("2. Add Activity");
        showProjectActivitiesBtn.setText("Project / Activities / Worker");
        
        setProjectLeaderBtn.setText("3. Set Project Leader");
       

        setWorkerToActivityBtn.setText("4. Add Worker to Activity");
        generateReportBtn.setText("5. Generate Report");
        

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.weightx = 0.5;
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridheight = 2;
        this.add(homeBtn, constrain);

        constrain.gridx = 1;
        constrain.gridy = 0;
        constrain.gridheight = 1;
        this.add(addProjectBtn, constrain);

        constrain.gridx = 1;
        constrain.gridy = 1;
        this.add(showProjectsBtn, constrain);

        constrain.gridx = 2;
        constrain.gridy = 0;
        this.add(addActivityBtn, constrain);

        constrain.gridx = 2;
        constrain.gridy = 1;
        this.add(showProjectActivitiesBtn, constrain);

        constrain.gridx = 3;
        constrain.gridy = 0;
        this.add(setProjectLeaderBtn, constrain);

        constrain.gridx = 3;
        constrain.gridy = 1;
        this.add(registerHoursBtn, constrain);

        constrain.gridx = 4;
        constrain.gridy = 0;
        this.add(setWorkerToActivityBtn, constrain);

        constrain.gridx = 4;
        constrain.gridy = 1;
        this.add(generateReportBtn, constrain);

   
    }

    public JButton getHomeBtn() {
        return homeBtn;
    }

    public JButton getAddProjectBtn() {
        return addProjectBtn;
    }

    public JButton getAddActivityBtn() {
        return addActivityBtn;
    };

    public JButton getSetIDBtn() {
        return setIDBtn;
    };

    public JButton getShowProjectsBtn() {
        return showProjectsBtn;
    };


    public JButton getSetWorkerToActivityBtn() {
        return setWorkerToActivityBtn;
    };

    public JButton getShowProjectActivities() {
        return showProjectActivitiesBtn;
    };

    public JButton getGenerateReportBtn() {
        return generateReportBtn;
    };

    public JButton getSetProjectLeaderBtn() {
        return setProjectLeaderBtn;
    };


    public JButton getRegisterHoursBtn() {
        return registerHoursBtn;
    };

}
