
package Gui;

import Crossers.Carnivore;
import Crossers.Farmer;
import Crossers.Farmer2;
import Crossers.Farmer3;
import Crossers.Farmer4;
import Crossers.Harbivore;
import Crossers.Plant;
import Crossers.Story1;
import java.io.File;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;

/**
 *
 * @author HossamRezk
 */
/*public class Xml {
    
   // public static final String xmlFilePath = "C:\\Users\\HossamRezk\\Desktop\\Song\\story\\AMIRA1111\\xmlfile.xml";
    
    public void save(){
        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = (Document) build.newDocument();

        Element root = doc.createElement("Icrossers");
        doc.appendChild(root);
        Attr attrType = doc.createAttribute("type");
        Element leftarraElement = doc.createElement("leftarray");
        root.appendChild(leftarraElement);
        Element right = doc.createElement("rightarray");
        root.appendChild(right);
        Element boatcrosser = doc.createElement("boatriders");
        root.appendChild(boatcrosser);
        Element boat = doc.createElement("boatposition");
        root.appendChild(boat);
        Element Story= doc.createElement("story");
        root.appendChild(Story);
        Element Score= doc.createElement("score");
        root.appendChild(Score);
        String x=Integer.toString(getNumberOfSails());
        Score.appendChild(doc.createTextNode(x));
        
        
        Element position = doc.createElement("postion");
        
            if (left==true) {
                position.appendChild(doc.createTextNode("left"));
            }
            else{
                position.appendChild(doc.createTextNode("right"));}
            root.appendChild(position);
            if(s instanceof  Story1){
                 Story.appendChild(doc.createTextNode("Story1"));
            }
            else  Story.appendChild(doc.createTextNode("Story2"));
            
        
        for (int i = 0; i < leftarr.size(); i++) {
            Element cname = doc.createElement("Crosser");
             if (leftarr.get(i) instanceof Carnivore) {
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (leftarr.get(i) instanceof Harbivore) {
                    
                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (leftarr.get(i) instanceof Plant) {
                    
                     cname.appendChild(doc.createTextNode("Plant"));
                } else if (leftarr.get(i) instanceof Farmer) {
                    
                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (leftarr.get(i) instanceof Farmer3) {
                   
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (leftarr.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (leftarr.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (leftarr.get(i) instanceof Farmer5) {
                    cname.appendChild(doc.createTextNode("Farmer5"));
                }
            
             leftarraElement.appendChild(cname);
        }
        for (int i = 0; i < rightarr.size(); i++) {
            Element cname = doc.createElement("Crosser");
             if (rightarr.get(i) instanceof Carnivore) {
                    //cname.setValue("Carnivore");
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (rightarr.get(i) instanceof Harbivore) {
                    //attrType.setValue("Harbivore");
                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (rightarr.get(i) instanceof Plant) {
                    //attrType.setValue("Plant");
                     cname.appendChild(doc.createTextNode("Plant"));
                } else if (rightarr.get(i) instanceof Farmer) {
                    //attrType.setValue("Farmer");
                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (rightarr.get(i) instanceof Farmer3) {
                   // attrType.setValue("Farmer3");
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (rightarr.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (rightarr.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (rightarr.get(i) instanceof Farmer5) {
                    cname.appendChild(doc.createTextNode("Farmer5"));
                }
            
             right.appendChild(cname);
        }
        for (int i = 0; i < boatriders.size(); i++) {
            Element cname = doc.createElement("Crosser");
             if (boatriders.get(i) instanceof Carnivore) {
                    //cname.setValue("Carnivore");
                    cname.appendChild(doc.createTextNode("Carnivore"));
                } else if (boatriders.get(i) instanceof Harbivore) {
                    //attrType.setValue("Harbivore");
                    cname.appendChild(doc.createTextNode("Harbivore"));
                } else if (boatriders.get(i) instanceof Plant) {
                    //attrType.setValue("Plant");
                     cname.appendChild(doc.createTextNode("Plant"));
                } else if (boatriders.get(i) instanceof Farmer) {
                    //attrType.setValue("Farmer");
                    cname.appendChild(doc.createTextNode("Farmer"));
                } else if (boatriders.get(i) instanceof Farmer3) {
                   // attrType.setValue("Farmer3");
                    cname.appendChild(doc.createTextNode("Farmer3"));
                } else if (boatriders.get(i) instanceof Farmer2) {
                    cname.appendChild(doc.createTextNode("Farmer2"));
                } else if (boatriders.get(i) instanceof Farmer4) {
                    cname.appendChild(doc.createTextNode("Farmer4"));
                } else if (boatriders.get(i) instanceof Farmer5) {
                    cname.appendChild(doc.createTextNode("Farmer5"));
                }
            
             boatcrosser.appendChild(cname);
        }
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
}*/
