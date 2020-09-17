import Model.Project;
import Model.Student;
import Model.Team;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamFormationMain {

    static ArrayList<Project> projectsList;
    static ArrayList<Student> studentList;
    static ArrayList<Team> teamList;
    static ProjectManager projectManager;
    static StudentRep studentRep;
    private static Scanner scanIn = null;

    public static void main(String[] args) throws Exception {
        projectsList = new ArrayList();
        studentList = new ArrayList();
        teamList = new ArrayList();


        //Read Projects Text File and Save Data to a ArrayList
        readProjectsFile();
        readStudentsFile();
        readTeamsFile();
        showMainMenu();
    }


    public static void showMainMenu() throws Exception{
        int option;
        projectManager = new ProjectManager(projectsList,studentList,teamList);
        studentRep = new StudentRep(projectsList,studentList,teamList);
        do {
            option = showMenu();
            switch (option) {
                case 1:
                    manageStudent();
                    break;
                case 2:
                    projectManager.shortlistProjects();
                    break;
                case 3:
//                    addProject();
                    break;
                case 4:
                    projectManager.swapMembers();
                    break;
                case 5:
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
        System.out.println("1.Manage Student Details");
        System.out.println("2.Shortlist Projects");
        System.out.println("3.Form Teams");
        System.out.println("4.Display Team Fitness");
        System.out.println("5.Quit");
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
                        projectManager.addPersonality();
                        break;
                    case 2:
//                        calPercentagePref();
                        break;
                    case 3:
                        studentRep.selectRoles();
                        break;
                    case 4:
                        studentRep.selectUnlikeMem();
                        return;
                    case 5:
                        projectManager.changeGpa();
                        return;
                    case 6:
                        TeamFormationMain.showMainMenu();
                        return;
                    default:
                        System.out.println("Sorry, please enter valid Option");
                        TeamFormationMain.showMainMenu();
                }
            } while (option != 6);
    }

    public static int manageStudentMenu() {

        int option;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("Manage Student Menu:");
        System.out.println("*************************");
        System.out.println("1.Capture Student Personalities");
        System.out.println("2.Add Student Preferences");
        System.out.println("3.Add Preferred Roles");
        System.out.println("4.Select Members not Like to Work With");
        System.out.println("5.change GPA");
        System.out.println("6.Back");
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
                        String[] inputArray = inputLine.split("\\s+");
                        if (inputArray.length != 0) {
                            for(String role: inputArray){
                                project.getRoles().add(role);
                            }
                        }
                        i++;
                        break;
                    case 3:
                        String[] inputArray2 = inputLine.split("\\s+");
                        if (inputArray2.length != 0) {
                            for(String framework: inputArray2){
                                project.getFrameworks().add(framework);
                            }
                            projectsList.add(project);
                        }
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
                        student.setGender(inputLine);
                        i++;
                        break;
                    case 3:
                        student.setPersonality(inputLine);
                        i++;
                        break;
                    case 4:
                        student.setGpa(Double.parseDouble(inputLine));
                        i++;
                        break;
                    case 5:
                        student.setExpYears(Integer.parseInt(inputLine));
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
                builder.append(student.getGender() + "\n");
                if(student.getPersonality()!=null) {
                    builder.append(student.getPersonality() + "\n");
                }else{
                    builder.append(" \n");
                }
                if(student.getGpa()!=null){
                    builder.append(student.getGpa() + "\n");
                }
                builder.append(student.getExpYears() + "\n");

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






}
