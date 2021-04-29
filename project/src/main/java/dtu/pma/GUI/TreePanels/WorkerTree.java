package dtu.pma.GUI.TreePanels;

import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;
import java.awt.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class WorkerTree extends JPanel {
    DefaultMutableTreeNode workerNode = new DefaultMutableTreeNode("Workers");
    DefaultMutableTreeNode titleNode;
    JTree tree;
    PMA pma;

    public WorkerTree(PMA pma, int width, int height) {
        this.pma = pma;
        tree = new JTree(workerNode);

        AddWorkersToTree(pma, workerNode);

        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(width, height - 5));

        this.add(treeView);
    }

    private void AddWorkersToTree(PMA pma, DefaultMutableTreeNode workerNode) {

        for (Worker worker : pma.getWorkers()) {

            titleNode = new DefaultMutableTreeNode(worker.getFirstname() + " " + worker.getLastname());

            titleNode.add(new DefaultMutableTreeNode(" ID: " + worker.getID()));
            workerNode.add(titleNode);

        }

    }

    public void AddWorkerToTree(Worker worker) {
        titleNode = new DefaultMutableTreeNode(worker.getFirstname() + " " + worker.getLastname());
        titleNode.add(new DefaultMutableTreeNode(" ID: " + worker.getID()));
        workerNode.add(titleNode);
    }

    public void updateTree() {
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        model.reload(root);
    }

    public JTree getTree() {
        return tree;
    }
}
