package Main;

import Management.ProjectModules;
import Management.ProjectManager;
import Management.StudentRep;
import Management.TeamFormation;
import Model.Project;
import Model.Student;
import Model.Team;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamFormationMain extends Application {


    public static ArrayList<Project> projectsList = new ArrayList();
    public static ArrayList<Student> studentList = new ArrayList();
    public static ArrayList<Team> teamList = new ArrayList();
    public static ProjectManager projectManager;
    public static StudentRep studentRep;
    public static ProjectModules clientRep;
    public static int constWorkExp =4;
    public static int constPersonality =4;
    private static Scanner scanIn = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Read Projects Text File and Save Data to a ArrayList
        readProjectsFile();
        readStudentsFile();
        readTeamsFile();
        readConstraintsFile();
        showMainMenu();
    }

    public static void main(String[] args) throws Exception {
        launch(args);

    }

    public static void showMainMenu() throws Exception{
        int option;
        projectManager = new ProjectManager(projectsList,studentList,teamList);
        studentRep = new StudentRep(projectsList,studentList,teamList);
        clientRep = new ProjectModules(projectsList,studentList,teamList);
        do {
            option = showMenu();
            switch (option) {
                case 1:
                    manageStudent();
                    break;
                case 2:
                    manageProject();
                    break;
                case 3:
                    projectManager.shortlistProjects();
                    break;
                case 4:
                    TeamFormation.formTeams();
                    break;
                case 5:
                    ProjectManager.averageCompetency();
                    break;
                case 6:
                    ProjectManager.skillsShortfall();
                    break;
                case 7:
                    projectManager.swapMembers();
                    break;
                case 8:
                    System.out.println("Thank you. Good Bye.");
                    System.exit(0);
                default:
                    System.out.println("Sorry, please enter valid Option");
                    showMenu();
            }
        } while (option != 6);
    }
    public static int showMenu() {

        int option;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("  Main Menu:");
        System.out.println("*************************");
        System.out.println("1.Student Details");
        System.out.println("2.Project Details");
        System.out.println("3.Shortlist Projects");
        System.out.println("4.Form Teams");
        System.out.println("5.Average Skill Competency");
        System.out.println("6.Display Fitness metrics of the members with Skills shortfall");
        System.out.println("7.Swap Members and Display Team Fitness");
        System.out.println("8.Quit");
        System.out.println("*************************");
        System.out.println("Enter your choice:");
        try {
            option = keyboard.nextInt();
        } catch (Exception e) {
            return 9;
        }


        return option;

    }



    public static void manageStudent() throws Exception{
        int option;
        do {
            option = manageStudentMenu();
            switch (option) {
                case 1:
                    projectManager.addCompany();
                    break;
                case 2:
                    projectManager.addProjectOwner();
                    break;
                case 3:
                    projectManager.addProject();
                    break;
                case 4:
                    projectManager.addStudentPersonalities();
                    break;
                case 5:
                    projectManager.selectPrefProjects();
                    return;
                case 6:
                    projectManager.shortlistProjects();
                    return;
                case 7:
                    TeamFormationMain.showMainMenu();
                    return;
                default:
                    System.out.println("Sorry, please enter valid Option");
                    TeamFormationMain.showMainMenu();
            }
        } while (option != 7);
    }

    public static int manageStudentMenu() {

        int option;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("Students  Menu:");
        System.out.println("*************************");
        System.out.println("1.Add Company");
        System.out.println("2.Add Project Owner");
        System.out.println("3.Add Project");
        System.out.println("4.Capture Student Personalities");
        System.out.println("5.Add Student Preferences");
        System.out.println("6.Shortlist Projects");
        System.out.println("7.Back");
        System.out.println("*************************");
        System.out.println("Enter your choice:");
        try {
            option = keyboard.nextInt();
        } catch (Exception e) {
            return 3;
        }
        return option;

    }

    public static void manageProject() throws Exception{
        int option;
        do {
            option = manageProjectMenu();
            switch (option) {
                case 1:
                    clientRep.addRoles();
                    break;
                case 2:
                    clientRep.addFrameworks();
                    break;
                case 3:
                    TeamFormationMain.showMainMenu();
                    return;
                default:
                    System.out.println("Sorry, please enter valid Option");
                    TeamFormationMain.showMainMenu();
            }
        } while (option != 6);
    }

    public static int manageProjectMenu() {

        int option;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("Manage Project Menu:");
        System.out.println("*************************");
        System.out.println("1.Add Roles");
        System.out.println("2.Add Frameworks");
        System.out.println("3.Back");
        System.out.println("*************************");
        System.out.println("Enter your choice:");
        try {
            option = keyboard.nextInt();
        } catch (Exception e) {
            return 3;
        }
        return option;

    }




    public static void readProjectsFile()  throws Exception{
        int rowCount = 0;
        String inputLine = "";
        int i = 0;

        try {
            Project project = null;
            for (scanIn = new Scanner(new BufferedReader(new FileReader("projects.txt"))); scanIn.hasNextLine(); ++rowCount) {
                inputLine = scanIn.nextLine();
                switch (i) {
                    case 0:
                        project = new Project();
                        project.setName(inputLine);
                        i++;
                        break;
                    case 1:
                        project.setpId(inputLine);
                        i++;
                        break;
                    case 2:
                        if(!inputLine.equals("")) {
                            String[] inputArray = inputLine.split("\\s+");
                            if (inputArray.length != 0) {
                                for (String role : inputArray) {
                                    project.getRoles().add(role);
                                }
                            }
                        }
                        i++;
                        break;
                    case 3:
                        if(!inputLine.equals("")) {
                            String[] inputArray2 = inputLine.split("\\s+");
                            if (inputArray2.length != 0) {
                                for (String framework : inputArray2) {
                                    project.getFrameworks().add(framework);
                                }
                            }
                        }
                        projectsList.add(project);
                        i = 0;
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            throw new NullPointerException("Some errors detected on the data in Projects file. please check the values of fileException is"+e);
        }
    }

    public static void readStudentsFile() throws Exception {
        int rowCount = 0;
        String inputLine = "";
        int i = 0;
        try {
            Student student =null;
            for (scanIn = new Scanner(new BufferedReader(new FileReader("students.txt"))); scanIn.hasNextLine(); ++rowCount) {
                inputLine = scanIn.nextLine();
                switch (i) {
                    case 0:
                        student = new Student();
                        student.setId(inputLine);
                        i++;
                        break;
                    case 1:
                        student.setName(inputLine);
                        i++;
                        break;
                    case 2:
//                        student.setProgramming(inputLine);
                        i++;
                        break;
                    case 3:
//                        student.setNetworking(inputLine);
                        i++;
                        break;
                    case 4:
//                        student.setWeb(inputLine);
                        i++;
                        break;
                    case 5:
//                        student.setAnalytics(inputLine);
                        i++;
                        break;
                    case 6:
                        if(!inputLine.equals("")) {
                            String[] inputArray = inputLine.split("\\s+");
                            if (inputArray.length != 0) {
                                for (String projId : inputArray) {
                                    student.getPrefProjects().add(projId);
                                }
                            }
                        }
                        i++;
                        break;
                    case 7:
                        if(!inputLine.equals("")) {
                            String[] inputArray1 = inputLine.split("\\s+");
                            if (inputArray1.length != 0) {
                                for (String role : inputArray1) {
                                    student.getRoles().add(role);
                                }
                            }
                        }
                        i++;
                        break;
                    case 8:
                        if(!inputLine.equals("")) {
                            String[] inputArray1 = inputLine.split("\\s+");
                            if (inputArray1.length != 0) {
                                for (String role : inputArray1) {
                                    student.getFrameworks().add(role);
                                }
                            }
                        }
                        i++;
                        break;
                    case 9:
                        if(!inputLine.equals("")) {
                            String[] inputArray2 = inputLine.split("\\s+");
                            if (inputArray2.length != 0) {
                                for (String unMem : inputArray2) {
                                    student.getUnlikeMemb().add(unMem);
                                }
                            }
                        }
                        studentList.add(student);
                        i = 0;
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            throw new NullPointerException("Some errors detected on the data in Students file. please check the values of fileException is"+e);
        }

    }

    public static void readTeamsFile() throws Exception {
        int rowCount = 0;
        int count = 0;
        String inputLine = "";
        int i = 0;

        try {
            Team team = null;
            for (scanIn = new Scanner(new BufferedReader(new FileReader("teams.txt"))); scanIn.hasNextLine(); ++rowCount) {
                inputLine = scanIn.nextLine();
                switch (i) {
                    case 0:
                        team = new Team();
                        team.setId(inputLine);
                        i++;
                        break;
                    case 1:
                        team.setProjId(inputLine);
                        i++;
                        break;
                    case 2:
                        String[] inputArray = inputLine.split("\\s+");
                        if (inputArray.length != 0) {
                            for(String member : inputArray){
                                team.getMembers().add(member);
                            }
                            teamList.add(team);
                        }
                        i = 0;
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            throw new NullPointerException("Some errors detected on the data in Teams file. please check the values of fileException is " + e);
        }

    }

    public static void generateStudentsFile(ArrayList<Student> studentsList) {
        try {
            StringBuilder builder = new StringBuilder();

            for (Student student : studentsList) {
                builder.append(student.getId() + "\n");
                builder.append(student.getName() + "\n");
                if(student.getPersonality()!=null) {
                    builder.append(student.getPersonality() + "\n");
                }else{
                    builder.append(" \n");
                }
                if(student.getGpa()!=null){
                    builder.append(student.getGpa() + "\n");
                }
                builder.append(student.getExpYears() + "\n");
//                builder.append(student.getProgramming() + "\n");
//                builder.append(student.getNetworking() + "\n");
//                builder.append(student.getWeb() + "\n");
//                builder.append(student.getAnalytics() + "\n");

                if(student.getPrefProjects()!=null){
                    for(String proj : student.getPrefProjects()) {
                        builder.append(proj + " ");
                    }
                    builder.append("\n");
                }else{
                    builder.append("\n");
                }
                if(student.getRoles()!=null){
                    for(String role : student.getRoles()) {
                        builder.append(role + " ");
                    }
                    builder.append("\n");
                }else{
                    builder.append("\n");
                }
                if(student.getFrameworks()!=null){
                    for(String role : student.getFrameworks()) {
                        builder.append(role + " ");
                    }
                    builder.append("\n");
                }else{
                    builder.append("\n");
                }
                if(student.getUnlikeMemb()!=null){
                    for(String mem : student.getUnlikeMemb()) {
                        builder.append(mem + " ");
                    }
                }else{
                    builder.append("\n");
                }
                builder.append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));
            writer.write(builder.toString());
            writer.close();
            System.out.println("students.txt generated!");
        } catch (Exception e) {
            System.out.println("file writing error : " + e);
        }

    }

    public static void generateProjectsFile(ArrayList<Project> projectsList) {
        try {
            StringBuilder builder = new StringBuilder();

            for (Project project : projectsList) {
                builder.append(project.getName() + "\n");
                builder.append(project.getpId() + "\n");
                if(project.getRoles()!=null){
                    for(String role : project.getRoles()) {
                        builder.append(role + " ");
                    }
                    builder.append("\n");
                }else{
                    builder.append("\n");
                }
                if(project.getFrameworks()!=null){
                    for(String frem : project.getFrameworks()) {
                        builder.append(frem + " ");
                    }
                }else{
                    builder.append("\n");
                }
                builder.append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("projects.txt"));
            writer.write(builder.toString());
            writer.close();
            System.out.println("projects.txt generated!");
        } catch (Exception e) {
            System.out.println("file writing error : " + e);
        }

    }

    public static void generateTeamsFile() {
        try {
            StringBuilder builder = new StringBuilder();

            for (Team team : teamList) {
                builder.append(team.getId() + "\n");
                builder.append(team.getProjId() + "\n");
                for(String member:team.getMembers()){
                    builder.append(member+ " ");
                }
                builder.append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("teams.txt"));
            writer.write(builder.toString());
            writer.close();
//            System.out.println("selections.txt generated!");
        } catch (Exception e) {
            System.out.println("file writing error : " + e);
        }

    }

    public static void generateConstraintsFile() {
        try {
            StringBuilder builder = new StringBuilder();

            builder.append(constPersonality + "\n");
            builder.append(constWorkExp + "\n");

            BufferedWriter writer = new BufferedWriter(new FileWriter("constraints.txt"));
            writer.write(builder.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("file writing error : " + e);
        }

    }

    public static void readConstraintsFile()  {
        int rowCount = 0;
        int count = 0;
        String inputLine = "";
        int i = 0;

        try {
            Team team = null;
            for (scanIn = new Scanner(new BufferedReader(new FileReader("constraints.txt"))); scanIn.hasNextLine(); ++rowCount) {
                inputLine = scanIn.nextLine();
                switch (i) {
                    case 0:
                        constPersonality = Integer.parseInt(inputLine);
                        i++;
                        break;
                    case 1:
                        constWorkExp = Integer.parseInt(inputLine);
                        i = 0;
                        break;
                    default:
                }
            }
        } catch (Exception e) {
//            throw new NullPointerException("Some errors detected on the data in Constraints file. please check the values of fileException is " + e);
        }

    }





}
