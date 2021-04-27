package dtu.pma.GUI.Panels;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.GUI.GUITools;

public class AddProjectPanel extends JPanel {

    JButton addProjectBtn;

    public AddProjectPanel(PMA pma) {

        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
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
        JTextField setStartDateTextField = new JTextField("Set Start Date");
        setStartDateLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setEndDateLabel = new JLabel();
        setEndDateLabel.setText("End Date:");
        JTextField setEndDateTextField = new JTextField("Set End Date");
        setEndDateLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setProjectLeaderLabel = new JLabel();
        setProjectLeaderLabel.setText("Project Leader:");
        JTextField setProjectLeaderTextField = new JTextField("Set Project Leader");
        setProjectLeaderLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setDescriptionLabel = new JLabel();
        setDescriptionLabel.setText("Descripton:");
        JTextArea setDescriptionTextField = new JTextArea("Set Description");
        setDescriptionLabel.setFont(new Font("Serif", Font.BOLD, 20));

        ProjectTree projectTree = new ProjectTree(pma, 300, 780);

        addProjectBtn = new JButton();
        addProjectBtn.setText("ADD PROJECT");

        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.anchor = GridBagConstraints.LINE_START;
        constrain.insets = new Insets(0, 50, 50, 50);
        constrain.weightx = 0.9;
        constrain.weighty = 1;
        constrain.ipady = 30;
        constrain.ipadx = 50;
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
        this.add(setProjectLeaderLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 4;
        this.add(setProjectLeaderTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 5;
        this.add(setDescriptionLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 5;
        constrain.ipady = 70;
        constrain.ipadx = 100;
        this.add(setDescriptionTextField, constrain);

        constrain.anchor = GridBagConstraints.CENTER;
        constrain.gridx = 0;
        constrain.gridy = 6;
        constrain.gridwidth = 2;
        constrain.ipady = 70;
        constrain.ipadx = 200;
        this.add(addProjectBtn, constrain);

        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.gridx = 3;
        constrain.gridy = 0;
        constrain.gridheight = 7;
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.ipady = 780;
        constrain.ipadx = 400;
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
                Project p = new Project(settitleTextField.getText(), Integer.parseInt(setIDTextField.getText()));
                if (setProjectLeaderTextField.getText() != "") {
                    p.setProjectLeader(pma.getWorkerWithID(setProjectLeaderTextField.getText()));
                }
                try {
                    pma.addProject(p);
                    JOptionPane.showMessageDialog(addProjectBtn, "The Project was added");
                    validate();
                    repaint();
                } catch (OperationNotAllowedException e1) {
                    JOptionPane.showMessageDialog(addProjectBtn, e1.getMessage());
                }
            }
        });

    }

}
