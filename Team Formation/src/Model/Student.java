package Model;

import java.util.ArrayList;

public class Student {
    String id;
    String name;
    String gender;
    String personality;
    Double gpa;
    int expYears;
    ArrayList<String> prefProjects;
    ArrayList<String> roles;
    ArrayList<String> frameworks;
    ArrayList<String> unlikeMemb;

    public Student() {
        prefProjects = new ArrayList();
        roles = new ArrayList();
        frameworks = new ArrayList();
        unlikeMemb = new ArrayList();
    }

    public Student(String id, String name, String gender, String personality, Double gpa, int expYears, ArrayList<String> prefProjects, ArrayList<String> roles, ArrayList<String> frameworks, ArrayList<String> unlikeMemb) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.personality = personality;
        this.gpa = gpa;
        this.expYears = expYears;
        this.prefProjects = prefProjects;
        this.roles = roles;
        this.frameworks = frameworks;
        this.unlikeMemb = unlikeMemb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public int getExpYears() {
        return expYears;
    }

    public void setExpYears(int expYears) {
        this.expYears = expYears;
    }

    public ArrayList<String> getPrefProjects() {
        return prefProjects;
    }

    public void setPrefProjects(ArrayList<String> prefProjects) {
        this.prefProjects = prefProjects;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public ArrayList<String> getUnlikeMemb() {
        return unlikeMemb;
    }

    public void setUnlikeMemb(ArrayList<String> unlikeMemb) {
        this.unlikeMemb = unlikeMemb;
    }

    public ArrayList<String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(ArrayList<String> frameworks) {
        this.frameworks = frameworks;
    }
}
