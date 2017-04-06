package image;

/**
 * Created by moles on 2017-04-06.
 * @author moles
 */
public class ConverterHSVtoRGB {
    private static  double SAT=0.85;
    private static double VAL=0.6;
    private static int MAX=361;
    RGB[] colorValue;
    /**
     * constructor with inicializacoin colors
     */
    public ConverterHSVtoRGB() {
        initColor();
    }

    /**
     *
     * @param value val
     * @return rgb color
     */
    private RGB singleValue(double value){
//        if(VAL==0){
//            return new RGB(0,0,0);
//        }
        value/=60;
        int i=(int)value;
        double f=value-i;
        double p=value*(1-SAT);
        double q=VAL*(1-(SAT*f));
        double t=VAL*(1-(SAT*(1-f)));
        double r=0,g=0,b=0;
        switch (i){
            case 0:
                r=VAL;
                g=t;
                b=p;
                break;
            case 1:
                r=q;
                g=VAL;
                b=p;
                break;
            case 2:
                r=p;
                g=VAL;
                b=t;
                break;
            case 3:
                r=p;
                g=q;
                b=VAL;
                break;
            case 4:
                r=t;
                g=p;
                b=VAL;
                break;
            case 5:
                r=VAL;
                g=p;
                b=q;
                break;
             default:
                 break;
        }
        int nR=(int)(255*r);
        int nG=(int)(255*g);
        int nB=(int)(255*b);
        return new RGB(nR,nG,nB);
    }

    /**
     * init color
     */
    private void initColor(){
        colorValue=new RGB[MAX];
        for(int i=0;i<MAX;i++){
            colorValue[i]=singleValue(i);
        }
    }
    public RGB getColor(int number){
        return colorValue[number];
    }

}
