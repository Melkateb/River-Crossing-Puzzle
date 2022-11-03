package Crossers;


import Crossers.ICrosser;
import java.awt.image.BufferedImage;

public abstract class Carnivore implements ICrosser {

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public int getEatingRank() {
        return 3;
    }

    @Override
    public abstract BufferedImage[] getImages();

    @Override
    public abstract ICrosser makeCopy();
    @Override
    public abstract double getWeight(); 
}

