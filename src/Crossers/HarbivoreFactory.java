package Crossers;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HossamRezk
 */
public class HarbivoreFactory extends AbstractFactory{
    private static HarbivoreFactory instance = null;
    private String customAttribute;

    public HarbivoreFactory () {

    }

    public static HarbivoreFactory  getInstance() {
        if (instance == null) {
            instance = new HarbivoreFactory ();
        }
        return instance;
    }
    @Override
    public Carnivore getCarnivoire(String cname) {
        return null;
    }

    @Override
    public Harbivore getHarbivoire(String hname) {
         if (hname.equals("Goat")) {
            return new Goat();
        } 
        return null;
    }  
}

