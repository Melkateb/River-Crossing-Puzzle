package Crossers;

import Crossers.Farmer;
import Crossers.ICrosser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Farmer2 extends Farmer{
     int positionX=100,positionY=1200;
     
     private static Farmer2 instance = null;
     
      public static Farmer2 getInstance() {
        if (instance == null) {
            instance = new Farmer2();
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
            b[0]=ImageIO.read(new File("farmer2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    return b;
    }
    @Override
    public ICrosser makeCopy() {
        return new Farmer2();
    }

    @Override
    public double getWeight() {
        return 40;
    }
    
}