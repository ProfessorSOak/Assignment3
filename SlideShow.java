import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JComponent;

public class SlideShow extends Presenter {

    private PictureComponent pictureComponent;
    private int index = 0;
    File[] imageFiles;
    String[] texts;
    private int size;

    public SlideShow(File[] imageFiles, String[] texts) {
        // read and remember (create instance variables)
        this.imageFiles = imageFiles;
        this.texts = texts;
        size = imageFiles.length;
        // images from the indicated files
        // and also remember texts in an instance field
    }

    @Override
    public JComponent createCenterComponent() {
        // create picture Component
        pictureComponent = new PictureComponent();
        // you may want to create a class for that
        // (class PictureComponent extends JComponent { ... } )
        return pictureComponent;
    }

    @Override
    public void eastButtonPressed() {
        // make pictureComponent display the next picture
        index++;
        if(index == size){
            index = 0;
        }
        pictureComponent.getPicture(imageFiles[index]);
        showText(texts[index]);
        // call showText(...) to update the text associated with picture
        // one possible way of drawing images is
        // in paintComponent
        // BufferedImage image = ImageIO.read(<File object>);
        // Graphics2D g2 = (Graphics2D)g;
        // g2.drawImage(image, null, <posX>, <posY>);
        // Google will give details
    }

    @Override
    public void westButtonPressed() {
        // same as for east button, but for previous picture
        index--;
        if(index == -1){
            index = size-1;
        }
        pictureComponent.getPicture(imageFiles[index]);
        showText(texts[index]);
    }

    @Override
    public void southButtonPressed() {
    }

    @Override
    public void northButtonPressed() {
    }

    public void FirstPicture(){

        showText(texts[index]);
        pictureComponent.getPicture(imageFiles[index]);
    }

    public static void main(String[] args) {
        SlideShow app = new SlideShow(
                new File[] { new File("C:\\Users\\hugos\\IdeaProjects\\Slideshow\\src\\WHOPPER.png"), new File("C:\\Users\\hugos\\IdeaProjects\\Slideshow\\src\\star-wars-memes-23-1.jpg"), new File("C:\\Users\\hugos\\IdeaProjects\\Slideshow\\src\\BREW.jpg"), new File("C:\\Users\\hugos\\IdeaProjects\\Slideshow\\src\\Luke.png"), new File("C:\\Users\\hugos\\IdeaProjects\\Slideshow\\src\\GORDON.jpg")},
                new String[] {"Finally", "Point_to_face.exe", "mmmmmmmmmmmmmmmmmmmmmmmmm", "ShootingFace", "WHERE'S THE LAMB SAUCE?"});
        app.FirstPicture();
    }
}
