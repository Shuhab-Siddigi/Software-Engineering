package dtu.pma.GUI.Panels;

import java.awt.*;
import javax.swing.*;


public class TopPanel extends JPanel {

    JButton homeBtn;
    JButton registerHours;
    JButton addProjectBtn;
    JButton addActivityBtn;
    JButton setIDBtn;
    JButton showProjectsBtn;
    JButton showAvailableWorkersBtn;
    JButton addWorkerToActivity;
    JButton showProjectActivities;
    JButton generateReportBtn;
    JButton setProjectLeaderBtn;

    public TopPanel() {

        this.setBackground(new Color(58, 62, 69, 255));
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        homeBtn = new JButton();
        homeBtn.setText("Home");
        constrain.fill = GridBagConstraints.HORIZONTAL;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 10, 0, 0);
        constrain.weightx = 0.5;
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(homeBtn, constrain);

        registerHours = new JButton();
        registerHours.setText("Register Hours");
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.gridheight = 1;
        this.add(registerHours, constrain);

        addProjectBtn = new JButton();
        addProjectBtn.setText("Add Project");
        constrain.gridx = 1;
        constrain.gridy = 0;
        constrain.gridheight = 1;
        this.add(addProjectBtn, constrain);

        showProjectsBtn = new JButton();
        showProjectsBtn.setText("Show Projects");
        constrain.gridx = 1;
        constrain.gridy = 1;
        this.add(showProjectsBtn, constrain);

        addActivityBtn = new JButton();
        addActivityBtn.setText("Add/Edit Activity");
        constrain.gridx = 2;
        constrain.gridy = 0;
        this.add(addActivityBtn, constrain);

        addWorkerToActivity = new JButton();
        addWorkerToActivity.setText("Add Worker to Activity");
        constrain.gridx = 2;
        constrain.gridy = 1;
        this.add(addWorkerToActivity, constrain);

        showAvailableWorkersBtn = new JButton();
        showAvailableWorkersBtn.setText("Show Available Workers");
        constrain.gridx = 3;
        constrain.gridy = 0;
        this.add(showAvailableWorkersBtn, constrain);

        showProjectActivities = new JButton();
        showProjectActivities.setText("Show Project Activities");
        constrain.gridx = 3;
        constrain.gridy = 1;
        this.add(showProjectActivities, constrain);

        generateReportBtn = new JButton();
        generateReportBtn.setText("Generate Report");
        constrain.gridx = 4;
        constrain.gridy = 0;
        constrain.insets = new Insets(0, 10, 0, 10);
        this.add(generateReportBtn, constrain);

        setProjectLeaderBtn = new JButton();
        setProjectLeaderBtn.setText("Set Project Leader to project");
        constrain.gridx = 4;
        constrain.gridy = 1;
        this.add(setProjectLeaderBtn, constrain);

    }

    public JButton getHomeBtn() {
        return homeBtn;
    }

    public JButton getAddProjectBtn() {
        return addProjectBtn;
    }

    public JButton addActivityBtn() {
        return addActivityBtn;
    };

    public JButton setIDBtn() {
        return setIDBtn;
    };

    public JButton showProjectsBtn() {
        return showProjectsBtn;
    };

    public JButton showAvailableWorkersBtn() {
        return showAvailableWorkersBtn;
    };

    public JButton addWorkerToActivity() {
        return addWorkerToActivity;
    };

    public JButton showProjectActivities() {
        return showProjectActivities;
    };

    public JButton generateReportBtn() {
        return generateReportBtn;
    };

    public JButton setProjectLeaderBtn() {
        return setProjectLeaderBtn;
    };

}
