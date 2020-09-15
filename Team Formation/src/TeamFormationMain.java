import Model.Project;
import Model.Student;
import Model.Team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamFormationMain {

    static ArrayList<Project> projectsList;
    static ArrayList<Student> studentList;
    static ArrayList<Team> teamList;
    private static Scanner scanIn = null;

    public static void main(String[] args) throws Exception {
        projectsList = new ArrayList();
        studentList = new ArrayList();
        teamList = new ArrayList();


        //Read Projects Text File and Save Data to a ArrayList
        readProjectsFile();
        readStudentsFile();
        readTeamsFile();
        shortlistProjects();
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
                        String[] inputArray = inputLine.split("\\s+");
                        if (inputArray.length != 0) {
                            for(String projId: inputArray){
                                student.getPrefProjects().add(projId);
                            }
                        }
                        i++;
                        break;
                    case 7:
                        String[] inputArray1 = inputLine.split(",");
                        if (inputArray1.length != 0) {
                            for(String role: inputArray1){
                                student.getRoles().add(role);
                            }
                        }
                        i++;
                        break;
                    case 8:
                        String[] inputArray2 = inputLine.split("\\s+");
                        if (inputArray2.length != 0) {
                            for(String unMem: inputArray2){
                                student.getUnlikeMemb().add(unMem);
                            }
                            studentList.add(student);
                        }
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

    public static void shortlistProjects() throws Exception {
        if (projectsList.size() >4) {
            for (Project project : projectsList) {
                String tempProjId = project.getpId();
                for(Student student: studentList){
                    for(String prefproj : student.getPrefProjects()){
                        if(prefproj.equals(tempProjId)){
                            project.setPrefCount(project.getPrefCount()+1);
                        }
                    }
                }
            }

            //Sorting the projects
            boolean sorted = false;
            Project temp;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < projectsList.size() - 1; i++) {
                    if (projectsList.get(i).getPrefCount() < projectsList.get(i + 1).getPrefCount()) {
                        temp = projectsList.get(i);
                        projectsList.set(i, projectsList.get(i + 1));
                        projectsList.set(i + 1, temp);
                        sorted = false;
                    }
                }
            }
//            To shortlist projects based on no of students
//            int noProjects = studentList.size()/4;

            //Remove the rest of the projects keeping the most prefered ones
            ArrayList<Project> tempProjectsList = new ArrayList();
            for (int i = 0; i < 5; i++) {
                tempProjectsList.add(projectsList.get(i));
            }
            projectsList = tempProjectsList;

        }


        System.out.println("++++Project List++++");
        System.out.println(" ID     Project Title    Pref Count");
        System.out.println(" --     -------------    ----------");
        for (Project project : projectsList) {
            System.out.println(" " + project.getpId() + "     " + project.getName() + "    " + project.getPrefCount());
        }

        System.out.println("Projects have been Shortlisted Successfully!");


    }




}
