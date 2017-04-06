import julia.JuliaFractalCreator;
import number.Complex;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        File file=new File("img//test.jpg");
//        Complex c=new Complex(  -0.123, 0.745);
//       JuliaFractalCreator gen=new JuliaFractalCreator(1000,1000);
//        BufferedImage bufferedImage = gen.generateFractal(c);
//        try {
//            ImageIO.write(bufferedImage, "jpg", file);
//        }catch (IOException e){
//            System.err.println(e);
//        }
        Complex c;
        File file = null;
        BufferedImage bufferedImage = null;
        String name = "img//fractal c=";
        String finish;
        JuliaFractalCreator gen = new JuliaFractalCreator(1600, 900);
        for (double i = -1; i <= 1; i += 0.1) {
            for (double j = -1; j <= 1; j += 0.1) {
                c = new Complex(-0.390541,  0.586788);
                finish=name + i + "+" + j + "i.jpg";
                file = new File(finish);
                bufferedImage = gen.generateFractal(c);
                try {
                    ImageIO.write(bufferedImage, "jpg", file);
                    System.out.println(finish);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
