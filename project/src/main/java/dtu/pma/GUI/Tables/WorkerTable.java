package dtu.pma.GUI.Tables;

import dtu.pma.PMA;
import dtu.pma.Worker;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class WorkerTable extends JPanel {

    DefaultTableModel model = new DefaultTableModel();

    public WorkerTable(PMA pma, int width, int height) {

        JTable workerTable = new JTable();

        workerTable = setTable(pma, workerTable);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        workerTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(workerTable);
        scrollPane.setPreferredSize(new Dimension(width, height));
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

    public void addWorker(Worker w) {

        model.addRow(new Object[] { w.getFirstname(), w.getLastname(), w.getID() });

    }

}
