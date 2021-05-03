package dtu.pma.GUI.Panels;

import javax.swing.JPanel;
import java.awt.*;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.GUI.TablePanels.ShowProjectActivitysTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class ShowProjectActivitysPanel extends JPanel {


    private Project project;
    private String projectID;
    private int selectedRow;



    public ShowProjectActivitysPanel(PMA pma,ShowProjectActivitysTable showProjectActivitysTable) {

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
       
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.fill = GridBagConstraints.BOTH;
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 1;
        constrain.gridy = 1;

        this.add(showProjectActivitysTable, constrain);

        showProjectActivitysTable.getProjectTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        showProjectActivitysTable.getProjectTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedRow = rowSelectionModel.getMinSelectionIndex();
                    projectID = showProjectActivitysTable.getProjectTable().getModel().getValueAt(selectedRow, 1).toString();
                    project = pma.getProjectWithID(Integer.parseInt(projectID));
                    showProjectActivitysTable.setModel(project);
                }
            }
        });

    }

}
