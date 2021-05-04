package dtu.pma.GUI.Panels;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.*;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.GUI.TreePanels.ProjectTree;

public class AddProjectPanel extends JPanel {

    private JButton addProjectBtn;
    private ProjectTree projectTree;

    public AddProjectPanel(PMA pma, ProjectTree projectTree) {

        Date currentDate = new Date(System.currentTimeMillis());

        // Date currentDate = new Date(System.currentTimeMillis());
        this.projectTree = projectTree;
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        JTextField settitleTextField = new JTextField("Set Title:");
        JLabel settitleLabel = new JLabel();
        settitleLabel.setText("Title:");
        settitleLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setIDLabel = new JLabel();
        setIDLabel.setText("ID:");
        JTextField setIDTextField = new JTextField("Set ID :");
        setIDLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setStartDateLabel = new JLabel();
        setStartDateLabel.setText("Start Date:");

        JTextField setStartDateTextField = new JTextField(currentDate.toString());
        setStartDateLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setEndDateLabel = new JLabel();
        setEndDateLabel.setText("End Date:");
        JTextField setEndDateTextField = new JTextField("<Optional>");
        setEndDateLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setExpectedHoursLabel = new JLabel();
        setExpectedHoursLabel.setText("Expected Hours:");
        JTextField setExptectedTextField = new JTextField("<Optional>");
        setExpectedHoursLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setProjectLeaderLabel = new JLabel();
        setProjectLeaderLabel.setText("Project Leader:");
        JTextField setProjectLeaderTextField = new JTextField("<Optional>");
        setProjectLeaderLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setDescriptionLabel = new JLabel();
        setDescriptionLabel.setText("Descripton:");
        JTextArea setDescriptionTextField = new JTextArea("Set Description");
        setDescriptionLabel.setFont(new Font("Serif", Font.BOLD, 20));
        setDescriptionTextField.setMinimumSize(new Dimension(200, 100));
        setDescriptionTextField.setMaximumSize(new Dimension(200, 200));

        addProjectBtn = new JButton();
        addProjectBtn.setText("ADD PROJECT");

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(10, 0, 10, 10);
        constrain.weightx = 0.04;
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(settitleLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(settitleTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 1;
        this.add(setIDLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 1;
        this.add(setIDTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 2;
        this.add(setStartDateLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 2;
        this.add(setStartDateTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 3;
        this.add(setEndDateLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 3;
        this.add(setEndDateTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 4;
        this.add(setExpectedHoursLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 4;
        this.add(setExptectedTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 5;
        this.add(setProjectLeaderLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 5;
        this.add(setProjectLeaderTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 6;
        this.add(setDescriptionLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 6;
        this.add(setDescriptionTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 7;
        constrain.gridwidth = 2;
        constrain.fill = GridBagConstraints.VERTICAL;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.weightx = 0.5;
        this.add(addProjectBtn, constrain);

        constrain.gridx = 2;
        constrain.gridy = 0;
        constrain.weighty = 1;
        constrain.weightx = 1;
        constrain.fill = GridBagConstraints.BOTH;
        constrain.gridheight = 7;
        this.add(projectTree, constrain);

        settitleTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                settitleTextField.setText("");
            }
        });

        setIDTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setIDTextField.setText("");
            }
        });

        setStartDateTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setStartDateTextField.setText("");
            }
        });

        setEndDateTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setEndDateTextField.setText("");
            }
        });

        settitleTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                settitleTextField.setText("");
            }
        });

        setDescriptionTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setDescriptionTextField.setText("");
            }
        });

        setProjectLeaderTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setProjectLeaderTextField.setText("");
            }
        });

        addProjectBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                try {
                    Project p = new Project(settitleTextField.getText(), Integer.parseInt(setIDTextField.getText()));
                    if(p.isAllowedDate(setStartDateTextField.getText())){
                    p.getInfo().setStartDate(Date.valueOf(setStartDateTextField.getText()));
                    }
                    if(p.isAllowedDate(setEndDateTextField.getText())){
                    p.getInfo().setEndDate(Date.valueOf(setEndDateTextField.getText()));
                    }
                    p.getInfo().setDescription(setDescriptionTextField.getText());
                    if (setProjectLeaderTextField.getText() != ""
                            || setProjectLeaderTextField.getText() != "Set Project Leader") {
                        p.setProjectLeader(pma.getWorkerWithID(setProjectLeaderTextField.getText()));
                    }
                    JOptionPane.showMessageDialog(addProjectBtn, "The Project was added");
                    pma.addProject(p);
                    projectTree.AddProjectToTree(p);
                } catch (OperationNotAllowedException e1) {
                    JOptionPane.showMessageDialog(addProjectBtn, e1.getMessage());
                }
            }
        });

    }

    public ProjectTree getProjectTree() {
        return projectTree;
    }

}
