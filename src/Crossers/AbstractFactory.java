package Crossers;


import Crossers.Carnivore;
import Crossers.Harbivore;


public abstract class AbstractFactory {

    public abstract Carnivore getCarnivoire(String cname);

    public abstract Harbivore getHarbivoire(String hname);

}

