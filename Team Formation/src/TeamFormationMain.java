import Model.Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamFormationMain {

    static ArrayList<Project> projectsList;
    private static Scanner scanIn = null;

    public static void main(String[] args) throws Exception {
        projectsList = new ArrayList();


        //Read Projects Text File and Save Data to a ArrayList
        readProjectsFile();
    }


    public static void readProjectsFile()  throws Exception{
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

}
