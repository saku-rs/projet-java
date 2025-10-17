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
    public int getFirstop() {
        return firstop;
    }
    public String getOperateur() {
        return operateur;
    }
    public int getSecondop() {
        return secondop;
    }
}
