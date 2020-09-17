import Controller.FitnessMetricsController;
import Model.Project;
import Model.Student;
import Model.Team;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectManager {

     ArrayList<Project> projectsList;
     ArrayList<Student> studentList;
     ArrayList<Team> teamList;

    public ProjectManager(ArrayList<Project> projectsList, ArrayList<Student> studentList, ArrayList<Team> teamList) {
        this.projectsList = projectsList;
        this.studentList = studentList;
        this.teamList = teamList;
    }



    public void addPersonality() {
        if (studentList.size() == 0) {
            System.out.println("Please add Students File First!");
        } else {

            String personality = "";
            String studentId = "";
            String selectedStdId = "";
            String cnflctStdId1 = "";
            String cnflctStdId2 = "";


            // select student
            Boolean isIdMatched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Student from below list to capture t" +
                        "he Student Personalities");
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

            //select Personality
            Boolean isPrsnIdValid = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the Personality Type of the Student from below list of Characteristics");
                System.out.println("++++Personality List++++");
                System.out.println(" Personality Type");
                System.out.println(" ----------------");
                System.out.println(" A");
                System.out.println(" B");
                System.out.println(" C");
                System.out.println(" D");
                System.out.println(" E");
                System.out.println(" F");


                try {
                    personality = keyboard.nextLine();
                    if (personality.equals("A")
                            || personality.equals("B")
                            || personality.equals("C")
                            || personality.equals("D")
                            || personality.equals("E")
                            || personality.equals("F")) {
                            for(Student student: studentList){
                                if(student.getId().equals(selectedStdId)){
                                    student.setPersonality(personality);
                                    isPrsnIdValid =true;
                                    break;
                                }
                            }


                    } else {
                        System.out.println("Sorry, please enter valid Personality Type");
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Personality Type");
                }

            } while (isPrsnIdValid == false);

            TeamFormationMain.generateStudentsFile(studentList);
        }


    }

    public void changeGpa() throws Exception {
        if (studentList.size() == 0) {
            System.out.println("Please add Students File First!");
        } else {

            String gpaValue = "";
            String studentId = "";
            String selectedStdId = "";


            // select student
            Boolean isIdMatched = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the ID of the Student from below list to change t" +
                        "he GPA");
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

            //select Personality
            Boolean isPrsnIdValid = false;
            do {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the GPA you want to assign.");
                try {
                    gpaValue = keyboard.nextLine();
                    Double gpa =Double.parseDouble(gpaValue);

                    if(gpa>4){
                        System.out.println("Sorry, please enter valid GPA");
                    }else{
                        for(Student student: studentList){
                            if(student.getId().equals(selectedStdId)){
                                student.setGpa(gpa);
                                isPrsnIdValid =true;
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry, please enter valid Personality Type");
                }

            } while (isPrsnIdValid == false);

            TeamFormationMain.generateStudentsFile(studentList);
            TeamFormationMain.manageStudent();
        }
    }

    public void shortlistProjects() throws Exception {
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

    public void assignStudents(){

    }

    public void changeConstraints(){

    }

    public void swapMembers() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TeamFormationMain.class.getResource("/View/fitness_metrics.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Team Fitness Matrics");
        stage.setScene(new Scene(root, 1000, 800));
        FitnessMetricsController controller = fxmlLoader.getController();
        controller.setData(teamList,studentList,projectsList);
        stage.showAndWait();


    }





}
