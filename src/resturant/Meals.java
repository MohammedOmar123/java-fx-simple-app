
package resturant;
public class Meals {
    private int numM;
    private String nameM;
    private String typeM;
    private double costM;
    public Meals(int numM, String nameM, String typeM, double costM) {
        this.numM = numM;
        this.nameM = nameM;
        this.typeM = typeM;
        this.costM = costM;
    }
    public int getNumM() {
        return numM;
    }
    public void setNumM(int numM) {
        this.numM = numM;
    }
    public String getNameM() {
        return nameM;
    }
    public void setNameM(String nameM) {
        this.nameM = nameM;
    }
    public String getTypeM() {
        return typeM;
    }
    public void setTypeM(String typeM) {
        this.typeM = typeM;
    }
    public double getCostM() {
        return costM;
    }
    public void setCostM(double costM) {
        this.costM = costM;
    }
}
