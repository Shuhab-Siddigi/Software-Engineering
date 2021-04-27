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
        settitleLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel setIDLabel = new JLabel();
        setIDLabel.setText("ID:");
        JTextField setIDTextField = new JTextField("Set ID :");
        setIDLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel setStartDateLabel = new JLabel();
        setStartDateLabel.setText("Start Date:");
        JTextField setStartDateTextField = new JTextField("Set Start Date");
        setStartDateLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel setEndDateLabel = new JLabel();
        setEndDateLabel.setText("End Date:");
        JTextField setEndDateTextField = new JTextField("Set End Date");
        setEndDateLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel setDescriptionLabel = new JLabel();
        setDescriptionLabel.setText("Descripton:");
        JTextArea setDescriptionTextField = new JTextArea("Set Description");
        setDescriptionLabel.setFont(new Font("Serif", Font.BOLD, 30));

        addProjectBtn = new JButton();
        addProjectBtn.setText("ADD PROJECT");

        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.anchor = GridBagConstraints.LINE_START;
        constrain.insets = new Insets(0, 50, 50, 50);
        constrain.weightx = 0.9;
        constrain.weighty = 0.1;
        constrain.ipady = 30;
        constrain.ipadx = 150;
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
        this.add(setDescriptionLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 4;
        constrain.ipady = 70;
        constrain.ipadx = 100;
        this.add(setDescriptionTextField, constrain);

        constrain.anchor = GridBagConstraints.CENTER;
        constrain.gridx = 0;
        constrain.gridy = 5;
        constrain.gridwidth = 2;
        constrain.ipady = 70;
        constrain.ipadx = 200;
        this.add(addProjectBtn, constrain);

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

        addProjectBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                Project p = new Project(settitleTextField.getText(), Integer.parseInt(setIDTextField.getText()));
                try {
                    pma.addProject(p);
                    JOptionPane.showMessageDialog(addProjectBtn, "The Project was added");
                } catch (OperationNotAllowedException e1) {
                    JOptionPane.showMessageDialog(addProjectBtn, e1.getMessage());
                }
            }
        });

    }

}
