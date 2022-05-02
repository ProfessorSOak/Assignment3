import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureComponent extends JComponent {
    File picture;

    PictureComponent(){
        super();
    }

    public void paintComponent(Graphics g)  {

        if(picture == null){
            return;
        }

        BufferedImage image = null;
        try {
            image = ImageIO.read(picture);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(image,null, 0, 0);
    }

    public void getPicture(File pic){
        picture = pic;
        repaint();
    }
}
