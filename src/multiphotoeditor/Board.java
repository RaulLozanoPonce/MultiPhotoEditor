package multiphotoeditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Board extends JPanel{
    
    private final BufferedImage image;

    public Board(BufferedImage image) {
        this.image = image;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image != null){
            this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
            int x = image.getWidth() < getWidth() ? getImageX() : 0;
            int y = image.getHeight() < getHeight() ? getImageY() : 0;
            g.drawImage(image, x, y, this);
        }
    }
    
    private int getImageX(){
        return (getWidth() - image.getWidth())/2;
    }
    
    private int getImageY(){
        return (getHeight()- image.getHeight())/2;
    }
}
