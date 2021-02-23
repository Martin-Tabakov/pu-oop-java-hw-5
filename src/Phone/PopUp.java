package Phone;

import javax.swing.*;
import java.awt.*;

public class PopUp extends JDialog {


    /**
     * Constructor for the pop up showing if a phone is broken or working
     *
     * @param parent the phone instance
     * @param message  Message of the popUp
     */
    public PopUp(JFrame parent, String message) {
        super(parent, "Phone checked", true);
        this.setSize(new Dimension(200,75));

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);

        panel.add(label);
        getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(parent);
        setVisible(true);
    }
}
