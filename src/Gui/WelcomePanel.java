package Gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel implements ActionListener{
     Graphics g;

      public WelcomePanel() {
       
    }
      protected void paintComponent(Graphics g) {
                //this.g=g;

        super.paintComponent(g);
        ImageIcon im = null;
         im = new ImageIcon("welcome.jpeg");
          g.drawImage(im.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
      }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
