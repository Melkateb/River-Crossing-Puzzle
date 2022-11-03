package Gui;

import Controller.GameController;
import Controller.Lists;
import Crossers.Carnivore;
import Crossers.Farmer;
import Crossers.Farmer2;
import Crossers.Farmer3;
import Crossers.Farmer4;
import Crossers.Fox;
import Crossers.Goat;
import Crossers.Harbivore;
import Crossers.ICrosser;
import Crossers.IcrossingStrategy;
import Crossers.Plant;
import Crossers.Story1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Random;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GamePanel extends JPanel implements ActionListener {

    Graphics g;
    Farmer farmer = Farmer.getInstance();
     Fox fox = Fox.getInstance();
     Plant plant = Plant.getInstance();
    IcrossingStrategy str = new Story1();
    List<ICrosser> Boat = new ArrayList<>();
    List<ICrosser> cL = new ArrayList<>();
    private int mouseX, mouseY;
    // String name;
    Story1 story1 = new Story1();
    //  GameController controller = new GameController(this);
    GameController controller = GameController.getInstance();
    Goat goat = Goat.getInstance();
    boolean left = true;
    int x = -10;
    private int z = 350;
    int y = 600;
    int a = 0;
    int b = 150;
    int p;

    /*   public int getP() {
        return p;
    }*/
    Timer t = new Timer(100, this);
    boolean moveright = false;
    boolean moveleft = false;
    boolean move = false;
    boolean move1 = false;
    boolean move2 = false;
    boolean move3 = false;
    boolean move4 = false;
     boolean reset;
     boolean draw=true;
    List<ICrosser> newList = new ArrayList<>();
    Random rand = new Random();
       // int num= rand.nextInt(1);
       int num=(int) Math.round( Math.random() )  ;

    public GamePanel() {
        t.start();
        controller.newGame(story1);
    }
    List<ICrosser> llist = new ArrayList<>();
    List<ICrosser> rlist = new ArrayList<>();
    List<ICrosser> blist = new ArrayList<>();

    public List<ICrosser> getLlist() {
        return llist;
    }

    public void BoatRiders(ICrosser crosser) {
        Boat.add(crosser);
    }

    public List<ICrosser> boatPassengers() {
        return blist;
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.g = g;

        super.paintComponent(g);
        if (controller == null) {
            return;
        }
        //List<ICrosser> cR = new ArrayList<>();
        // List<ICrosser> Boat = new ArrayList<>();
        //cL = controller.getCrossersOnLeftBank();
        //cR = controller.getCrossersOnRightBank();
        llist = controller.getCrossersOnLeftBank();
        rlist = controller.getCrossersOnRightBank();
        blist = controller.getCrossersOnBoat();
        ImageIcon im = null;
        ImageIcon im1 = null;
        if (left == true) {
            im = new ImageIcon("rr.jpg");
            im1 = new ImageIcon("1.png");
        } else {
            im = new ImageIcon("");
            im1 = new ImageIcon("");
        }
        g.drawImage(im.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
        
        g.drawImage(im1.getImage(), z, 500, 200, 100, this);
            
        p = 200;
        BufferedImage lim[] = new BufferedImage[llist.size()];
        BufferedImage rim[] = new BufferedImage[rlist.size()];
        BufferedImage bim[] = new BufferedImage[blist.size()];
        Lists list = Lists.getList(str);
        llist = list.llist;
        //Lists list = Lists.getList();
        rlist = list.rlist;
      //  Random rand = new Random();
       // int num= rand.nextInt(1);
      // int num=(int) Math.round( Math.random() )  ;
        System.out.println("RANDOM"+num);
        if (llist.size() > 0) {
            for (int i = 0; i < llist.size(); i++) {
                if(llist.get(i).getEatingRank() == goat.getEatingRank()){
                lim = llist.get(i).getImages();
                Image image = lim[num];
                g.drawImage(image, llist.get(i).getPositionX(), 400, 120, 120, this);}
                 if(llist.get(i).getEatingRank() == fox.getEatingRank()){
                lim = llist.get(i).getImages();
                Image image = lim[num];
                g.drawImage(image, llist.get(i).getPositionX(), 400, 120, 120, this);}
                if(llist.get(i).getEatingRank() == farmer.getEatingRank()||llist.get(i).getEatingRank() == plant.getEatingRank()){
                   lim = llist.get(i).getImages();
                Image image = lim[0]; 
                 g.drawImage(image, llist.get(i).getPositionX(), 400, 120, 120, this);
                } 

            }
        }//repaint();
        if (rlist.size() > 0) {
            for (int j = 0; j < rlist.size(); j++) {
    if(rlist.get(j).getEatingRank() == goat.getEatingRank()){
                rim = rlist.get(j).getImages();
                Image image = rim[num];
                g.drawImage(image, rlist.get(j).getPositionY(), 400, 120, 120, this);}
                 if(rlist.get(j).getEatingRank() == fox.getEatingRank()){
                rim = rlist.get(j).getImages();
                Image image = rim[num];
                g.drawImage(image, rlist.get(j).getPositionY(), 400, 120, 120, this);}
                if(rlist.get(j).getEatingRank() == farmer.getEatingRank()||rlist.get(j).getEatingRank() == plant.getEatingRank()){
                   rim = rlist.get(j).getImages();
                Image image = rim[0]; 
                 g.drawImage(image, rlist.get(j).getPositionY(), 400, 120, 120, this);
                } 
               // rim = rlist.get(j).getImages();
               // Image image = rim[0];
               // g.drawImage(image, rlist.get(j).getPositionY(), 400, 200, 200, this);

            }
        }
        if (blist.size() > 0) {
            for (int k = 0; k < blist.size(); k++) {
               if(blist.get(k).getEatingRank() == goat.getEatingRank()){
                lim = blist.get(k).getImages();
                Image image = lim[num];
                g.drawImage(image,z, 400, 120, 120, this);}
                if(blist.get(k).getEatingRank() == fox.getEatingRank()){
                lim = blist.get(k).getImages();
                Image image = lim[num];
                g.drawImage(image,z, 400, 120, 120, this);} 
               bim = blist.get(k).getImages();
              if(blist.get(k).getEatingRank() == farmer.getEatingRank()||blist.get(k).getEatingRank() == plant.getEatingRank()){  
                Image image = bim[0];
                g.drawImage(image, z, 400, 120, 120, this);
              }
            }
        }
        //repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // g.dispose();

        //removeAll(); 
        //repaint();
        if (moveright == true) {
            if (z <= 850) {
                z += 50;
                p = 550;
            } else {
                moveright = false;
            }
        }
        if (moveleft == true) {
            if (z >= 350) {
                z -= 50;
                p = 200;
            } else {
                moveleft = false;
            }
        }
         if (reset == true) {
            if (z >= 350) {
                z -= 200;
                p = 200;
            } else {
                reset = false;
            }
        }
       
        repaint();
    }

    public void moveRight() {
        moveright = true;
    }

    public void move() {
        move = true;
    }

    public void move1() {
        move1 = true;
    }

    public void move2() {
        move2 = true;
    }

    public void move3() {
        move3 = true;
    }

    public void move4() {
        move4 = true;
    }

    public void moveLeft() {
        moveleft = true;
    }

    public void edit(String name) {

        controller.edit(name);
    }

    /*    public void remove (String name){
        controller.remove(name);
    }*/
    public void right() {
        controller.doMove(blist, moveright);
    }

    public int getZ() {
        return z;
    }

    /* public void setZ(int z) {
        this.z = z;
    }*/
    public void change(boolean x) {
//        controller.change(x);
    }

    void position(boolean b) {
        controller.position(b);
    }

   public void save() {
        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();
            Element root = doc.createElement("Icrossers");
            doc.appendChild(root);
            Attr attrType = doc.createAttribute("type");
            Element leftarraElement = doc.createElement("leftarray");
            Element right = doc.createElement("rlist");
            //right.getElementsByTagName("");
            //right.getChildNodes();
            
            root.appendChild(right);
            Element boatcrosser = doc.createElement("blist");
            root.appendChild(boatcrosser);
            Element boat = doc.createElement("boatposition");
            root.appendChild(boat);
            Element Story = doc.createElement("story");
            root.appendChild(Story);
            Element Score = doc.createElement("score");
            root.appendChild(Score);
            String x = Integer.toString(controller.moves());
            Score.appendChild(doc.createTextNode(x));

            Element position = doc.createElement("postion");

            if (controller.isBoatOnTheLeftBank() == true) {
                position.appendChild(doc.createTextNode("left"));
            } else {
                position.appendChild(doc.createTextNode("right"));
            }
            root.appendChild(position);
            if (story1 instanceof Story1) {
                Story.appendChild(doc.createTextNode("Story1"));
            } else {
                Story.appendChild(doc.createTextNode("Story2"));
            }

            for (int i = 0; i < llist.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (llist.get(i) instanceof Carnivore) {
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (llist.get(i) instanceof Harbivore) {

                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (llist.get(i) instanceof Plant) {

                    cname.appendChild(doc.createTextNode("Plant"));
                } else if (llist.get(i) instanceof Farmer) {

                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (llist.get(i) instanceof Farmer3) {

                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (llist.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (llist.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                }

                leftarraElement.appendChild(cname);
            }
                        root.appendChild(leftarraElement);

            for (int i = 0; i < rlist.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (rlist.get(i) instanceof Carnivore) {
                    //cname.setValue("Carnivore");
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (rlist.get(i) instanceof Harbivore) {
                    //attrType.setValue("Harbivore");
                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (rlist.get(i) instanceof Plant) {
                    //attrType.setValue("Plant");
                    cname.appendChild(doc.createTextNode("Plant"));
                } else if (rlist.get(i) instanceof Farmer) {
                    //attrType.setValue("Farmer");
                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (rlist.get(i) instanceof Farmer3) {
                    // attrType.setValue("Farmer3");
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (rlist.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (rlist.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                }
                right.appendChild(cname);
            }
            for (int i = 0; i < blist.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (blist.get(i) instanceof Carnivore) {
                    //cname.setValue("Carnivore");
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (blist.get(i) instanceof Harbivore) {
                    //attrType.setValue("Harbivore");
                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (blist.get(i) instanceof Plant) {
                    //attrType.setValue("Plant");
                    cname.appendChild(doc.createTextNode("Plant"));
                } else if (blist.get(i) instanceof Farmer) {
                    //attrType.setValue("Farmer");
                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (blist.get(i) instanceof Farmer3) {
                    // attrType.setValue("Farmer3");
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (blist.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (blist.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                }
                boatcrosser.appendChild(cname);
            }
            Element cname = doc.createElement("score");
            int moves=controller.moves()-1;
            String move=Integer.toString(moves);
             cname.appendChild(doc.createTextNode(move));
            cname = doc.createElement("position");
            boolean f=controller.isBoatOnTheLeftBank();
            if(f==true)
            cname.appendChild(doc.createTextNode("left"));
            else 
              cname.appendChild(doc.createTextNode("right"));   
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("crossriver.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     public void toreset(){
   
      reset();
      position(true);
 }
      public void reset() {
        reset = true;
    }
   public void drawing(){
       draw=controller.drawing();
       
      if(draw==true){
          moveLeft() ;
        position(true);}
      else{
        moveRight();
        position(false);
      }
   }
}
