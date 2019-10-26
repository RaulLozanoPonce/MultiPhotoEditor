package multiphotoeditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Board extends JPanel{
    
    private BufferedImage image;
    
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
    
    public int getImageWidth(){
        return image.getWidth();
    }
    
    public int getImageHeight(){
        return image.getHeight();
    }

    void setImage(BufferedImage image) {
        this.image = image;
    }
}
