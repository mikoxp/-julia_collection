import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int size=1000;
        File file=new File("test.jpg");
        BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        try {
            ImageIO.write(bufferedImage, "jpg", file);
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
