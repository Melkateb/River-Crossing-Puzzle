package Crossers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Dog implements ICrosser{

    int positionX=-10,positionY=800;
    
    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public int getEatingRank() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 20;
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
         return new Dog();
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public int getPositionX() {
       return positionX;
    }
    
}
