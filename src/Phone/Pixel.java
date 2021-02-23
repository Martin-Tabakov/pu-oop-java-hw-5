package Phone;

import java.awt.*;
import java.util.Random;

public class Pixel {
    public static final int size = 10;
    private int clicks = 0;
    private Color c;
    private PixelState pixelState;

    /**
     * Constructor for a pixel instance
     */
    public Pixel(){
        Random random = new Random();
        this.c = setColor(random.nextInt(3));
        this.pixelState = generateState(random);
    }

    /**
     * Randomly generates the state of a pixel
     * @param random Random component, used for assigning a random state
     * @return PixelState
     */
    private PixelState generateState(Random random){
        boolean isWorking = random.nextBoolean();
        if (isWorking) return PixelState.healthy;
        boolean isBurnt = random.nextBoolean();
        if (isBurnt) return PixelState.burnt;
        return PixelState.aboutToBurn;
    }

    /**
     * Returns the pixel state of the pixel
     * @return pixelState
     */
    PixelState getPixelState() {
        return pixelState;
    }
    /**
     * Returns the color of the pixel
     * @return Color
     */
    public Color getColor() {
        return c;
    }

    /**
     * Assigns the pixel a random color
     * @param random Random component
     * @return randomly generated Color
     */
    private Color setColor(int random){

        return switch (random) {
            case 0 -> new Color(255, 0, 0);
            case 1 -> new Color(0, 255, 0);
            case 2 -> new Color(0, 0, 255);
            default -> null;
        };
    }

    /**
     * Called when a click is made on the pixel
     */
    public void click(){
        clicks++;
        if(clicks ==1 && pixelState == PixelState.burnt) c = new Color(0,0,0);
        if(clicks ==3 && pixelState == PixelState.aboutToBurn) c = new Color(0,0,0);
    }
}
