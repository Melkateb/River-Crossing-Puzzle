package Crossers;

import Crossers.ICrosser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Farmer implements ICrosser {
    int positionX=0,positionY=1250;

  
   
private static Farmer instance = null;
    private String customAttribute;

    public Farmer() {

    }

    public static Farmer getInstance() {
        if (instance == null) {
            instance = new Farmer();
        }
        return instance;
    }
    @Override
    public boolean canSail() {
        return true;
    }
      public int getPositionX() {
        return positionX;
    }

   

    public int getPositionY() {
        return positionY;
    }


    @Override
    public int getEatingRank() {
        return 10;
    }

    @Override
    public BufferedImage[] getImages() {
        BufferedImage b[] = new BufferedImage[1];
        try {
            b[0] = ImageIO.read(new File("farmer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return b;
    }

    @Override
    public ICrosser makeCopy() {
        return new Farmer();
    }

    @Override
    public double getWeight(){
    return 90;
} 

}
