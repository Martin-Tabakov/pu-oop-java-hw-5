package Phone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Phone extends JFrame implements MouseListener, WindowListener {
    private boolean isClosed = false;
    final private int screenSize = 64;
    private int workingPixels = 0;
    private final String serial;
    private Pixel[][] screen;
    private final int topOffset = 100;
    private final int rightOffset = 10;
    private final int leftOffset = 10;
    private final int bottomOffset = 10;

    /**
     * Constructor for a phone instance
     */
    public Phone() {
        this.screen = new Pixel[screenSize][screenSize];
        serial = setSerial();
        setScreen();
        this.setSize(screenSize * Pixel.size + leftOffset + rightOffset, screenSize * Pixel.size + topOffset + bottomOffset);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addMouseListener(this);
        this.addWindowListener(this);
        this.setVisible(false);
    }

    /**
     * Checks whether the phone window has been closed
     * @return true if closed, otherwise false
     */
    public boolean isPhoneClosed() {
        return isClosed;
    }

    /**
     * Checks whether a phone is broken
     * @return true if broken, otherwise false
     */
    public boolean isPhoneBroken() {
        return (screenSize * screenSize) / 2 > workingPixels;
    }

    /**
     * Changes the visibility of the phone to visible
     */
    public void showPhone() {
        this.setVisible(true);
    }

    /**
     * Sets the serial number of the phone
     * @return The random serial number as a String
     */
    private String setSerial() {
        Random random = new Random();
        char[] serial = new char[10];
        for (int i = 0; i < 10; i++) {
            serial[i] = (random.nextInt(2) == 0) ? (char) (random.nextInt(9) + '0') : (char) ((random.nextInt(25) + 'a'));
        }
        return new String(serial);
    }

    /**
     * Creates and initializes the pixels on the screen
     */
    private void setScreen() {
        for (int i = 0; i < screenSize; i++) {
            for (int j = 0; j < screenSize; j++) {
                screen[i][j] = new Pixel();
                workingPixels += (screen[i][j].getPixelState() == PixelState.healthy) ? 1 : 0;
            }
        }
    }

    /**
     * Returns the serial number of the phone
     * @return string - serial number
     */
    public String getSerial() {
        return this.serial;
    }

    /**
     * Paints the pixels and the serial number on the phone
     * @param g Graphic component
     */
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
        g.drawString(serial, (int)((double)(screenSize * Pixel.size) / 2.5), topOffset / 2);
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


    /**
     * Invoked the first time a window is made visible.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {

        String message = (isPhoneBroken())?"Phone is broken":"Phone is working";
        new PopUp(this,message);
        isClosed = true;
        dispose();
    }

    /**
     * Invoked when a window has been closed as the result
     * of calling dispose on the window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a normal to a
     * minimized state. For many platforms, a minimized window
     * is displayed as the icon specified in the window's
     * iconImage property.
     *
     * @param e the event to be processed
     * @see Frame#setIconImage
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a minimized
     * to a normal state.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * Invoked when the Window is set to be the active Window. Only a Frame or
     * a Dialog can be the active Window. The native windowing system may
     * denote the active Window or its children with special decorations, such
     * as a highlighted title bar. The active Window is always either the
     * focused Window, or the first Frame or Dialog that is an owner of the
     * focused Window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     * Invoked when a Window is no longer the active Window. Only a Frame or a
     * Dialog can be the active Window. The native windowing system may denote
     * the active Window or its children with special decorations, such as a
     * highlighted title bar. The active Window is always either the focused
     * Window, or the first Frame or Dialog that is an owner of the focused
     * Window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
