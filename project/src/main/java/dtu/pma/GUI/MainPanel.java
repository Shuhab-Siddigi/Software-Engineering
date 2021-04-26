package dtu.pma.GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import dtu.pma.PMA;

public class MainPanel extends JPanel {

    private PMA pma;

    public MainPanel(PMA pma) {

        this.setSize(300, 300);
        String workingDir = System.getProperty("user.dir");
        ImageIcon icon = new ImageIcon(
                new ImageIcon(workingDir + "/src/background.jpg").getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH));
        System.out.println(workingDir + "/src/background.jpg");
        JLabel label = new JLabel(icon);
        this.add(label);

        
     

        /*
         * CardLayout layout = new CardLayout(); layout.setHgap(10); layout.setVgap(10);
         * this.setLayout(layout); // this.setBackground(Color.BLACK);
         * 
         * // WorkerTable workerTable = new WorkerTable(pma); // this.add(new
         * JScrollPane(workerTable));
         * 
         * // this.add(new IntroPanel());
         * 
         * this.add(btn);
         */

    }

}
