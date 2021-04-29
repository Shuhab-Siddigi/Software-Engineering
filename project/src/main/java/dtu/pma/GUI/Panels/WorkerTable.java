package dtu.pma.GUI.Panels;

import dtu.pma.PMA;
import dtu.pma.Worker;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WorkerTable extends JPanel {
   
    DefaultTableModel model = new DefaultTableModel();

    public WorkerTable(PMA pma, int width, int height) {

        JTable workerTable = new JTable();

        workerTable = setTable(pma, workerTable);

        JScrollPane scrollPane = new JScrollPane(workerTable);
        scrollPane.setPreferredSize(new Dimension(width, height - 5));
        this.add(scrollPane);

    }

    private JTable setTable(PMA pma, JTable jTable) {

        model.addColumn("Firstname");
        model.addColumn("Lastname");
        model.addColumn("ID");

        for (Worker w : pma.getWorkers()) {
            model.addRow(new Object[] { w.getFirstname(), w.getLastname(), w.getID() });
        }

        jTable.setModel(model);

        return jTable;
    }



}
