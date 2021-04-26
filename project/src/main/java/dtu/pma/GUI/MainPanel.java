package dtu.pma.GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import dtu.pma.PMA;

public class MainPanel extends JPanel {
<<<<<<< HEAD

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

=======

    public MainPanel(PMA pma) {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // JButton btn = new JButton("List Workers");

        // c.fill = GridBagConstraints.HORIZONTAL; // adds from left to right?
        // c.gridx = 1;
        // c.gridy = 0;
        // this.add(btn, c);

        // WorkerTable workerTable = new WorkerTable(pma);
        // c.fill = GridBagConstraints.HORIZONTAL;
        // c.weightx = 0; // how much x space for component
        // c.gridx = 0;
        // c.gridy = 0;
        // this.add(new JScrollPane(workerTable), c);

        // JButton btn2 = new JButton("List f");

        // c.fill = GridBagConstraints.HORIZONTAL; // adds from left to right?
        // c.weightx = 0; // how much x space for component
        // c.gridx = 2;
        // c.gridy = 0;
        // this.add(btn2, c);

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.BLACK);
         innerPanel.setBounds(0, 0, 800, 800);
        // innerPanel.setPreferredSize(new Dimension(800, 800));
        // innerPanel.setLayout(new GridBagLayout());

        c.anchor = GridBagConstraints.NORTHWEST;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1; // how much x space for component
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        this.add(innerPanel, c);



        JPanel innerPanel2 = new JPanel();
        innerPanel2.setBackground(Color.RED);
         innerPanel2.setBounds(200, 200, 800, 800);
        // innerPanel.setPreferredSize(new Dimension(800, 800));
        // innerPanel.setLayout(new GridBagLayout());

        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1; // how much x space for component
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.add(innerPanel2, c);


        JPanel innerPanel3 = new JPanel();
        innerPanel3.setBackground(Color.BLUE);
         innerPanel3.setBounds(200, 200, 800, 800);
        // innerPanel.setPreferredSize(new Dimension(800, 800));
        // innerPanel.setLayout(new GridBagLayout());

       // c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1; // how much x space for component
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        this.add(innerPanel3, c);

        JPanel innerPanel4 = new JPanel();
        innerPanel4.setBackground(Color.GREEN);
         innerPanel4.setBounds(200, 200, 800, 800);
        // innerPanel.setPreferredSize(new Dimension(800, 800));
        // innerPanel.setLayout(new GridBagLayout());

        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1; // how much x space for component
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 1;
        this.add(innerPanel4, c);

       
        //

        // this.add(new JScrollPane(workerTable));
        // this.add(btn);
    }

    // JButton button;
    // pane.setLayout(new GridBagLayout());
    // GridBagConstraints c = new GridBagConstraints();
    // if (shouldFill) {
    // //natural height, maximum width
    // c.fill = GridBagConstraints.HORIZONTAL;
    // }

    // button = new JButton("Button 1");
    // if (shouldWeightX) {
    // c.weightx = 0.5;
    // }
    // c.fill = GridBagConstraints.HORIZONTAL;
    // c.gridx = 0;
    // c.gridy = 0;
    // pane.add(button, c);

>>>>>>> d3c971d7273373dc5f395b9dfba476efa8c8cf35
}
