/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crossers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author HossamRezk
 */
public class Farmer4 extends Farmer{
int positionX=150,positionY=1300;
     
     private static Farmer4 instance = null;
     
      public static Farmer4 getInstance() {
        if (instance == null) {
            instance = new Farmer4();
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
            b[0]=ImageIO.read(new File("farmer4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    return b;
    }
    @Override
    public ICrosser makeCopy() {
        return new Farmer4();
    }

    @Override
    public double getWeight() {
        return 90;
    }   
}
