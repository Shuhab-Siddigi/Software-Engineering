package dtu.pma.GUI.Panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MenuEvent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.GUI.TablePanels.ProjectTable;
import dtu.pma.GUI.TreePanels.ProjectTree;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import dtu.pma.Worker;
import dtu.pma.GUI.GUITools;
import dtu.pma.GUI.TablePanels.ProjectWithoutProjectLeaderTable;
import dtu.pma.GUI.TablePanels.GenerateReportTable;

public class GenerateReportPanel extends JPanel {
    JTable projectTable;
    Project project;
    int selectedRow;

    public GenerateReportPanel(PMA pma, GenerateReportTable generateReportTable) {

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
        GUITools guiTools = new GUITools();

        JLabel projectLabel = new JLabel();
        projectLabel.setText("Projects");
        projectLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel reportLabel = new JLabel();
        reportLabel.setText("Report");
        reportLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JButton generateReportBtn = new JButton();
        generateReportBtn.setText("GENERATE REPORT");
        generateReportBtn.setFont(new Font("Serif", Font.BOLD, 15));

        JTextArea reportTextArea = new JTextArea();

        constrain.fill = GridBagConstraints.CENTER;
        constrain.weightx = 0.4;
        constrain.weighty = 0.1;
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 2;
        this.add(projectLabel, constrain);

        constrain.gridx = 2;
        constrain.gridy = 0;
        this.add(reportLabel, constrain);

        constrain.fill = GridBagConstraints.BOTH;
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.weighty = 0.95;
        constrain.gridwidth = 1;
        constrain.gridheight = 2;
        this.add(generateReportTable, constrain);

        constrain.gridheight = 1;
        constrain.gridx = 2;
        this.add(reportTextArea, constrain);

        constrain.fill = GridBagConstraints.BOTH;
        constrain.gridx = 2;
        constrain.gridy = 2;
        constrain.weighty = 0.05;
        constrain.gridwidth = 2;
        this.add(generateReportBtn, constrain);


        generateReportTable.getProjectTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        generateReportTable.getProjectTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {
                    selectedRow = rowSelectionModel.getMinSelectionIndex();
                    String ID = generateReportTable.getProjectTable().getModel().getValueAt(selectedRow, 1).toString();
                    project = pma.getProjectWithID(Integer.parseInt(ID));
                    System.out.println(project.gReport());
                    reportTextArea.setText(project.gReport());
                }
            }
        });
      
        generateReportBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                JOptionPane.showMessageDialog(generateReportBtn, "Report Generated");

            }

        });
    }

}
