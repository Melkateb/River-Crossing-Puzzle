/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import Controller.Lists;
import Crossers.Carnivore;
import Crossers.Farmer;
import Crossers.Farmer2;
import Crossers.Farmer3;
import Crossers.Farmer4;
import Crossers.Harbivore;
import Crossers.ICrosser;
import Crossers.IcrossingStrategy;
import Crossers.Plant;
import Crossers.Story1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
/**
 *
 * @author HossamRezk
 */
public class FileXml {
     public List<ICrosser> leftarr = new ArrayList<>();
    public List<ICrosser> rightarr = new ArrayList<>(); 
   public List<ICrosser> boatriders = new ArrayList<>(); 
   IcrossingStrategy str;
    
     public static final String xmlFilePath = "C:\\Users\\HossamRezk\\Desktop\\Song\\story\\AMIRA1111\\xmlfile.xml";
 public void getstrategy(IcrossingStrategy gameStrategy) {
        str = gameStrategy;
    }
    public void setLeftarr() {
        Lists list = Lists.getList(str);
        leftarr = list.llist;
       // this.leftarr = leftarr;
    }

    public void setRightarr() {
        Lists list = Lists.getList(str);
        rightarr = list.rlist;
    }

    public void setBoatriders(List<ICrosser> boatriders) {
        Lists list = Lists.getList(str);
        //boatriders = list.;
    }
   
    
}