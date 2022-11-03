/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Crossers.ICrosser;
import java.util.ArrayList;

/**
 *
 * @author mariam
 */
public class Mystate {
    
    
    private    boolean place = false;
    private    ArrayList<ICrosser> rlist1 = new ArrayList<>();
    private    ArrayList<ICrosser> llist1 = new ArrayList<>();
    private    ArrayList<ICrosser> blist1 = new ArrayList<>();

        
    public boolean isPlace() {
        return place;
    }

    public void setPlace(boolean place) {
        this.place = place;
    }

    public ArrayList<ICrosser> getRlist1() {
        return rlist1;
    }

    public void setRlist1(ArrayList<ICrosser> rlist1) {
        this.rlist1 = rlist1;
    }

    public ArrayList<ICrosser> getLlist1() {
        return llist1;
    }

    public void setLlist1(ArrayList<ICrosser> llist1) {
        this.llist1 = llist1;
    }

    public ArrayList<ICrosser> getBlist1() {
        return blist1;
    }

    public void setBlist1(ArrayList<ICrosser> blist1) {
        this.blist1 = blist1;
    }
        
       public boolean getPlace() {
        return place;
    } 
    
}
