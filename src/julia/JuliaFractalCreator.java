package julia;

import number.Complex;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 05.04.2017.
 * @author moles
 */
public class JuliaFractalCreator {
    private BufferedImage bufferedImage;
    private Complex p;
    private int height;
    private int width;
    private static final int MAX_VALUE=255;

    public JuliaFractalCreator(int height, int width) {
        this.height = height;
        this.width = width;
    }
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
    private boolean conditionalExpression(Complex c,int valueInt){
        boolean value;
        if((c.getReal()*c.getReal()+c.getImaginary()*c.getImaginary()<4)&&valueInt<MAX_VALUE){
            return true;
        }
            return false;
    }
    public BufferedImage generateFractal(Complex c){
        BufferedImage bufferedImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
        p=new Complex(-1.5,-1.25);

        return bufferedImage;
    }
}
