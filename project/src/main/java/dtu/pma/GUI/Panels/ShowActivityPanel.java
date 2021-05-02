package dtu.pma.GUI.Panels;

import javax.swing.JPanel;
import java.awt.*;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.GUI.TablePanels.ShowActivityTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class ShowActivityPanel extends JPanel {


    private Project project;
    private String projectID;
    private int selectedRow;



    public ShowActivityPanel(PMA pma,ShowActivityTable showActivityTable) {

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
       
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.fill = GridBagConstraints.BOTH;
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 1;
        constrain.gridy = 1;

        this.add(showActivityTable, constrain);

        showActivityTable.getProjectTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        showActivityTable.getProjectTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedRow = rowSelectionModel.getMinSelectionIndex();
                    projectID = showActivityTable.getProjectTable().getModel().getValueAt(selectedRow, 1).toString();
                    project = pma.getProjectWithID(Integer.parseInt(projectID));
                    showActivityTable.setModel(project);
                }
            }
        });

    }

}
