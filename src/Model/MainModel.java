package Model;

import Management.ProjectManager;

import java.util.ArrayList;

public class MainModel {
    ArrayList<Project> projectsList;
    ArrayList<Student> studentList;
    ArrayList<Team> teamList;
    ProjectManager projectManager;

    public MainModel() {
    }

    public MainModel(ArrayList<Project> projectsList, ArrayList<Student> studentList, ArrayList<Team> teamList) {
        this.projectsList = projectsList;
        this.studentList = studentList;
        this.teamList = teamList;
    }

    public ArrayList<Project> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(ArrayList<Project> projectsList) {
        this.projectsList = projectsList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }
}
