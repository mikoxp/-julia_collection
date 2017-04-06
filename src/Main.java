import julia.JuliaFractalCreator;
import number.Complex;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int size=1000;
        File file=new File("img//test.jpg");
        Complex c=new Complex(  -0.123, 0.745);
       JuliaFractalCreator gen=new JuliaFractalCreator(1000,1000);
        BufferedImage bufferedImage = gen.generateFractal(c);
        try {
            ImageIO.write(bufferedImage, "jpg", file);
        }catch (IOException e){
            System.err.println(e);
        }


    }
}
