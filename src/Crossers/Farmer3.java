package Crossers;

import Crossers.Farmer;
import Crossers.ICrosser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Farmer3 extends Farmer{
    int positionX=50,positionY=1250;
     
     private static Farmer3 instance = null;
     
      public static Farmer3 getInstance() {
        if (instance == null) {
            instance = new Farmer3();
        }
        return instance;
    }
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
    public BufferedImage[] getImages() {
         BufferedImage b[]=new BufferedImage[1];
        try {
            b[0]=ImageIO.read(new File("farmer3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    return b;
    }
    @Override
    public ICrosser makeCopy() {
        return new Farmer3();
    }

    @Override
    public double getWeight() {
        return 60;
    }
    
}