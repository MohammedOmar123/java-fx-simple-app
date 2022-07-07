
package resturant;
public class Dranks {
    private int numD;
    private String nameD;
    private String typeD;
    private double costD;
    public Dranks(int numD, String nameD, String typeD, double costD) {
        this.numD = numD;
        this.nameD = nameD;
        this.typeD = typeD;
        this.costD = costD;
    }
    public int getNumD() {
        return numD;
    }

    public void setNumD(int numD) {
        this.numD = numD;
    }

    public String getNameD() {
        return nameD;
    }

    public void setNameD(String nameD) {
        this.nameD = nameD;
    }

    public String getTypeD() {
        return typeD;
    }

    public void setTypeD(String typeD) {
        this.typeD = typeD;
    }

    public double getCostD() {
        return costD;
    }

    public void setCostD(double costD) {
        this.costD = costD;
    }

}
