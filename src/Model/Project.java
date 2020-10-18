package Model;

import java.util.ArrayList;

public class Project {
    String pId;
    String name;
    int prefCount;
    ArrayList<String> roles;
    ArrayList<String> frameworks;

    public Project() {
        roles = new ArrayList();
        frameworks = new ArrayList();
    }

    public Project(String pId, String name, ArrayList<String> roles, ArrayList<String> frameworks) {
        this.pId = pId;
        this.name = name;
        this.roles = roles;
        this.frameworks = frameworks;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public ArrayList<String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(ArrayList<String> frameworks) {
        this.frameworks = frameworks;
    }

    public int getPrefCount() {
        return prefCount;
    }

    public void setPrefCount(int prefCount) {
        this.prefCount = prefCount;
    }
}
