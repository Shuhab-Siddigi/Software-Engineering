package dtu.pma.GUI;

import dtu.pma.PMA;
import dtu.pma.Project;

import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectTree extends DefaultMutableTreeNode {
    DefaultMutableTreeNode projectTree;
    PMA pma;
   
    public ProjectTree(PMA pma){
        projectTree =  new DefaultMutableTreeNode("Projects");
        this.pma = pma;
    }


}
