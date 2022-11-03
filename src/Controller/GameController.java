package Controller;

import Crossers.Animal;
import Crossers.Farmer;
import Crossers.Farmer1;
import Crossers.Farmer2;
import Crossers.Farmer3;
import Crossers.Farmer4;
import Crossers.Fox;
import Crossers.Goat;
import Crossers.ICrosser;
import Crossers.IcrossingStrategy;
import Crossers.Plant;
import Crossers.Story1;
import Crossers.Story2;
import Gui.GamePanel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GameController implements IRiverCrossingController {

    private int positionX;
    private boolean left = true;
    private int count = 0;
    Story1 story1 = new Story1();
    Story2 story2 = new Story2();
    Farmer farmer = Farmer.getInstance();
    Farmer1 farmer1 = Farmer1.getInstance();
    Farmer2 farmer2 = Farmer2.getInstance();
    Farmer3 farmer3 = Farmer3.getInstance();
    Farmer4 farmer4 = Farmer4.getInstance();
    Animal animal = Animal.getInstance();
    boolean draw;
    //GamePanel gamepanel=new GamePanel();
    Fox fox = Fox.getInstance();
    Goat goat = Goat.getInstance();
    Plant plant = Plant.getInstance();
    List<ICrosser> rlist = new ArrayList<>();
    List<ICrosser> llist = new ArrayList<>();
    List<ICrosser> blist = new ArrayList<>();
    IcrossingStrategy str;
    String name;
    int z;
    boolean h = true;
    private static GameController instance = null;
    private String customAttribute;
    public Stack<Mystate> undoStackS = new Stack<Mystate>();
    public Stack<Mystate> redoStackS = new Stack<Mystate>();

    private GameController() {

    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void setname(String name) {
        this.name = name;
        System.out.println(name);
    }

    @Override
    public void newGame(IcrossingStrategy gameStrategy) {
        str = gameStrategy;
    }

    @Override
    public void resetGame() {
      Lists list = Lists.getList(str);
      rlist = list.rlist;
      llist = list.llist;
      blist = list.blist;
      blist.removeAll(blist);
      rlist.removeAll(rlist);
      llist.removeAll(llist);
       if (str instanceof Story1) 
      llist.addAll(story1.getInitialCrossers());
       else if(str instanceof Story2)
            llist.addAll(story2.getInitialCrossers());  
    }

    @Override
    public String[] getInstructions() {
        String[] I = new String[5];
         if (str instanceof Story1) {
        I=story1.getInstructions();
         
         }else if(str instanceof Story2){
             I=story2.getInstructions();
         }
         return I;
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rlist;
    }

    public List<ICrosser> getCrossersOnBoat() {
        return blist;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        if (str instanceof Story1) {
            llist = str.getInitialCrossers();
        } else if (str instanceof Story2) {
            llist = str.getInitialCrossers();
        }

        return llist;
    }

    public boolean checkTheBank(boolean left) {
        boolean safe = true;
        int i;
        Lists list = Lists.getList(str);
        llist = list.llist;
        if (left == true) {
            for (i = 0; i < llist.size() - 1; i++) {

                int x = llist.get(i).getEatingRank();
                int y = llist.get(i + 1).getEatingRank();
                if ((x - y) == 1 || (x - y) == -1) {
                    safe = false;

                }

            }
        } else if (left == false) {
            for (i = 0; i < rlist.size() - 1; i++) {

                int x = rlist.get(i).getEatingRank();
                int y = rlist.get(i + 1).getEatingRank();
                if ((x - y) == 1 || (x - y) == -1) {
                    safe = false;
                }
            }
        }
        return safe;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return h;
    }

    @Override
    public int getNumberOfSails() {
        count++;
        return count;
    }
 public int removeSail(){
       count--;
       return count;
   }
    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        boolean move = false;
        if (str instanceof Story1) {
            //boolean move = false;
            if (crossers.size() == 1 || crossers.size() == 2) {
                for (int i = 0; i < crossers.size(); i++) {
                    ICrosser object = crossers.get(i);
                    if (object.canSail()) {
                       move = true;
                        Mystate s1 = new Mystate();
                        List<ICrosser> left1 = new ArrayList<>();
                        left1.addAll(llist);
                        List<ICrosser> boat1 = new ArrayList<>();
                        boat1.addAll(blist);
                        List<ICrosser> right1 = new ArrayList<>();
                        right1.addAll(rlist);
                        s1.setLlist1((ArrayList<ICrosser>) left1);
                        s1.setBlist1((ArrayList<ICrosser>) boat1);
                        s1.setRlist1((ArrayList<ICrosser>) right1);
                        s1.setPlace(isBoatOnTheLeftBank());
                        undoStackS.push(s1);
                        return move;
                    }

                }
            }
            return move;
        } else if (str instanceof Story2) {
           
            move = story2.isValid(llist, rlist, crossers);
            if (move == true) {
                Mystate s1 = new Mystate();
                List<ICrosser> left1 = new ArrayList<>();
                left1.addAll(llist);
                List<ICrosser> boat1 = new ArrayList<>();
                boat1.addAll(blist);
                List<ICrosser> right1 = new ArrayList<>();
                right1.addAll(rlist);
                s1.setLlist1((ArrayList<ICrosser>) left1);
                s1.setBlist1((ArrayList<ICrosser>) boat1);
                s1.setRlist1((ArrayList<ICrosser>) right1);
                s1.setPlace(isBoatOnTheLeftBank());
                undoStackS.push(s1);
            }
            return move;
        }
        return move;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        boolean left = isBoatOnTheLeftBank();
        Lists list = Lists.getList(str);
        llist = list.llist;
        rlist = list.rlist;
        if (left == false) {
            for (int g = 0; g < blist.size(); g++) {
                rlist.add(blist.get(g));
                //   blist.remove(g);

            }
            blist.removeAll(blist);
        } else if (left == true) {
            for (int g = 0; g < blist.size(); g++) {
                llist.add(blist.get(g));
                // blist.remove(g);

            }
            blist.removeAll(blist);

        }
    }

    @Override
    public boolean canUndo() {
         if (!undoStackS.isEmpty()) {
            undo();
            return true;
        }
        return false;
    }

    @Override
    public boolean canRedo() {
         if (!redoStackS.isEmpty()) {
            redo();
            return true;
        }
          return false;
    }

    @Override
    public void undo() {
         Lists list = Lists.getList(str);
        System.out.println("list size " + list.llist.size());
        Mystate s = new Mystate();
        s = undoStackS.pop();
        redoStackS.push(s);
        list.setLlist(s.getLlist1());
        list.setRlist(s.getRlist1());
        list.setBlist(s.getBlist1());
        h = s.getPlace();
    }

    @Override
    public void redo() {
        Lists list = Lists.getList(str);
        Mystate s = new Mystate();
        s = redoStackS.pop();
        undoStackS.push(s);
        list.setLlist(s.getLlist1());
        list.setRlist(s.getRlist1());
        list.setBlist(s.getBlist1());
        h = s.getPlace();
    }
    

    @Override
    public void saveGame() {
// xml
    }

    @Override
    public void loadGame() {
    if (str instanceof Story1) {     
   try {
         File inputFile = new File("crossriver.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList bList = doc.getElementsByTagName("blist");
         System.out.println("----------------------------");
      Lists list = Lists.getList(str);
      rlist = list.rlist;
      llist = list.llist;
      blist = list.blist;
      blist.removeAll(blist);
      rlist.removeAll(rlist);
      llist.removeAll(llist);
         for (int temp = 0; temp < bList.getLength(); temp++) {
       
       
             Node nNode = bList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
              for(int i=0;i<eElement.getElementsByTagName("Crosser").getLength();i++){
                 System.out.println("First Name : " + eElement.getElementsByTagName("Crosser").item(i).getTextContent());
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Plant")){
                     blist.add(plant);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Carnivore")){
                     blist.add(fox);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Harbivore")){
                     blist.add(goat);
                 } 
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer")){
                     blist.add(farmer);
                 } 
              }
              
            }
         }
         NodeList lList = doc.getElementsByTagName("leftarray");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < lList.getLength(); temp++) {
            Node nNode = lList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
              
              for(int i=0;i<eElement.getElementsByTagName("Crosser").getLength();i++){
                 System.out.println("First Name : " + eElement.getElementsByTagName("Crosser").item(i).getTextContent());
                  if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Plant")){
                     llist.add(plant);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Carnivore")){
                     llist.add(fox);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Harbivore")){
                     llist.add(goat);
                 } 
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer")){
                     llist.add(farmer);
                 } 
                
              }
            }
         }
         NodeList rList = doc.getElementsByTagName("rlist");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < rList.getLength(); temp++) {
        Node nNode = rList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
              
              for(int i=0;i<eElement.getElementsByTagName("Crosser").getLength();i++){
                 System.out.println("First Name : " + eElement.getElementsByTagName("Crosser").item(i).getTextContent());
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Plant")){
                     rlist.add(plant);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Carnivore")){
                     rlist.add(fox);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Harbivore")){
                     rlist.add(goat);
                 } 
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer")){
                     rlist.add(farmer);
                 } 
              }
            }
         }
          NodeList position = doc.getElementsByTagName("postion");
           System.out.println("----------------------------");
           Node nNode4 = position.item(0);
            System.out.println("ANAA MAKAN : " +nNode4.getTextContent());
            if(nNode4.getTextContent().equals("left")){
                //position(true);
                draw=true;
            }
            else if(nNode4.getTextContent().equals("right")){
              //  position(false);
                draw=false;
            }
            
         NodeList score = doc.getElementsByTagName("score");
           System.out.println("----------------------------");
           Node nNode1 = score.item(0);
            System.out.println("ANAA SCORE : " +nNode1.getTextContent());
          count=Integer.parseInt(nNode1.getTextContent());
         
      } catch (Exception e) {
         e.printStackTrace();
      } 
    }
    else if (str instanceof Story2) {     
   try {
         File inputFile = new File("crossriverstory2.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList bList = doc.getElementsByTagName("blist");
         System.out.println("----------------------------");
      Lists list = Lists.getList(str);
      rlist = list.rlist;
      llist = list.llist;
      blist = list.blist;
      blist.removeAll(blist);
      rlist.removeAll(rlist);
      llist.removeAll(llist);
         for (int temp = 0; temp < bList.getLength(); temp++) {
          //   System.out.println("LENGHTTBOATT      "+bList.);
       
             Node nNode = bList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
              for(int i=0;i<eElement.getElementsByTagName("Crosser").getLength();i++){
                 System.out.println("First Name : " + eElement.getElementsByTagName("Crosser").item(i).getTextContent());
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer1")){
                     blist.add(farmer1);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer2")){
                     blist.add(farmer2);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer3")){
                     blist.add(farmer3);
                 } 
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer4")){
                     blist.add(farmer4);
                 } 
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Animal")){
                     blist.add(animal);
                 } 
              }
              
            }
         }
         NodeList lList = doc.getElementsByTagName("leftarray");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < lList.getLength(); temp++) {
            Node nNode = lList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
              
              for(int i=0;i<eElement.getElementsByTagName("Crosser").getLength();i++){
                 System.out.println("First Name : " + eElement.getElementsByTagName("Crosser").item(i).getTextContent());
                  if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer1")){
                     llist.add(farmer1);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer2")){
                     llist.add(farmer2);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer3")){
                     llist.add(farmer3);
                 } 
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer4")){
                     llist.add(farmer4);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Animal")){
                     llist.add(animal);
                 }
              }
            }
         }
         NodeList rList = doc.getElementsByTagName("rlist");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < rList.getLength(); temp++) {
        Node nNode = rList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
              
              for(int i=0;i<eElement.getElementsByTagName("Crosser").getLength();i++){
                 System.out.println("First Name : " + eElement.getElementsByTagName("Crosser").item(i).getTextContent());
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer1")){
                     rlist.add(farmer1);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer2")){
                     rlist.add(farmer2);
                 } 
                if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer3")){
                     rlist.add(farmer3);
                 } 
                 if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Farmer4")){
                     rlist.add(farmer4);
                 } 
                  if(eElement.getElementsByTagName("Crosser").item(i).getTextContent().equals("Animal")){
                     rlist.add(animal);
                 } 
              }
            }
         }
          NodeList position = doc.getElementsByTagName("postion");
           System.out.println("----------------------------");
           Node nNode4 = position.item(0);
            System.out.println("ANAA MAKAN : " +nNode4.getTextContent());
            if(nNode4.getTextContent().equals("left")){
                //position(true);
                draw=true;
            }
            else if(nNode4.getTextContent().equals("right")){
              //  position(false);
                draw=false;
            }
         
         NodeList score = doc.getElementsByTagName("score");
           System.out.println("----------------------------");
           Node nNode1 = score.item(0);
            System.out.println("ANAA SCORE : " +nNode1.getTextContent());
          count=Integer.parseInt(nNode1.getTextContent());
          
//            System.out.println("ANAA SCORE : " +nNode2.getTextContent());
//            if(nNode2.getTextContent().equals("left")){
  //              h=true;
    //        }
      //      else{
        //        h=false;
          //  }
          //count=Integer.parseInt(nNode1.getTextContent());
      } catch (Exception e) {
         e.printStackTrace();
      } 
    }
    }
    public void edit(String name) {

        boolean left = isBoatOnTheLeftBank();
        if (str instanceof Story1) {
            if (left == true) {
                System.out.println("iS THE BANK ON THE LEFT SIDE? "+h);
                for (int i = 0; i < llist.size(); i++) {
                    if (name.equals("farmer")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getEatingRank() == farmer.getEatingRank()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("fox")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getEatingRank() == fox.getEatingRank()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("goat")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getEatingRank() == goat.getEatingRank()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("plant")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getEatingRank() == plant.getEatingRank()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    }
                }

            }
            if (left == false) {
                System.out.println("ANAWASLT");
                for (int i = 0; i < rlist.size(); i++) {
                    if (name.equals("farmer")) {
                        if (blist.size() < 2) {

                            Lists list = Lists.getList(str);
                            rlist = list.rlist;
                            for (int n = 0; n < rlist.size(); n++) {
                                if (rlist.get(n).getEatingRank() == farmer.getEatingRank()) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }

                            }
                        }
                    } else if (name.equals("fox")) {
                        if (blist.size() < 2) {
                            Lists list = Lists.getList(str);
                            rlist = list.rlist;
                            for (int n = 0; n < rlist.size(); n++) {
                                if (rlist.get(n).getEatingRank() == fox.getEatingRank()) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }

                            }

                        }
                    } else if (name.equals("goat")) {
                        if (blist.size() < 2) {

                            Lists list = Lists.getList(str);
                            rlist = list.rlist;
                            for (int n = 0; n < rlist.size(); n++) {
                                if (rlist.get(n).getEatingRank() == goat.getEatingRank()) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }

                            }
                        }
                    } else if (name.equals("plant")) {
                        if (blist.size() < 2) {

                            Lists list = Lists.getList(str);
                            rlist = list.rlist;
                            for (int n = 0; n < rlist.size(); n++) {
                                if (rlist.get(n).getEatingRank() == plant.getEatingRank()) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }

                            }
                        }
                    }
                }

            }
        } else if (str instanceof Story2) {
            if (left == true) {

                for (int i = 0; i < llist.size(); i++) {
                    if (name.equals("farmer1")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getWeight() == farmer1.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("farmer2")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getWeight() == farmer2.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("farmer3")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getWeight() == farmer3.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("farmer4")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getWeight() == farmer4.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("animal")) {
                        Lists list = Lists.getList(str);
                        llist = list.llist;
                        for (int n = 0; n < llist.size(); n++) {
                            if (llist.get(n).getWeight() == animal.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(llist.get(n));
                                    llist.remove(n);
                                    break;
                                }
                            }

                        }
                    }
                }

            }
            if (left == false) {
                for (int i = 0; i < rlist.size(); i++) {
                    if (name.equals("farmer1")) {
                        Lists list = Lists.getList(str);
                        rlist = list.rlist;
                        for (int n = 0; n < rlist.size(); n++) {
                            if (rlist.get(n).getWeight() == farmer1.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("farmer2")) {
                        Lists list = Lists.getList(str);
                        rlist = list.rlist;
                        for (int n = 0; n < rlist.size(); n++) {
                            if (rlist.get(n).getWeight() == farmer2.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("farmer3")) {
                        Lists list = Lists.getList(str);
                        rlist = list.rlist;
                        for (int n = 0; n < rlist.size(); n++) {
                            if (rlist.get(n).getWeight() == farmer3.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("farmer4")) {
                        Lists list = Lists.getList(str);
                        rlist = list.rlist;
                        for (int n = 0; n < rlist.size(); n++) {
                            if (rlist.get(n).getWeight() == farmer4.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }
                            }

                        }
                    } else if (name.equals("animal")) {
                        Lists list = Lists.getList(str);
                        rlist = list.rlist;
                        for (int n = 0; n < rlist.size(); n++) {
                            if (rlist.get(n).getWeight() == animal.getWeight()) {
                                if (blist.size() < 2) {
                                    blist.add(rlist.get(n));
                                    rlist.remove(n);
                                    break;
                                }
                            }

                        }
                    }
                }

            }
        }
    }

    public List<ICrosser> getLlist() {
        return llist;
    }

    public void setLlist(List<ICrosser> llist) {
        this.llist = llist;
    }

    public List<ICrosser> getBlist() {
        return blist;
    }

    public void setBlist(List<ICrosser> blist) {
        this.blist = blist;
    }

    public void position(boolean h) {
        this.h = h;
    }
    public String[] show(){
        String[] a=story1.getInstructions();
        return a;
    } 
    public boolean congrats(){
        if(blist.size()==0&&llist.size()==0){
            return true;
        }
       return false;
    }
public int moves() {
        
        return count;
    }
 public void reset(){
      Lists list = Lists.getList(str);
      rlist = list.rlist;
      llist = list.llist;
      blist = list.blist;
      blist.removeAll(blist);
      rlist.removeAll(rlist);
      llist.addAll(story1.getInitialCrossers());
    //  if(controller.isBoatOnTheLeftBank()==false){
      //   moveleft=true; 
      //}
    }
public void dec(){
    count=0;
}
   public boolean drawing(){
   return draw;       
   } 
  
}
