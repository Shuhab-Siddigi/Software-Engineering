package dtu.pma.GUI;

import javax.swing.JPanel;
import dtu.pma.PMA;
import java.awt.*;
import java.text.DateFormatSymbols;

public class ChartPanel extends JPanel {

    public ChartPanel(PMA pma) {

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
        DateFormatSymbols dateFormatSymbolsobject = new DateFormatSymbols();
        String[] months = dateFormatSymbolsobject.getMonths();

        /*
        for (String m : months) {
            constrain.insets = new Insets(0, 3, 0, 0); // Padding
            JLabel monthLabel = new JLabel(m);
            this.add(monthLabel,constrain);
        }
       */
    }

}
