package Crossers;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Plant implements ICrosser {
int positionX=-10,positionY=1090;

   private static Plant instance = null;
    private String customAttribute;

    public Plant() {

    }

    public static Plant getInstance() {
        if (instance == null) {
            instance = new Plant();
        }
        return instance;
    }
    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public int getEatingRank() {
        return 1;
   }
      public int getPositionX() {
        return positionX;
    }

   

    public int getPositionY() {
        return positionY;
    }


    @Override
    public BufferedImage[] getImages() {
    BufferedImage b[]=new BufferedImage[1];
        try {
            b[0]=ImageIO.read(new File("plant.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    return b;
    }

    @Override
    public ICrosser makeCopy() {
     return new Plant();
    }

    @Override
    public double getWeight(){
    return 0;
} 
}
