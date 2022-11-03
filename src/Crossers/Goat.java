package Crossers;


import Crossers.Harbivore;
import Crossers.HarbivoreFactory;
import Crossers.ICrosser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Goat extends Harbivore{
    int positionX=-50,positionY=1190;
    private static Goat instance = null;
    private String customAttribute;

    public Goat() {

    }

    public static Goat getInstance() {
        if (instance == null) {
            instance = new Goat();
        }
        return instance;
    }
   
 HarbivoreFactory factory;
    @Override
    public BufferedImage[] getImages() {
         BufferedImage b[]=new BufferedImage[2];
        try {
            b[0]=ImageIO.read(new File("goat.png"));
             b[1]=ImageIO.read(new File("rabbit.png"));
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
     return factory.getHarbivoire("Goat");
    }
    @Override
    public double getWeight(){
    return 0;
} 
  
}
