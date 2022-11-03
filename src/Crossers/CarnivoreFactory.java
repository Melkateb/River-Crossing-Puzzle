package Crossers;


import Crossers.Fox;
import Crossers.Harbivore;


public class CarnivoreFactory extends AbstractFactory {
private static CarnivoreFactory instance = null;
    private String customAttribute;

    public CarnivoreFactory () {

    }

    public static CarnivoreFactory  getInstance() {
        if (instance == null) {
            instance = new CarnivoreFactory ();
        }
        return instance;
    }
    @Override
    public Carnivore getCarnivoire(String cname) {
        if (cname.equals("Fox")) {
            return new Fox();
        } 
        return null;
    }

    @Override
    public Harbivore getHarbivoire(String hname) {
        return null;
    }



}
