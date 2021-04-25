package dtu.pma.GUI;

import dtu.pma.PMA;
import dtu.pma.Worker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class WorkerTable extends JTable {
    private PMA pma;

    public WorkerTable(PMA pma) {
        this.pma = pma;
        this.setSize(100, 800);
        setTable();
    }

    private void setTable() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Firstname");
        model.addColumn("Lastname");
        model.addColumn("ID");

        for (Worker w : pma.getWorkers()) {
            model.addRow(
                new Object[] {   
                    w.getFirstname(), 
                    w.getLastname(), 
                    w.getID() 
                }
            );
        }

        this.setModel(model);
    }

}
