package Crossers;



import Crossers.ICrosser;
import java.awt.image.BufferedImage;

public abstract class Harbivore implements ICrosser {

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public int getEatingRank() {
        return 2;
    }

    @Override
    public abstract BufferedImage[] getImages();

    @Override
    public abstract ICrosser makeCopy();
     @Override
    public abstract double getWeight(); 

}
