import java.awt.*;
import java.util.Random;

public class Pixel {
    public static final int size = 30;
    private int clicks = 0;
    private Color c;
    private PixelState pixelState;
    public Pixel(){
        Random random = new Random();
        this.c = setColor(random.nextInt(3));
        this.pixelState = PixelState.values()[(random.nextInt(PixelState.values().length))];
    }

    public Color getColor() {
        return c;
    }

    private Color setColor(int random){

        return switch (random) {
            case 0 -> new Color(255, 0, 0);
            case 1 -> new Color(0, 255, 0);
            case 2 -> new Color(0, 0, 255);
            default -> null;
        };
    }

    public void click(){
        clicks++;
        if(clicks ==1 && pixelState == PixelState.burnt) c = new Color(0,0,0);
        if(clicks ==3 && pixelState == PixelState.aboutToBurn) c = new Color(0,0,0);
    }
}
