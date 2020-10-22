package Model;

public class Skills {
    Double std;
    String projName ;
    Double value;


    public Skills(Double std, String projName, Double value) {
        this.std = std;
        this.projName = projName;
        this.value = value;
    }

    public Skills() {
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
