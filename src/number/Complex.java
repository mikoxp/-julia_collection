package number;

/**
 * Created by moles on 05.04.2017.
 * @author moles
 */
public class Complex {
    double real;
    double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex(double real) {
        this.real = real;
        this.imaginary = 0;
    }
    public Complex(Complex mark){
        this.real=mark.getReal();
        this.imaginary=mark.getImaginary();
    }
    public void powSquare(){
        double r=real*real-imaginary*imaginary;
        double i=2*real*imaginary;
        real=r;
        imaginary=i;
    }
    public void sumAdd(Complex a){
        real+=a.getReal();
        imaginary+=a.getImaginary();
    }
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }
}
