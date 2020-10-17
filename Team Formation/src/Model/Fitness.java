package Model;

public class Fitness {
    Double std;
    String projName ;
    Double value;


    public Fitness(Double std, String projName, Double value) {
        this.std = std;
        this.projName = projName;
        this.value = value;
    }

    public Fitness() {
    }

    public Double getStd() {
        return std;
    }

    public void setStd(Double std) {
        this.std = std;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
