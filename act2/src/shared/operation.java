package shared   ;
import java.io.Serializable;

public class operation implements Serializable {
    private int firstop;
    private String operateur;   
    private int secondop;
    public operation(int firstop , String operateur , int secondop){ 
        this.firstop = firstop;
        this.operateur = operateur;
        this.secondop = secondop;
    }
    public int getA1() {
        return firstop;
    }
    public String getOp() {
        return operateur;
    }
    public int getA2() {
        return secondop;
    }
}
