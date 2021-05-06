package dtu.pma.GUI.Panels;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Worker;
import dtu.pma.GUI.TablePanels.RegisterhoursTable;
public class RegisterHoursPanel extends JPanel{

    private Worker worker;
    private Activity activity;
    private int selectedWorkerRow;
    private int selectedActivityRow;
    private String workerID;
    private String activityID;

    private JButton submitHoursBtn;
    
    public RegisterHoursPanel(PMA pma,RegisterhoursTable registerhoursTable){


        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        JLabel projectLabel = new JLabel("Workers");
        projectLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel activitiesLabel = new JLabel("Activities");
        activitiesLabel.setFont(new Font("Serif", Font.BOLD, 20));


        JLabel registerHoursLabel = new JLabel();
        JTextField registersHoursTextField = new JTextField("Register hours");
        registerHoursLabel.setText("Put time in hours");
        registerHoursLabel.setFont(new Font("Serif", Font.BOLD, 20));

        submitHoursBtn = new JButton();
        submitHoursBtn.setText("Submit Hours");

        constrain.fill = GridBagConstraints.VERTICAL;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.weightx = 0.05;
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 2;
        constrain.weighty = 0.04;
        this.add(projectLabel, constrain);

        constrain.gridx = 2;
        constrain.gridy = 0;
        constrain.gridwidth = 2;
        this.add(activitiesLabel, constrain);
        
        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(20, 0, 20, 0);
        constrain.weightx = 0.2;
        constrain.gridx = 0;
        constrain.gridy = 2;
        constrain.gridwidth = 1;
        constrain.weighty = 0.01;
        this.add(registerHoursLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 2;
        constrain.weightx = 1;
        constrain.gridwidth = 2;
        this.add(registersHoursTextField, constrain);

        constrain.gridx = 3;
        constrain.gridy = 2;
        constrain.gridwidth = 1;
        this.add(submitHoursBtn, constrain);

        constrain.fill = GridBagConstraints.CENTER;
        constrain.fill = GridBagConstraints.BOTH;
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.weighty = 0.7;
        constrain.weightx = 1;
        constrain.gridwidth = 4;
        this.add(registerhoursTable, constrain);
       
        registersHoursTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                registersHoursTextField.setText("");
            }
        });
        
        registerhoursTable.getWorkerTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {
                    selectedWorkerRow = rowSelectionModel.getMinSelectionIndex();
                    workerID = registerhoursTable.getWorkerTable().getModel().getValueAt(selectedWorkerRow, 2).toString();
                    worker = pma.getWorkerWithID(workerID);
                    registerhoursTable.setActivityModel(worker);
                }
            }
        });

        registerhoursTable.getActivityTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {
                    selectedActivityRow = rowSelectionModel.getMinSelectionIndex();
                    activityID = registerhoursTable.getActivityTable().getModel().getValueAt(selectedActivityRow, 1).toString();
                    activity = worker.getActivitiyByID(Integer.parseInt(activityID));
                }
            }
        });
        
        submitHoursBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (worker == null || activity == null){
                    JOptionPane.showMessageDialog(submitHoursBtn, "Please select activity and worker");
                   
                }else if (registersHoursTextField.getText().isEmpty() || registersHoursTextField.getText().equals("Register hours") ){
                    JOptionPane.showMessageDialog(submitHoursBtn, "Please input hours worked");
                }else {
                    try {
                        pma.addWorkHours(worker, activity, Integer.parseInt(registersHoursTextField.getText()));
                        
                        //worker.registerHours(Integer.parseInt(registersHoursTextField.getText()), activity);
                        JOptionPane.showMessageDialog(submitHoursBtn, "The hours has been added");
                        System.out.println("Added hours to activity: " + activity.getInfo().getTitle());
                        System.out.println("Worker to add hours: " + worker.getFirstname());
                        registerhoursTable.update(pma);
                        registerhoursTable.setActivityModel(worker);
                    } catch (OperationNotAllowedException e1) {
                        JOptionPane.showMessageDialog(submitHoursBtn, e1.getMessage());
                    }
                }
                
            }
        });

    }
}
