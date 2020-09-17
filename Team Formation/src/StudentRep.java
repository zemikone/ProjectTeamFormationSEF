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

}
