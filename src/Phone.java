import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Phone extends JFrame implements MouseListener {
    final private int screenSize = 10;
    final private String serial;
    private Pixel[][] screen;
    private final int topOffset = 100;
    private final int rightOffset = 10;
    private final int leftOffset = 10;
    private final int bottomOffset = 10;

    public Phone() {
        this.screen = new Pixel[screenSize][screenSize];
        serial = setSerial();
        setScreen();
        this.setSize(screenSize * Pixel.size + leftOffset + rightOffset, screenSize * Pixel.size + topOffset + bottomOffset);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(this);
        this.setVisible(true);
    }

    private String setSerial() {
        Random random = new Random();
        char[] serial = new char[10];
        for (int i = 0; i < 10; i++) {
            serial[i] = (random.nextInt(2) == 0) ? (char) (random.nextInt(9) + '0') : (char) ((random.nextInt(25) + 'a'));
        }
        return new String(serial);
    }

    private void setScreen() {
        for (int i = 0; i < screenSize; i++) {
            for (int j = 0; j < screenSize; j++) {
                screen[i][j] = new Pixel();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, screenSize * Pixel.size, screenSize * Pixel.size);
        for (int i = 0; i < screenSize; i++) {
            for (int j = 0; j < screenSize; j++) {
                g.setColor(screen[i][j].getColor());
                g.fillRect(i * Pixel.size + leftOffset, j * Pixel.size + topOffset, Pixel.size, Pixel.size);
            }
        }
        g.setFont(g.getFont().deriveFont(20f));
        g.setColor(new Color(0, 0, 0));
        g.drawString(serial, screenSize * Pixel.size / 3, topOffset / 2);
    }


    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        int x = (e.getX() - leftOffset) / Pixel.size;
        int y = (e.getY() - topOffset) / Pixel.size;
        if (x < 0 || x >= screenSize || y < 0 || y >= screenSize) return;
            screen[x][y].click();
        repaint();
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
