package Crossers;

import java.awt.image.BufferedImage;

public interface ICrosser {

    public boolean canSail();

    public int getEatingRank();

    public double getWeight();
    
    public BufferedImage[] getImages();

    public ICrosser makeCopy();

    public int getPositionY();

    public int getPositionX();
}
