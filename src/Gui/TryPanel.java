package Gui;

import Controller.GameController;
import Controller.Lists;
import Crossers.Animal;
import Crossers.Carnivore;
import Crossers.Farmer;
import Crossers.Farmer1;
import Crossers.Farmer2;
import Crossers.Farmer3;
import Crossers.Farmer4;
import Crossers.Harbivore;
import Crossers.ICrosser;
import Crossers.IcrossingStrategy;
import Crossers.Plant;
import Crossers.Story2;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class TryPanel extends JPanel implements ActionListener{
     Graphics g;
    Farmer farmer = Farmer.getInstance();
    
    IcrossingStrategy str =new Story2();
    List<ICrosser> Boat = new ArrayList<>();
     List<ICrosser> cL = new ArrayList<>();
     boolean draw=true;
      private int mouseX,mouseY;
   // String name;
    Story2 story2 = new Story2();
  //  GameController controller = new GameController(this);
    GameController controller = GameController.getInstance();
    boolean left = true;
    int x = -10;
 private int z = 200;
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
    List<ICrosser> newList = new ArrayList<>();

    public TryPanel() {
        t.start();
        controller.newGame(story2);
    }
    List<ICrosser> llist = new ArrayList<>();
    List<ICrosser> rlist = new ArrayList<>();
    List<ICrosser> blist = new ArrayList<>();

    public List<ICrosser> getLlist()
    {
    return llist;
    }


    public void BoatRiders(ICrosser crosser) {
        Boat.add(crosser);
    }
    public  List<ICrosser> boatPassengers(){
        return blist;
    }

    @Override
    protected void paintComponent(Graphics g) {
                this.g=g;

        super.paintComponent(g);
     if(controller==null)
         return;
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
        p=200;
          BufferedImage lim[] = new BufferedImage[llist.size()];
        BufferedImage rim[] = new BufferedImage[rlist.size()];
        BufferedImage bim[] = new BufferedImage[blist.size()];
         Lists list = Lists.getList(str);
            llist = list.llist;
            //Lists list = Lists.getList();
            rlist = list.rlist;
            if(llist.size()>0){
        for (int i = 0; i <llist.size(); i++) {
            
                lim=llist.get(i).getImages();
                //BufferedImage h[] = new BufferedImage[4];
                //h = cL.get(i).getImages();
                Image image = lim[0];
                g.drawImage(image,llist.get(i).getPositionX(), 400, 150,150, this);
            
        }
        }//repaint();
        if(rlist.size()>0){
        for (int j = 0; j < rlist.size(); j++) {
           
                rim=rlist.get(j).getImages();
                //BufferedImage h1[] = new BufferedImage[4];
                //h1 = rlist.get(j).getImages();
                Image image = rim[0];
                g.drawImage(image, rlist.get(j).getPositionY(), 400, 150, 150, this);
            

        }
        }
        if(blist.size()>0){
        for (int k = 0; k < blist.size(); k++) {
            
                bim= blist.get(k).getImages();
                //BufferedImage h1[] = new BufferedImage[4];
                //bim = blist.get(k).getImages();
                Image image = bim[0];
                g.drawImage(image, z, 400, 150, 150, this);
            

        }}
      //repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // g.dispose();
        
       //removeAll(); 
        //repaint();
        if (moveright == true) {
            if (z <= 950) {
                z += 50;
              p=550;   
            } else {
                moveright = false;
            }
        }
        if(moveleft == true)
        {
            if(z>=300)
            {
                z-=50;
                p=200;
            }
            else{
                moveleft = false;
            }
        }
        if (reset == true) {
            if (z >= 300) {
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
   
   public void right(){
       controller.doMove(blist, moveright);
   }

    public int getZ() {
        return z;
    }

   /* public void setZ(int z) {
        this.z = z;
    }*/
    public void change(boolean x){
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
            if (story2 instanceof Story2) {
                Story.appendChild(doc.createTextNode("Story2"));
            } 

            for (int i = 0; i < llist.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (llist.get(i) instanceof Farmer1) {
                    cname.appendChild(doc.createTextNode("Farmer1"));
                } else if (llist.get(i) instanceof Farmer2) {

                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (llist.get(i) instanceof Farmer3) {

                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (llist.get(i) instanceof Farmer4) {

                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (llist.get(i) instanceof Animal) {

                    cname.appendChild(doc.createTextNode("Animal"));
                } /*else if (llist.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (llist.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                }*/

                leftarraElement.appendChild(cname);
            }
                        root.appendChild(leftarraElement);

            for (int i = 0; i < rlist.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (rlist.get(i) instanceof Farmer1) {
                    //cname.setValue("Carnivore");
                    cname.appendChild(doc.createTextNode("Farmer1"));
                } else if (rlist.get(i) instanceof Farmer2) {
                    //attrType.setValue("Harbivore");
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (rlist.get(i) instanceof Farmer3) {
                    //attrType.setValue("Plant");
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (rlist.get(i) instanceof Farmer4) {
                    //attrType.setValue("Farmer");
                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (rlist.get(i) instanceof Animal) {
                    // attrType.setValue("Farmer3");
                    cname.appendChild(doc.createTextNode("Animal"));
                } 
                right.appendChild(cname);
            }
            for (int i = 0; i < blist.size(); i++) {
                Element cname = doc.createElement("Crosser");
                if (blist.get(i) instanceof Farmer1) {
                    //cname.setValue("Carnivore");
                    cname.appendChild(doc.createTextNode("Farmer1"));
                } else if (blist.get(i) instanceof Farmer2) {
                    //attrType.setValue("Harbivore");
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (blist.get(i) instanceof Farmer3) {
                    //attrType.setValue("Plant");
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (blist.get(i) instanceof Farmer4) {
                    //attrType.setValue("Farmer");
                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (blist.get(i) instanceof Animal) {
                    // attrType.setValue("Farmer3");
                    cname.appendChild(doc.createTextNode("Animal"));
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
            StreamResult result = new StreamResult(new File("crossriverstory2.xml"));
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

