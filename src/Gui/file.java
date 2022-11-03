package Gui;


import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class file {

   public static void main(String[] args) {

      try {
         File inputFile = new File("crossriver.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList bList = doc.getElementsByTagName("blist");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < bList.getLength(); temp++) {
          //   System.out.println("LENGHTTBOATT      "+bList.);
       
             Node nNode = bList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
              for(int i=0;i<eElement.getElementsByTagName("Crosser").getLength();i++){
                 System.out.println("First Name : " + eElement.getElementsByTagName("Crosser").item(i).getTextContent());
                
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
                     System.out.println("ANAPLANT");
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
                
              }
            }
         }
          NodeList position = doc.getElementsByTagName("postion");
           System.out.println("----------------------------");
           Node nNode4 = position.item(0);
            System.out.println("ANAA MAKAN : " +nNode4.getTextContent());
           
         NodeList score = doc.getElementsByTagName("score");
           System.out.println("----------------------------");
           Node nNode1 = score.item(0);
            System.out.println("ANAA SCORE : " +nNode1.getTextContent());
          
         // count=Integer.parseInt(nNode1.getTextContent());
            
        
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}