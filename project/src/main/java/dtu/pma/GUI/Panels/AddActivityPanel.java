package dtu.pma.GUI.Panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import dtu.pma.GUI.TablePanels.AddActivityTable;

public class AddActivityPanel extends JPanel {

    private JButton addActivityBtn;
    private Project project;
    private String projectID;
    private int selectedRow;
    private Activity activity;

    public AddActivityPanel(PMA pma, AddActivityTable addActivityTable) {

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        JTextField setProjectTextField = new JTextField("Choose Project ID from table..");
        JLabel setProjectLabel = new JLabel();
        setProjectLabel.setText("Project ID:");
        setProjectLabel.setFont(new Font("Serif", Font.BOLD, 20));

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
        JTextField setStartDateTextField = new JTextField("YYYY-MM-DD");
        setStartDateLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setEndDateLabel = new JLabel();
        setEndDateLabel.setText("End Date:");
        JTextField setEndDateTextField = new JTextField("YYYY-MM-DD");
        setEndDateLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setProjectLeaderLabel = new JLabel();
        setProjectLeaderLabel.setText("Project Leader:");
        JTextField setProjectLeaderTextField = new JTextField("Set Project Leader");
        setProjectLeaderLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel setDescriptionLabel = new JLabel();
        setDescriptionLabel.setText("Descripton:");
        JTextArea setDescriptionTextField = new JTextArea("Set Description");
        setDescriptionLabel.setFont(new Font("Serif", Font.BOLD, 20));
        setDescriptionTextField.setMinimumSize(new Dimension(200, 100));
        setDescriptionTextField.setMaximumSize(new Dimension(200, 200));

        addActivityBtn = new JButton();
        addActivityBtn.setText("ADD ACTIVITY");

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(30, 10, 10, 10);
        constrain.weightx = 0.05;

        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(setProjectLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(setProjectTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 1;
        this.add(settitleLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 1;
        this.add(settitleTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 2;
        this.add(setIDLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 2;
        this.add(setIDTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 3;
        this.add(setStartDateLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 3;
        this.add(setStartDateTextField, constrain);

        constrain.gridx = 0;
        constrain.gridy = 4;
        this.add(setEndDateLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 4;
        this.add(setEndDateTextField, constrain);

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
        constrain.weighty = 0.7;
        this.add(setDescriptionTextField, constrain);

        constrain.weightx = 0.01;
        constrain.gridx = 0;
        constrain.gridy = 7;
        constrain.gridwidth = 2;
        constrain.fill = GridBagConstraints.HORIZONTAL;
        constrain.anchor = GridBagConstraints.CENTER;
        this.add(addActivityBtn, constrain);

        constrain.fill = GridBagConstraints.BOTH;
        constrain.gridx = 2;
        constrain.gridy = 0;
        constrain.weightx = 1;
        constrain.fill = GridBagConstraints.BOTH;
        constrain.gridheight = 8;
        this.add(addActivityTable, constrain);

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
        setProjectLeaderTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setProjectLeaderTextField.setText("");
            }
        });

        setDescriptionTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setDescriptionTextField.setText("");
            }
        });

        addActivityTable.update(pma);

        addActivityTable.getProjectTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addActivityTable.getProjectTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {
                    selectedRow = rowSelectionModel.getMinSelectionIndex();
                    projectID = addActivityTable.getProjectTable().getModel().getValueAt(selectedRow, 1).toString();
                    project = pma.getProjectWithID(Integer.parseInt(projectID));
                    setProjectTextField.setText(Integer.toString(project.getInfo().getID()));
                    addActivityTable.setActivityModel(project);
                    if (project.getInfo().getStartDate() != null) {
                        setStartDateTextField.setText(project.getInfo().getStartDate().toString());
                    }
                }
            }
        });

        addActivityBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                try {
                    String title = settitleTextField.getText();
                    int ID = Integer.parseInt(setIDTextField.getText());
                    Date startDate = Date.valueOf(setStartDateTextField.getText());
                    Date endDate = Date.valueOf(setEndDateTextField.getText());
                    activity = new Activity(title, ID, startDate, endDate);
                    String Description = setDescriptionTextField.getText();
                    activity.getInfo().setDescription(Description);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(addActivityBtn, e1.getMessage());
                }
                try {
                    project.addActivity(activity);
                    addActivityTable.addActivity(activity);
                    JOptionPane.showMessageDialog(addActivityBtn, "Activity Added");
                } catch (OperationNotAllowedException e1) {
                    JOptionPane.showMessageDialog(addActivityBtn, e1.getMessage());
                    e1.printStackTrace();
                }
            }

        });
    }

}
