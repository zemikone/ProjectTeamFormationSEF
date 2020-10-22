package Management;

import Controller.FitnessMetricsController;
import Main.TeamFormationMain;
import Model.MainModel;
import Model.Project;
import Model.Student;
import Model.Team;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProjectManager {

     ArrayList<Project> projectsList;
     ArrayList<Student> studentList;
     ArrayList<Team> teamList;
     int countA=0,countB=0,countC=0,countD=0,countE=0,countF=0;
     TeamFormation teamFormation;
     static Scanner sc = new Scanner(System.in);
     public static float[][] averageCompetencyProject = new float[6][6];


    public ProjectManager(ArrayList<Project> projectsList, ArrayList<Student> studentList, ArrayList<Team> teamList) {
        this.projectsList = projectsList;
        this.studentList = studentList;
        this.teamList = teamList;
        teamFormation = new TeamFormation(projectsList,studentList,teamList);
    }




    public static int countOccurences(String sentence,char character){
        int letter = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (character == ch) {
                letter++;
        }
    }
        return letter;
}



    public static int findIndex(int arr[], int t) {
        if (arr == null) return -1;
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == t)
                return i;
            else
                i = i + 1;
        }
        return -1;
    }



    public void addProject(){
        System.out.println("Enter title ");
        String title = sc.nextLine();
        System.out.println("Enter project ID  ");
        String project_id  = sc.nextLine();
        System.out.println("Enter description  ");
        String description   = sc.nextLine();
        System.out.println("Enter project owner ID  ");
        String project_owner_id  = sc.nextLine();
        System.out.println("Technical Skill Categories ");
        char[] skills = new char[4];
        System.out.println("(P) Programming & Software Engineering   ");
        int p = sc.nextInt();
        skills[--p] = 'P';
        sc.nextLine();
        System.out.println("(N) Networking and Security  ");
        int n = sc.nextInt();
        skills[--n] = 'N';
        sc.nextLine();
        System.out.println("(A) Analytics and Big Data ");
        int a = sc.nextInt();
        skills[--a] = 'A';
        sc.nextLine();
        System.out.println("(W) Web & Mobile applications  ");
        int w = sc.nextInt();
        skills[--w] = 'W';
        sc.nextLine();
        String final_skills = "";
        for(int i =skills.length ; i>0 ; i-- ){
            final_skills += skills[i-1] + " " + i + " ";
        }
        try {
            FileWriter myWriter = new FileWriter("projects.txt",true);
            myWriter.write(title + "\n"+project_id + "\n"+description + "\n"+project_owner_id + "\n" + final_skills+ "\n");
            myWriter.close();
            System.out.println("Added new Project ");
        } catch (IOException e) {
            System.out.println("An error occurred while adding Project ");
            e.printStackTrace();
        }
    }


    public  void addStudentPersonalities(){
        try{
            File myObj = new File("students.txt");
            int length = 0;
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                length++;
            }
            String charArray = "";
            myReader.close();
            Scanner myReaderAgain = new Scanner(myObj);
            try{
                FileWriter myWriter = new FileWriter("studentinfo.txt",true);
                while (myReaderAgain.hasNextLine()){
                    String data = myReaderAgain.nextLine();
                    System.out.println(data);
                    Boolean flag = true;
                    System.out.println("Assign a Personality Type");
                    char personality_Type = sc.nextLine().charAt(0);
                    int count = countOccurences(charArray,personality_Type);
                    do{
                        if (count < 5){
                            charArray += personality_Type;
                            flag = false;
                        }
                        else{
                            System.out.println("Invalid, Try again");
                            System.out.println("Assign a Personality Type");
                            personality_Type = sc.nextLine().charAt(0);
                            count = countOccurences(charArray,personality_Type);
                        }
                    }while(flag);
                    System.out.println("Assign a conflict student");
                    String conflict_students = sc.nextLine();
                    myWriter.write(data +personality_Type + " "+conflict_students + "\n");
                }
                myWriter.close();

            }
            catch (IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            myReaderAgain.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void skillsShortfall(){
        try{
            File myProjectsObj = new File("projects.txt");
            Scanner myProjectsReader = new Scanner(myProjectsObj);
            int count = 0;
            System.out.println("Skills shortfall for each project based on categories ");
            while (myProjectsReader.hasNextLine()){
                String[] student = new String[5];
                String output = "";
                String data_line_1 = myProjectsReader.nextLine();
                String data_line_2 = myProjectsReader.nextLine();
                String data_line_3 = myProjectsReader.nextLine();
                String data_line_4 = myProjectsReader.nextLine();
                String data_line_5 = myProjectsReader.nextLine();
                String[] splited = data_line_5.split("\\s");
                float shortfall = 0.0f;
                for (int i = 0; i < splited.length; i++) {
                    if(splited[i].equals("N")){
                        int val = Integer.parseInt(splited[++i],10);
                        if (val>averageCompetencyProject[count][1])
                            shortfall += val - averageCompetencyProject[count][1];
                    }
                    else if(splited[i].equals("P")){
                        int val = Integer.parseInt(splited[++i],10);
                        if (val>averageCompetencyProject[count][0])
                            shortfall += val - averageCompetencyProject[count][0];
                    }
                    else if(splited[i].equals("A")){
                        int val = Integer.parseInt(splited[++i],10);
                        if (val>averageCompetencyProject[count][2])
                            shortfall += val - averageCompetencyProject[count][2];
                    }
                    else if(splited[i].equals("W")){
                        int val = Integer.parseInt(splited[++i],10);
                        if (val>averageCompetencyProject[count][3])
                            shortfall += val - averageCompetencyProject[count][3];
                    }

                }
                System.out.println(data_line_2 + " " + shortfall);
                count++;

            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void averageCompetency(){
        try{
            File myObj = new File("selections.txt");
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] selectionSplited = data.split("\\s+");
                float[] avg = new float[4];
                for(int i =1;i<=4;i++){
                    try {
                        File myStudentsObj = new File("studentinfo.txt");
                        Scanner myStudentsReader = new Scanner(myStudentsObj);
                        while (myStudentsReader.hasNextLine()){
                            String studentsData = myStudentsReader.nextLine();
                            String[] splited = studentsData.split("\\s");
                            if(splited[0].equals(selectionSplited[i])){
                                avg[0] += Integer.parseInt(splited[2]);
                                avg[1] += Integer.parseInt(splited[4]);
                                avg[2] += Integer.parseInt(splited[6]);
                                avg[3] += Integer.parseInt(splited[8]);
                            }
                        }
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
                for(int i =0;i<4;i++){
                    avg[i] = avg[i]/4;
                }
                averageCompetencyProject[count] = avg;
                count++;
                System.out.println(selectionSplited[0] + Arrays.toString(avg));
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void shortlistProjects(){
        try{
            File myObj = new File("preferences.txt");
            Scanner myReader = new Scanner(myObj);
            int[] topProjects = new int[10];
            while (myReader.hasNextLine()){
                String data_skip = myReader.nextLine();
                String data = myReader.nextLine();
                String[] splited = data.split("\\s+");
                int pr = 0;
                for (int i = 0; i < splited.length; i++) {
                    if(i==0 || i%2 ==0){
                        pr = Integer.parseInt(splited[i].substring(2),10) - 1;
                    }
                    else{
                        topProjects[pr] += Integer.parseInt(splited[i],10);
                    }
                }
            }
            int[] allProjects = topProjects.clone();
            Arrays.sort(topProjects);
            int[] top5 = Arrays.copyOfRange(topProjects, topProjects.length-5,topProjects.length);
            String[] top_projects = new String[5];
            for (int i = top5.length-1; i >= 0; i--) {
                int pos = findIndex(allProjects,top5[i]);
                pos += 1;
                top_projects[top5.length-1-i] = "Pr" + pos;
            }
            System.out.println(Arrays.toString(top_projects));
            myReader.close();
            File myNewObj = new File("projects.txt");
            Scanner myNewReader = new Scanner(myNewObj);
            while (myNewReader.hasNextLine()){
                String data_line_1 = myNewReader.nextLine();
                String data_line_2 = myNewReader.nextLine();
                String data_line_3 = myNewReader.nextLine();
                String data_line_4 = myNewReader.nextLine();
                String data_line_5 = myNewReader.nextLine();
                for(String s: top_projects){
                    if(s.equals(data_line_2)){
                        try {
                            FileWriter myWriter = new FileWriter("projects_new.txt",true);
                            myWriter.write(data_line_1 + "\n"+data_line_2+ "\n"+data_line_3+ "\n"+data_line_4+ "\n"+data_line_5+ "\n");
                            myWriter.close();
                        } catch (IOException e) {
                            System.out.println("An error occurred while adding Project Owner ");
                            e.printStackTrace();
                        }
                    }
                }
            }
            myNewReader.close();
            File deleteFile = new File("projects.txt");
            deleteFile.delete();
            File renameFile = new File("projects_new.txt");
            renameFile.renameTo(deleteFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void selectPrefProjects(){
        System.out.println("Enter Student Number");
        String student_number = sc.nextLine();
        System.out.println("Project Preference ");
        String[] preference = new String[4];
        String final_preference = "";

        for(int i =1 ; i<=preference.length ; i++ ){
            System.out.println("Preference - " + i);
            int rank = preference.length-i+1;
            preference[i-1] = sc.nextLine();
            final_preference += preference[i-1] + " " + rank + " ";
        }
        try{
            File myObj = new File("preferences.txt");
            Scanner myReader = new Scanner(myObj);
            int presentat = -1;
            int count = 0;
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                count++;
                if(data.equals(student_number)){
                    presentat = count;
                }
            }
            myReader.close();
            System.out.println(presentat);
            if(presentat<0){
                try {
                    FileWriter myWriter = new FileWriter("preferences.txt",true);
                    myWriter.write(student_number + "\n"+final_preference+ "\n");
                    myWriter.close();
                    System.out.println("Added new Project Owner ");
                } catch (IOException e) {
                    System.out.println("An error occurred while adding Project Owner ");
                    e.printStackTrace();
                }
            }
            else{
                count = 0;
                Scanner myReaderAgain = new Scanner(myObj);
                try {
                    FileWriter myWriterAgain = new FileWriter("preferences_new.txt",true);
                    while (myReaderAgain.hasNextLine()){
                        String data = myReaderAgain.nextLine();
                        count++;
                        if(count == presentat){
                            String data_skip = myReaderAgain.nextLine();
                            count++;
                            myWriterAgain.write(student_number + "\n"+final_preference+ "\n");
                        }
                        else{
                            myWriterAgain.write(data + "\n");
                        }
                    }
                    myWriterAgain.close();
                    myReaderAgain.close();
                    File deleteFile = new File("preferences.txt");
                    deleteFile.delete();
                    File renameFile = new File("preferences_new.txt");
                    renameFile.renameTo(deleteFile);


                } catch (IOException e) {
                    System.out.println("An error occurred while adding Project Owner ");
                    e.printStackTrace();
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void addCompany(){
            System.out.println("Enter Company ID ");
            String company_id = sc.nextLine();
            System.out.println("Enter Company Name ");
            String company_name = sc.nextLine();
            System.out.println("Enter ABN number ");
            int abn_number = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Company URL  ");
            String company_url  = sc.nextLine();
            System.out.println("Enter Company address ");
            String company_adress  = sc.nextLine();
            try {
                FileWriter myWriter = new FileWriter("companies.txt",true);
                myWriter.write(company_id + "\n"+company_name + "\n"+abn_number + "\n"+company_url + "\n"+company_adress + "\n");
                myWriter.close();
                System.out.println("Successfully Added new company");
            } catch (IOException e) {
                System.out.println("An error occurred while adding company");
                e.printStackTrace();
            }

        }

    public void addProjectOwner(){
            System.out.println("Enter First Name ");
            String first_name = sc.nextLine();
            System.out.println("Enter Surname ");
            String surname = sc.nextLine();
            System.out.println("Enter Project Owner ID ");
            String project_owner_id  = sc.nextLine();
            System.out.println("Enter Role  ");
            String role   = sc.nextLine();
            System.out.println("Enter email address ");
            String email_address  = sc.nextLine();
            System.out.println("Enter Company ID ");
            String compnany_id  = sc.nextLine();
            try {
                FileWriter myWriter = new FileWriter("owners.txt",true);
                myWriter.write(first_name + "\n"+surname + "\n"+project_owner_id + "\n"+role + "\n"+email_address + "\n"+compnany_id + "\n");
                myWriter.close();
                System.out.println(" Successfully Added new Project Owner ");
            } catch (IOException e) {
                System.out.println("An error occurred while adding Project Owner ");
                e.printStackTrace();
            }
        }





//    public void shortlistProjects() throws Exception {
//        if (projectsList.size() >4) {
//            for (Project project : projectsList) {
//                String tempProjId = project.getpId();
//                for(Student student: studentList){
//                    for(String prefproj : student.getPrefProjects()){
//                        if(prefproj.equals(tempProjId)){
//                            project.setPrefCount(project.getPrefCount()+1);
//                        }
//                    }
//                }
//            }
//
//            //Sorting the projects
//            boolean sorted = false;
//            Project temp;
//            while (!sorted) {
//                sorted = true;
//                for (int i = 0; i < projectsList.size() - 1; i++) {
//                    if (projectsList.get(i).getPrefCount() < projectsList.get(i + 1).getPrefCount()) {
//                        temp = projectsList.get(i);
//                        projectsList.set(i, projectsList.get(i + 1));
//                        projectsList.set(i + 1, temp);
//                        sorted = false;
//                    }
//                }
//            }
////            To shortlist projects based on no of students
////            int noProjects = studentList.size()/4;
//
//            //Remove the rest of the projects keeping the most prefered ones
//            ArrayList<Project> tempProjectsList = new ArrayList();
//            for (int i = 0; i < 5; i++) {
//                tempProjectsList.add(projectsList.get(i));
//            }
//            projectsList = tempProjectsList;
//
//        }else{
//            throw  new TeamsEmptyException("");
//        }
//
//
//        System.out.println("++++Project List++++");
//        System.out.println(" ID     Project Title    Pref Count");
//        System.out.println(" --     -------------    ----------");
//        for (Project project : projectsList) {
//            System.out.println(" " + project.getpId() + "     " + project.getName() + "    " + project.getPrefCount());
//        }
//
//        System.out.println("Projects have been Shortlisted Successfully!");
//
//
//    }
//
//    public void assignStudents() throws Exception{
//        teamFormation.formTeamsMenu();
//    }

    public void changeConstraints() throws Exception {
        Boolean isConsValid = false;
        int entConsPerson=0;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please enter the weight (1 to 4) for the Soft Constraint - Student Personality");
            try {
                entConsPerson = Integer.parseInt(keyboard.nextLine());
                if(entConsPerson<5 && entConsPerson>0){
                    TeamFormationMain.constPersonality = entConsPerson;
                    isConsValid = true;
                }
            } catch (Exception e) {
                System.out.println("Sorry, please enter valid weight (1 to 4) for the Soft Constraint - Student Personality");
            }
            if (isConsValid == false)
                System.out.println("Sorry, please enter valid weight (1 to 4) for the Soft Constraint - Student Personality");
        } while (isConsValid == false);

        isConsValid =false;
        int entConsExp=0;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please enter the weight (1 to 4) for the Soft Constraint - Years Experience");
            try {
                entConsExp = Integer.parseInt(keyboard.nextLine());
                if(entConsExp<5 && entConsExp>0){
                    TeamFormationMain.constWorkExp = entConsExp;
                    isConsValid = true;
                }
            } catch (Exception e) {
                System.out.println("Sorry, please enter valid weight (1 to 4) for the Soft Constraint - ");
            }
            if (isConsValid == false)
                System.out.println("Sorry, please enter valid weight (1 to 4) for the Soft Constraint  - ");
        } while (isConsValid == false);
        TeamFormationMain.generateConstraintsFile();
        TeamFormationMain.showMainMenu();
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
        MainModel mainModel = new MainModel(projectsList,studentList,teamList);
        controller.setData(teamList,studentList,projectsList,this);
        controller.showData();
        stage.showAndWait();


    }







}
