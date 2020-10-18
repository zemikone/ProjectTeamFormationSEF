package Management;

import Main.TeamFormationMain;
import Model.Project;
import Model.Student;
import Model.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientRep {

    ArrayList<Project> projectsList;
    ArrayList<Student> studentList;
    ArrayList<Team> teamList;

    public ClientRep(ArrayList<Project> projectsList, ArrayList<Student> studentList, ArrayList<Team> teamList) {
        this.projectsList = projectsList;
        this.studentList = studentList;
        this.teamList = teamList;
    }


    public void addRoles() throws Exception {
        if (projectsList.size() == 0) {
            System.out.println("Please add Projects File First!");
        } else {

            String roleID = "";
            String  selectedProjId = "";
            Project  selectedProj = null;


            // select project
            Boolean isIdMatched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Project you wish to add select Roles");
                System.out.println("++++Projects List++++");
                System.out.println(" ID");
                System.out.println(" --");
                for (Project project : projectsList) {
                    System.out.println(" " + project.getpId());
                }
                try {
                     selectedProjId = keyboard.nextLine();
                    for (Project project : projectsList) {
                        if (project.getpId().equals( selectedProjId)) {
                            isIdMatched = true;
                             selectedProj =project;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Project ID");
                }
                if (isIdMatched == false)
                    System.out.println("Sorry, please enter Project ID in the Projects List");
            } while (isIdMatched == false);


            boolean isBack=false;
            String yesOrNo = "";

            do {
                if( selectedProj.getRoles().size()<4) {
                    Scanner keyboard = new Scanner(System.in);
                    Boolean isConfIdMatched = false;
                    System.out.println("Do you want to add a Role for the Project " +  selectedProjId);
                    System.out.println(" Y - Yes");
                    System.out.println(" N - No");
                    yesOrNo = keyboard.nextLine();
                    if (yesOrNo.equalsIgnoreCase("Y")) {
                        yesOrNo = "";
                        do {
                            System.out.println("Please enter the ID of the Role you wish to add or enter B to go back.");
                            System.out.println("++++Roles++++");
                            System.out.println("ID Role");
                            System.out.println("-- ----");
                            System.out.println("R1.Programmer");
                            System.out.println("R2.Database Administrator");
                            System.out.println("R3.Leader");
                            System.out.println("R4.UI Designer");

                            try {
                                roleID = keyboard.nextLine();
                                if (!roleID.equalsIgnoreCase("b")) {
                                    if (roleID.equals("R1")
                                            || roleID.equals("R2")
                                            || roleID.equals("R3")
                                            || roleID.equals("R4")) {
                                        isConfIdMatched = true;
                                         selectedProj.getRoles().add(roleID);
                                        System.out.println("Project "+roleID+ " added as a Preferred Role");
                                        TeamFormationMain.generateProjectsFile(projectsList);
                                    } else {
                                        System.out.println("Sorry, please enter valid Role ID");
                                    }

                                } else {
                                    isConfIdMatched = true;
                                }
                            } catch (Exception e) {
                                System.out.println("Sorry, please enter valid Role ID");
                            }
                            if (isConfIdMatched == false)
                                System.out.println("Sorry, please enter Role ID in the Roles List");
                        } while (isConfIdMatched == false);
                    } else if (yesOrNo.equalsIgnoreCase("N")) {
                        isBack = true;

                    } else {
                        System.out.println("Sorry, please enter valid input Y or N");
                    }

                }else{
                    System.out.println("This Project has 4 Preferred Roles");
                    TeamFormationMain.manageProject();
                }
            } while (isBack == false);

        }
    }

    public void addFrameworks() throws Exception {
        if (projectsList.size() == 0) {
            System.out.println("Please add Projects File First!");
        } else {

            String roleID = "";
            String  selectedProjId = "";
            Project  selectedProj = null;


            // select project
            Boolean isIdMatched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Project you wish to add select Frameworks");
                System.out.println("++++Projects List++++");
                System.out.println(" ID");
                System.out.println(" --");
                for (Project project : projectsList) {
                    System.out.println(" " + project.getpId());
                }
                try {
                    selectedProjId = keyboard.nextLine();
                    for (Project project : projectsList) {
                        if (project.getpId().equals( selectedProjId)) {
                            isIdMatched = true;
                            selectedProj =project;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Project ID");
                }
                if (isIdMatched == false)
                    System.out.println("Sorry, please enter Project ID in the Projects List");
            } while (isIdMatched == false);


            boolean isBack=false;
            String yesOrNo = "";

            do {
                if( selectedProj.getFrameworks().size()<4) {
                    Scanner keyboard = new Scanner(System.in);
                    Boolean isConfIdMatched = false;
                    System.out.println("Do you want to add a Framework for the Project " +  selectedProjId);
                    System.out.println(" Y - Yes");
                    System.out.println(" N - No");
                    yesOrNo = keyboard.nextLine();
                    if (yesOrNo.equalsIgnoreCase("Y")) {
                        yesOrNo = "";
                        do {
                            System.out.println("Please enter the ID of the Framework you wish to add or enter B to go back.");
                            System.out.println("++++Frameworks++++");
                            System.out.println("ID Framework");
                            System.out.println("-- ----");
                            System.out.println("F1.Java");
                            System.out.println("F2.Oracle");
                            System.out.println("F3.C++");
                            System.out.println("F4.Android");
                            System.out.println("F5.ios");
                            System.out.println("F6.Python");

                            try {
                                roleID = keyboard.nextLine();
                                if (!roleID.equalsIgnoreCase("b")) {
                                    if (roleID.equals("F1")
                                            || roleID.equals("F2")
                                            || roleID.equals("F3")
                                            || roleID.equals("F4")
                                            || roleID.equals("F5")
                                            || roleID.equals("F6")) {
                                        isConfIdMatched = true;
                                        selectedProj.getFrameworks().add(roleID);
                                        System.out.println("Framework "+roleID+ " added to the Project");
                                        TeamFormationMain.generateProjectsFile(projectsList);
                                    } else {
                                        System.out.println("Sorry, please enter valid Framework ID");
                                    }

                                } else {
                                    isConfIdMatched = true;
                                }
                            } catch (Exception e) {
                                System.out.println("Sorry, please enter valid Framework ID");
                            }
                            if (isConfIdMatched == false)
                                System.out.println("Sorry, please enter Role ID in the Framework List");
                        } while (isConfIdMatched == false);
                    } else if (yesOrNo.equalsIgnoreCase("N")) {
                        isBack = true;

                    } else {
                        System.out.println("Sorry, please enter valid input Y or N");
                    }

                }else{
                    System.out.println("This Project has 4 Preferred Frameworks");
                    TeamFormationMain.manageProject();
                }
            } while (isBack == false);

        }
    }
}
