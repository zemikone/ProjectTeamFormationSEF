package Model;

import java.util.ArrayList;

public class Student {
    String sId;
    String name;
    String gender;
    String personality;
    String gpa;
    String expyears;
    ArrayList<String> prefprojects;
    ArrayList<String> roles;
    ArrayList<String> unlikemembers;

    public Student() {
        prefprojects = new ArrayList();
        roles = new ArrayList();
        unlikemembers = new ArrayList();
    }

    public Student(String pId, String name,String gender,String personality, String gpa, String expyears,ArrayList<String> prefprojects,ArrayList<String> roles) {
        this.sId = sId;
        this.name = name;
        this.gender = gender;
        this.personality = personality;
        this.gpa = gpa;
        this.expyears = expyears;
        this.prefprojects = prefprojects;
        this.roles = roles;
//        this.unlikemembers = unlikemembers;
    }

    public String getsId() {
        return sId;
    }


    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }


    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getPersonality() {
        return personality;
    }

    public void setgpa(String gpa) {
        this.gpa = gpa;
    }

    public String getGpa() {
        return gpa;
    }

    public void setexpyears(String expyears) {
        this.expyears = expyears;
    }

    public String getexpyears() {
        return expyears;
    }


    public ArrayList<String> getPrefprojects() {
        return prefprojects;
    }

    public void setPrefprojects(ArrayList<String> prefprojects) {
        this.prefprojects = prefprojects;
    }


    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

//    public ArrayList<String> getUnlikemembers() {
//        return unlikemembers;
//    }
//
//    public void setUnlikemembers(ArrayList<String> unlikemembers) {
//        this.unlikemembers = unlikemembers;
//    }
}
