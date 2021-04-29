package dtu.pma.GUI.TreePanels;

import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;
import java.awt.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectTree extends JPanel {

    DefaultMutableTreeNode projetNode = new DefaultMutableTreeNode("Projects");
    DefaultMutableTreeNode titleNode;
    JTree tree;
    PMA pma;

    public ProjectTree(PMA pma, int width, int height) {
        this.pma = pma;
        tree = new JTree(projetNode);

        AddProjectsToTree(pma, projetNode);

        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(width, height - 5));

        this.add(treeView);
    }

    private void AddProjectsToTree(PMA pma, DefaultMutableTreeNode projetNode) {
        for (Project project : pma.getProjects()) {
            setNodeInfo(project);            
        }
    }

    public void AddProjectToTree(Project project) {
        setNodeInfo(project);
    }

    public void updateTree() {
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        model.reload(root);
    }

    public JTree getTree() {
        return tree;
    }

    private void setNodeInfo(Project project){
        titleNode = new DefaultMutableTreeNode(project.getInfo().getTitle());

        titleNode.add( new DefaultMutableTreeNode( " ID: " + Integer.toString(project.getInfo().getID()) ));
        titleNode.add( new DefaultMutableTreeNode( " Start Date: " + (project.getInfo().getStartDate()) ));
        titleNode.add( new DefaultMutableTreeNode( " End Date: " + (project.getInfo().getEndDate()) ));
        titleNode.add( new DefaultMutableTreeNode( " Hours Worked: " + (project.getInfo().getHoursWorked()) ));
        titleNode.add( new DefaultMutableTreeNode( " Expected Hours: " + (project.getInfo().getExpectedHours()) ));
        titleNode.add( new DefaultMutableTreeNode( " Description: " + (project.getInfo().getDescription()) ));
        titleNode.add( new DefaultMutableTreeNode( " Project Leader: " + (project.getProjectLeader()) ));

        projetNode.add(titleNode);
    }

}
