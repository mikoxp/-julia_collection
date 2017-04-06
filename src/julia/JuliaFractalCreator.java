package julia;

import image.ConverterHSVtoRGB;
import image.RGB;
import number.Complex;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 05.04.2017.
 * @author moles
 */
public class JuliaFractalCreator {
    private ConverterHSVtoRGB converter;
    private Complex p;
    private int height;
    private int width;
    private static final int MAX_VALUE=120;

    public JuliaFractalCreator(int width,int height) {
        this.height = height;
        this.width = width;
        converter=new ConverterHSVtoRGB();
    }

    /**
     *
     * @param c c
     * @param p p
     * @return pixel hsv value
     */
    private int calculateValue(Complex c,Complex p){
        int value=-1;
        Complex z=new Complex(p);
        do{
        value++;
        z.powSquare();
        z.sumAdd(c);
        }while(conditionalExpression(z,value));
        return value;
    }

    /**
     *
     * @param c c
     * @param valueInt value
     * @return is finish
     */
    private boolean conditionalExpression(Complex c,int valueInt){
        boolean value;
        double i=c.getReal()*c.getReal()+c.getImaginary()*c.getImaginary();
        if((i<4)&&valueInt<MAX_VALUE){
            return true;
        }
            return false;
    }

    /**
     * fractal generator
     * @param c c
     * @return image
     */
    public BufferedImage generateFractal(Complex c){
        BufferedImage bufferedImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        p=new Complex(-1.5,-1.25);
        double pom=p.getImaginary();
        int colorValue;
        RGB rgb;
        Complex r=new Complex(3.0/width,2.5/height);
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                colorValue=calculateValue(c,p);
                if(colorValue>120){
                    System.out.println(colorValue);
                }
                rgb=converter.getColor((int)(3*colorValue));
                bufferedImage.setRGB(i,j,rgb.getColor().getRGB());
                p.setImaginary(p.getImaginary()+r.getImaginary());
            }
            p.setReal(p.getReal()+r.getReal());
            p.setImaginary(pom);
        }
        return bufferedImage;
    }
}
