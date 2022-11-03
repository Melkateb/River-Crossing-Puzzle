
package Crossers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Animal extends Fox{
int positionX=-40,positionY=1250;
     
     private static Animal instance = null;
     
      public static Animal getInstance() {
        if (instance == null) {
            instance = new Animal();
        }
        return instance;
    }
      public boolean canSail() {
        return false;
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
            b[0]=ImageIO.read(new File("dog.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    return b;
    }
    @Override
    public ICrosser makeCopy() {
        return new Animal();
    }

    @Override
    public double getWeight() {
        return 20;
    }   
}
