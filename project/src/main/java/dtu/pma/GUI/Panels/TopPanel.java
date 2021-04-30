package dtu.pma.GUI.Panels;

import java.awt.*;
import javax.swing.*;


public class TopPanel extends JPanel {

    private JButton homeBtn;
    private JButton registerHours;
    private JButton addProjectBtn;
    private JButton addActivityBtn;
    private JButton setIDBtn;
    private JButton showProjectsBtn;
    private JButton showAvailableWorkersBtn;
    private JButton addWorkerToActivity;
    private JButton showProjectActivities;
    private JButton generateReportBtn;
    private JButton setProjectLeaderBtn;

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

    public JButton getAddActivityBtn() {
        return addActivityBtn;
    };

    public JButton getSetIDBtn() {
        return setIDBtn;
    };

    public JButton getShowProjectsBtn() {
        return showProjectsBtn;
    };

    public JButton getShowAvailableWorkersBtn() {
        return showAvailableWorkersBtn;
    };

    public JButton getAddWorkerToActivity() {
        return addWorkerToActivity;
    };

    public JButton getShowProjectActivities() {
        return showProjectActivities;
    };

    public JButton getGenerateReportBtn() {
        return generateReportBtn;
    };

    public JButton getSetProjectLeaderBtn() {
        return setProjectLeaderBtn;
    };

}
