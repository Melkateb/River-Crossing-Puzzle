package Crossers;

import Crossers.Farmer;
import Crossers.ICrosser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Farmer1 extends Farmer{
     int positionX=-10,positionY=1150;
     
     private static Farmer1 instance = null;
     
      public static Farmer1 getInstance() {
        if (instance == null) {
            instance = new Farmer1();
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
            b[0]=ImageIO.read(new File("farmer1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    return b;
    }
    @Override
    public ICrosser makeCopy() {
        return new Farmer1();
    }

    @Override
    public double getWeight() {
        return 80;
    }
    
}
