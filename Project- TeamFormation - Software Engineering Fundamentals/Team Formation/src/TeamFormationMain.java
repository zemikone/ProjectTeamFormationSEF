import Model.Project;
import Model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class TeamFormationMain {

    static ArrayList<Project> projectsList;
    static ArrayList<Student> studentslist;
    private static Scanner scanIn = null;

    public static void main(String[] args) throws Exception {
        projectsList = new ArrayList();
        studentslist = new ArrayList();


        //Read Projects Text File and Save Data to a ArrayList
        readProjectsFile();
        readStudentsFile();
    }


    public static void readProjectsFile() throws Exception {
        int rowCount = 0;
        int count = 0;
        String inputLine = "";
        int i = 0;

        try {
            BufferedReader reader;
            for (reader = new BufferedReader(new FileReader("projects.txt")); reader.readLine() != null; ++count) {
            }

            reader.close();
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
                            for (String role : inputArray) {
                                project.getRoles().add(role);
                            }
                        }
                        i++;
                        break;
                    case 3:
                        String[] inputArray2 = inputLine.split("\\s+");
                        if (inputArray2.length != 0) {
                            for (String framework : inputArray2) {
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
            throw new NullPointerException("Some errors detected on the data in Projects file. please check the values of fileException is" + e);
        }
    }

    public static void readStudentsFile() throws Exception {
        int rowCount = 0;
        int columnCount = 0;
        String inputLine = "";
        int i = 0;
        int count = 0;

        try {
            BufferedReader reader;
            for (reader = new BufferedReader(new FileReader("students.txt")); reader.readLine() != null; ++count) {
            }

            reader.close();
            Student student = null;
            for (scanIn = new Scanner(new BufferedReader(new FileReader("students.txt"))); scanIn.hasNextLine(); ++rowCount) {
                inputLine = scanIn.nextLine();
                switch (i) {
                    case 0:
                        student = new Student();
                        student.setsId(inputLine);
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
                        student.setgpa(inputLine);
                        i++;
                        break;
                    case 5:
                        student.setexpyears(inputLine);
                        i++;
                        break;
                    case 6:
                        String[] inputArray = inputLine.split("\\s+");
                        if (inputArray.length != 0) {
                            for (String role : inputArray) {
                                student.getRoles().add(role);
                            }
                        }
                        i++;
                        break;
                    case 7:
                        String[] inputArray2 = inputLine.split("\\s+");
                        if (inputArray2.length != 0) {
                            for (String framework : inputArray2) {
                                student.getPrefprojects().add(framework);
                            }
                            studentslist().add(student);
                        }
                        i = 0;
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            throw new NullPointerException("Some errors detected on the data in StudntInfo file. please check the values of fileException is" + e);
        }
    }

    private static Collection<Student> studentslist() {
        return studentslist();
    }
}

