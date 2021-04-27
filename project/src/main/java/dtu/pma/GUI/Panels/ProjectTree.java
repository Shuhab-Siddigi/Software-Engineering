package dtu.pma.GUI.Panels;

import dtu.pma.PMA;
import dtu.pma.Worker;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectTree extends JPanel {

    public ProjectTree(PMA pma,int width,int height){
        
        DefaultMutableTreeNode projetNode = new DefaultMutableTreeNode("Projects");
    
        JTree tree = new JTree(projetNode);
       
        AddWorkersToTree(pma,projetNode);
        
        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(width, height-5));
        
        this.add(treeView);
    }

    private void AddWorkersToTree(PMA pma,DefaultMutableTreeNode projetNode){
       for (Worker worker : pma.getWorkers()) {
        projetNode.add(new DefaultMutableTreeNode(worker.getFirstname()));
       }
    }

}
