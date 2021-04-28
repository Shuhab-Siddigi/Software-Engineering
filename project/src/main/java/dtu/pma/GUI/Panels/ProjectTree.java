package dtu.pma.GUI.Panels;

import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectTree extends JPanel {

    DefaultMutableTreeNode projetNode = new DefaultMutableTreeNode("Projects");
    JTree tree;

    public ProjectTree(PMA pma, int width, int height) {

        tree = new JTree(projetNode);

        AddProjectsToTree(pma, projetNode);

        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(width, height - 5));

        this.add(treeView);


    }

    private void AddProjectsToTree(PMA pma, DefaultMutableTreeNode projetNode) {
        for (Project project : pma.getProjects()) {
            projetNode.add(new DefaultMutableTreeNode(
                    "Title: " + project.getInfo().getTitle() + " ID: " + Integer.toString(project.getInfo().getID())));
        }
    }

    public void AddProjectToTree(Project project) {
        projetNode.add(new DefaultMutableTreeNode(
                "Title: " + project.getInfo().getTitle() + " ID: " + Integer.toString(project.getInfo().getID())));
    }
    public JTree getTree(){
        return tree;
    }


}
