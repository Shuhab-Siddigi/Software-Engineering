package dtu.pma.GUI.TreePanels;

import dtu.pma.PMA;
import dtu.pma.Project;
import java.awt.*;
import java.util.Enumeration;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectTree extends JPanel {

    DefaultMutableTreeNode projetNode;
    DefaultMutableTreeNode titleNode;
    JTree tree;
    PMA pma;

    public ProjectTree(PMA pma, int width, int height) {
        this.pma = pma;

        projetNode = new DefaultMutableTreeNode("Projects");
        tree = new JTree(projetNode);
        AddProjectsToTree(pma, projetNode);

        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(width, height));
        this.add(treeView);
    }

    private void AddProjectsToTree(PMA pma, DefaultMutableTreeNode projetNode) {
        projetNode = new DefaultMutableTreeNode("Projects");
        for (Project project : pma.getProjects()) {
            setNodeInfo(project);
        }
    }

    public void AddProjectToTree(Project project) {
        setNodeInfo(project);

        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        model.reload(root);
    }

    public void changeNode(Project project) {

        Enumeration<TreeNode> selectedPath = projetNode.children();
        while (selectedPath.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectedPath.nextElement();
            if (node.getChildCount() == 7) {
                if (node.getUserObject().toString().matches(project.getInfo().getTitle())) {
                    node.remove(6);
                    node.add(new DefaultMutableTreeNode(" Project Leader: " + (project.getProjectLeader().getID())));
                }
            }
        }
    }

    private void setNodeInfo(Project project) {
        if (project.getProjectLeader() != null) {
            titleNode = new DefaultMutableTreeNode(project.getInfo().getTitle());
            titleNode.add(new DefaultMutableTreeNode(" ID: " + Integer.toString(project.getInfo().getID())));
            titleNode.add(new DefaultMutableTreeNode(" Start Date: " + (project.getInfo().getStartDate())));
            titleNode.add(new DefaultMutableTreeNode(" End Date: " + (project.getInfo().getEndDate())));
            titleNode.add(new DefaultMutableTreeNode(" Hours Worked: " + (project.getInfo().getHoursWorked())));
            titleNode.add(new DefaultMutableTreeNode(" Expected Hours: " + (project.getInfo().getExpectedHours())));
            titleNode.add(new DefaultMutableTreeNode(" Description: " + (project.getInfo().getDescription())));
            titleNode.add(new DefaultMutableTreeNode(" Project Leader: " + (project.getProjectLeader())));
            projetNode.add(titleNode);
        }else{
            titleNode = new DefaultMutableTreeNode(project.getInfo().getTitle());
            titleNode.add(new DefaultMutableTreeNode(" ID: " + Integer.toString(project.getInfo().getID())));
            titleNode.add(new DefaultMutableTreeNode(" Start Date: " + (project.getInfo().getStartDate())));
            titleNode.add(new DefaultMutableTreeNode(" End Date: " + (project.getInfo().getEndDate())));
            titleNode.add(new DefaultMutableTreeNode(" Hours Worked: " + (project.getInfo().getHoursWorked())));
            titleNode.add(new DefaultMutableTreeNode(" Expected Hours: " + (project.getInfo().getExpectedHours())));
            titleNode.add(new DefaultMutableTreeNode(" Description: " + (project.getInfo().getDescription())));
            titleNode.add(new DefaultMutableTreeNode(" Project Leader: "));
            projetNode.add(titleNode);
        }
    }

    public JTree getTree() {
        return tree;
    }

}
