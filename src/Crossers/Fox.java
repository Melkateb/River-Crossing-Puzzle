package Crossers;


import Crossers.ICrosser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Fox extends Carnivore{
    int positionX=100,positionY=1120;
    private static Fox instance = null;
    private String customAttribute;

    public Fox() {

    }

    public static Fox getInstance() {
        if (instance == null) {
            instance = new Fox();
        }
        return instance;
    }
  
    CarnivoreFactory factory;

    @Override
    public BufferedImage[] getImages() {
    BufferedImage b[]=new BufferedImage[2];
        try {
            b[0]=ImageIO.read(new File("fox.png"));
            b[1]=ImageIO.read(new File("fox1.png"));
        //    b[1]=ImageIO.read(new File("rabbit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    return b;
    }
  public int getPositionX() {
        return positionX;
    }

   

    public int getPositionY() {
        return positionY;
    }

    @Override
    public ICrosser makeCopy() {
    return factory.getCarnivoire("Fox");
    }
    @Override
    public double getWeight(){
    return 0;
} 
}
