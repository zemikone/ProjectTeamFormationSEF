package Management;

import Main.TeamFormationMain;
import Model.Project;
import Model.Student;
import Model.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRep {

    ArrayList<Project> projectsList;
    ArrayList<Student> studentList;
    ArrayList<Team> teamList;

    public StudentRep(ArrayList<Project> projectsList, ArrayList<Student> studentList, ArrayList<Team> teamList) {
        this.projectsList = projectsList;
        this.studentList = studentList;
        this.teamList = teamList;
    }

    public void selectPrefProjects(){
        if (studentList.size() == 0) {
            System.out.println("Please add Students File First!");
        } else if(projectsList.size() == 0){
            System.out.println("Please add Projects!");
        }else{
            String studentId = "";
            Student selectedStudent = null;
            String prefId4 = "";
            String prefId3 = "";
            String prefId2 = "";
            String prefId1 = "";
//            Preferences preference = new Preferences();

            // select student
            Boolean isIdMatched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Student from below list to capture t" +
                        "he Student Preferences");
                System.out.println("++++Students List++++");
                System.out.println(" ID");
                System.out.println(" --");
                for (Student student : studentList) {
                    System.out.println(" " + student.getId());
                }
                try {
                    studentId = keyboard.nextLine();
                    for (Student student : studentList) {
                        if (student.getId().equals(studentId)) {
                            selectedStudent = student;
                            isIdMatched = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Student ID");
                }
                if (isIdMatched == false)
                    System.out.println("Sorry, please enter Student ID in the Students List");
            } while (isIdMatched == false);
//            preference.setPrfStdId(studentId);

            //Set Preference 4
            Boolean isPrefId4Matched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Project from below list to capture t" +
                        "he Student Preference 4 (Most Preference)");
                System.out.println("++++Project List++++");
                System.out.println(" ID     Project Name");
                System.out.println(" --     -------------");
                for (Project project : projectsList) {
                    System.out.println(" " + project.getpId() + "     " + project.getName());
                }
                try {
                    prefId4 = keyboard.nextLine();
                    for (Project project : projectsList) {
                        if (project.getpId().equals(prefId4)) {
                            isPrefId4Matched = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Project ID");
                }
                if (isPrefId4Matched == false)
                    System.out.println("Sorry, please enter Project ID in the Project List");
            } while (isPrefId4Matched == false);
            selectedStudent.getPrefProjects().set(0,prefId4);

            //Set Preference 3
            Boolean isPrefId3Matched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Project from below list to capture t" +
                        "he Student Preference 3");
                System.out.println("++++Project List++++");
                System.out.println(" ID     Project Name");
                System.out.println(" --     -------------");
                for (Project project : projectsList) {
                    System.out.println(" " + project.getpId() + "     " + project.getName());
                }
                try {
                    prefId3 = keyboard.nextLine();
                    for (Project project : projectsList) {
                        if (project.getpId().equals(prefId3)) {
                            isPrefId3Matched = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Project ID");
                }
                if (isPrefId3Matched == false)
                    System.out.println("Sorry, please enter Project ID in the Project List");
            } while (isPrefId3Matched == false);
            selectedStudent.getPrefProjects().set(1,prefId3);

            //Set Preference 2
            Boolean isPrefId2Matched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Project from below list to capture t" +
                        "he Student Preference 2");
                System.out.println("++++Project List++++");
                System.out.println(" ID     Project Name");
                System.out.println(" --     -------------");
                for (Project project : projectsList) {
                    System.out.println(" " + project.getpId() + "     " + project.getName());
                }
                try {
                    prefId2 = keyboard.nextLine();
                    for (Project project : projectsList) {
                        if (project.getpId().equals(prefId2)) {
                            isPrefId2Matched = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Project ID");
                }
                if (isPrefId2Matched == false)
                    System.out.println("Sorry, please enter Project ID in the Project List");
            } while (isPrefId2Matched == false);
            selectedStudent.getPrefProjects().set(2,prefId2);

            //Set Preference 1
            Boolean isPrefId1Matched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Project from below list to capture t" +
                        "he Student Preference 1 (Lowest Preference)");
                System.out.println("++++Project List++++");
                System.out.println(" ID     Project Name");
                System.out.println(" --     -------------");
                for (Project project : projectsList) {
                    System.out.println("   " + project.getpId() + "   " + project.getName());
                }
                try {
                    prefId1 = keyboard.nextLine();
                    for (Project project : projectsList) {
                        if (project.getpId().equals(prefId1)) {
                            isPrefId1Matched = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Project ID");
                }
                if (isPrefId1Matched == false)
                    System.out.println("Sorry, please enter Project ID in the Project List");
            } while (isPrefId1Matched == false);
            selectedStudent.getPrefProjects().set(3,prefId1);
        }
        TeamFormationMain.generateStudentsFile(studentList);
    }

    public void selectRoles() throws Exception {
        if (studentList.size() == 0) {
            System.out.println("Please add Students File First!");
        } else {

            String roleID = "";
            String selectedStdId = "";
            Student selectedStudent = null;


            // select student
            Boolean isIdMatched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Student you wish to add select Roles");
                System.out.println("++++Students List++++");
                System.out.println(" ID");
                System.out.println(" --");
                for (Student student : studentList) {
                    System.out.println(" " + student.getId());
                }
                try {
                    selectedStdId = keyboard.nextLine();
                    for (Student student : studentList) {
                        if (student.getId().equals(selectedStdId)) {
                            isIdMatched = true;
                            selectedStudent =student;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Student ID");
                }
                if (isIdMatched == false)
                    System.out.println("Sorry, please enter Student ID in the Students List");
            } while (isIdMatched == false);


            boolean isBack=false;
            String yesOrNo = "";

            do {
                if(selectedStudent.getRoles().size()<2) {
                    Scanner keyboard = new Scanner(System.in);
                    Boolean isConfIdMatched = false;
                    System.out.println("Do you want to add a Role for the Student " + selectedStdId);
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
                                        selectedStudent.getRoles().add(roleID);
                                        System.out.println("Student "+roleID+ " added as a Preferred Role");
                                        TeamFormationMain.generateStudentsFile(studentList);
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
                    System.out.println("This member has 2 Preferred Roles");
                    TeamFormationMain.manageStudent();
                }
            } while (isBack == false);

        }
    }

    public void selectUnlikeMem() throws Exception {
        if (studentList.size() == 0) {
            System.out.println("Please add Students File First!");
        } else {

            String personality = "";
            String studentId = "";
            String selectedStdId = "";
            Student selectedStudent = null;


            // select student
            Boolean isIdMatched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Student you wish to add the Conflicted Students");
                System.out.println("++++Students List++++");
                System.out.println(" ID");
                System.out.println(" --");
                for (Student student : studentList) {
                    System.out.println(" " + student.getId());
                }
                try {
                    studentId = keyboard.nextLine();
                    for (Student student : studentList) {
                        if (student.getId().equals(studentId)) {
                            isIdMatched = true;
                            selectedStudent =student;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Student ID");
                }
                if (isIdMatched == false)
                    System.out.println("Sorry, please enter Student ID in the Students List");
            } while (isIdMatched == false);
            selectedStdId = studentId;

            boolean isBack=false;
            String yesOrNo = "";

            do {
                if(selectedStudent.getUnlikeMemb().size()<3) {
                    Scanner keyboard = new Scanner(System.in);
                    Boolean isConfIdMatched = false;
                    System.out.println("Do you want to add a Conflicted student for Student " + selectedStdId);
                    System.out.println(" Y - Yes");
                    System.out.println(" N - No");
                    yesOrNo = keyboard.nextLine();
                    if (yesOrNo.equalsIgnoreCase("Y")) {
                        yesOrNo = "";
                        do {
                            System.out.println("Please enter the ID of the Student you wish to add as a Conflicted Student of " + selectedStdId + " or enter B to go back.");
                            System.out.println("++++Students List++++");
                            System.out.println(" ID");
                            System.out.println(" --");
                            for (Student student : studentList) {
                                System.out.println(" " + student.getId());
                            }
                            try {
                                studentId = keyboard.nextLine();
                                if (!studentId.equalsIgnoreCase("b")) {
                                    for (int i = 0; i < studentList.size(); i++) {
                                        if (studentList.get(i).getId().equals(studentId)) {
                                            isConfIdMatched = true;
                                            selectedStudent.getUnlikeMemb().add(studentId);
                                            System.out.println("Student "+studentId+ " added as a Conflicted Student!");
                                            TeamFormationMain.generateStudentsFile(studentList);
                                            break;
                                        }
                                    }
                                } else {
                                    isConfIdMatched = true;
//                                    isBack = true;
                                }
                            } catch (Exception e) {
                                System.out.println("Sorry, please enter valid Student ID");
                            }
                            if (isConfIdMatched == false)
                                System.out.println("Sorry, please enter Student ID in the Students List");
                        } while (isConfIdMatched == false);
                    } else if (yesOrNo.equalsIgnoreCase("N")) {
                        isBack = true;

                    } else {
                        System.out.println("Sorry, please enter valid input Y or N");
                    }

                }else{
                    System.out.println("This member has 3 Conflicted Students.");
                    TeamFormationMain.manageStudent();
                }
            } while (isBack == false);

        }


    }

    public void addFrameworks() throws Exception {
        if (studentList.size() == 0) {
            System.out.println("Please add Students File First!");
        } else {

            String roleID = "";
            String selectedStdId = "";
            Student selectedStudent = null;


            // select student
            Boolean isIdMatched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Student you wish to add select Frameworks");
                System.out.println("++++Students List++++");
                System.out.println(" ID");
                System.out.println(" --");
                for (Student student : studentList) {
                    System.out.println(" " + student.getId());
                }
                try {
                    selectedStdId = keyboard.nextLine();
                    for (Student student : studentList) {
                        if (student.getId().equals(selectedStdId)) {
                            isIdMatched = true;
                            selectedStudent =student;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Student ID");
                }
                if (isIdMatched == false)
                    System.out.println("Sorry, please enter Student ID in the Students List");
            } while (isIdMatched == false);


            boolean isBack=false;
            String yesOrNo = "";

            do {
                if(selectedStudent.getFrameworks().size()<2) {
                    Scanner keyboard = new Scanner(System.in);
                    Boolean isConfIdMatched = false;
                    System.out.println("Do you want to add a Framework for the Student " + selectedStdId);
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
                                        selectedStudent.getFrameworks().add(roleID);
                                        System.out.println("Student "+roleID+ " added as a Preferred Framework");
                                        TeamFormationMain.generateStudentsFile(studentList);
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
                    System.out.println("This member has 2 Preferred Framework");
                    TeamFormationMain.manageStudent();
                }
            } while (isBack == false);

        }
    }



}
