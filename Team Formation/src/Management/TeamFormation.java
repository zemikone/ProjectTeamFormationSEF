package Management;

import Main.TeamFormationMain;
import Model.Project;
import Model.Student;
import Model.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamFormation {


    static ArrayList<Project> projectsList;
    static ArrayList<Student> studentList;
    static ArrayList<Team> teamList;
    static ProjectManager projectManager;
    static int countA=0,countB=0,countC=0,countD=0,countE=0,countF=0;


    public TeamFormation(ArrayList<Project> projectsList, ArrayList<Student> studentList, ArrayList<Team> teamList) {
        this.projectsList = projectsList;
        this.studentList = studentList;
        this.teamList = teamList;
    }

    public static void formTeamsMenu() throws Exception{

        int option;
        do {
            option = showTeamMenu();
            switch (option) {
                case 1:
                    createNewTeam();
                    break;
                case 2:
                    addMembersExistingTeam();
                    break;
                case 3:
                    showTeams();
                    break;
                case 4:
                    projectManager = new ProjectManager(projectsList,studentList,teamList);
                    projectManager.changeConstraints();
                    return;
                case 5:
                    TeamFormationMain.showMainMenu();
                    return;
                default:
                    System.out.println("Sorry, please enter valid Option");
                    TeamFormationMain.showMainMenu();
            }
        } while (option != 6);

    }

    public static int showTeamMenu() {

        int option;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("  Teams Menu:");
        System.out.println("*************************");
        System.out.println("1.Create a new Team");
        System.out.println("2.Add members to a Team");
        System.out.println("3.View Teams");
        System.out.println("4.Change Constraints");
        System.out.println("5.Back");
        System.out.println("*************************");
        System.out.println("Enter your choice:");
        try {
            option = keyboard.nextInt();
        } catch (Exception e) {
            return 3;
        }
        return option;

    }



    public static void createNewTeam() throws Exception{
        Team team = new Team();
        team.setId("T"+(teamList.size()+1));
        String projId = "";

        //Select the project
        Boolean isPrjIdMatched = false;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please enter the Project Id to Create a Team");
            System.out.println("++++Project List++++");
            System.out.println(" ID     Project Title");
            System.out.println(" --     -------------");
            ArrayList<Project> tempProjectList = new ArrayList<>();
            for (Project project : projectsList) {
                boolean isTaken = false;
                for(Team team1 : teamList){
                    if(team1.getProjId().equals(project.getpId())){
                        isTaken =true;
                        break;
                    }
                }
                if(!isTaken) {
                    tempProjectList.add(project);

                }
            }

            for (Project project : tempProjectList) {
                System.out.println(" " + project.getpId() + "     " + project.getName());
            }
            try {
                projId = keyboard.nextLine();
                for (Project project : projectsList) {
                    if (project.getpId().equals(projId)) {
                        isPrjIdMatched = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Sorry, please enter valid Project ID");
            }
            if (isPrjIdMatched == false)
                System.out.println("Sorry, please enter Project ID in the Project List");
        } while (isPrjIdMatched == false);
        team.setProjId(projId);

        // select student
        boolean goBack = false;
        String studentId = "";
        String yesOrNo = "";
        do{
            if(team.getMembers().size()<4){
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Do you want to add a student to the Team?");
                System.out.println(" Y - Yes");
                System.out.println(" N - No");
                yesOrNo = keyboard.nextLine();
                if (yesOrNo.equalsIgnoreCase("Y")) {
                    addMembers(team,projId);
                }else if(yesOrNo.equalsIgnoreCase("N")){
                    goBack =true;

                }else {
                    System.out.println("Sorry, please enter valid input Y or N");
                }
            }else{
                System.out.println("Team has 4 Members!");
                goBack =true;
            }
        } while(goBack == false);
        if(team.getMembers().size()!=0) {
            teamList.add(team);
            TeamFormationMain.generateTeamsFile();
        }else{
            System.out.println("This Team has not been saved since no members in it.");
        }
        formTeamsMenu();

    }

    public static void addMembers(Team team, String projId) throws Exception {
        String studentId="";
        Boolean isIdMatched = false;
        boolean isTaken = false;

        ArrayList<Student> tempStudentList = new ArrayList();
        do {
            Student currentStudent=null;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please enter the ID of the Student from below list to add the Team!");
            System.out.println("Or enter B to go back");
            System.out.println("++++Students List++++");
            System.out.println(" ID     Preferences");
            System.out.println(" --     -----------");
            boolean isStudentsZero = true;
            for(Student student: studentList){
                for(String proj: student.getPrefProjects()){
                    if (proj.equals(projId)) {
                        tempStudentList.add(student);
                        System.out.println(" " + student.getId() + "     " +
                                "4 " + student.getPrefProjects().get(0) + " " +
                                "3 " + student.getPrefProjects().get(1) + " " +
                                "2 " + student.getPrefProjects().get(2) + " " +
                                "1 " + student.getPrefProjects().get(3) + " ");
                        isStudentsZero = false;
                    }
                }

            }
            if(isStudentsZero){
                System.out.println("Sorry, No Students interested for this Project");
                break;
            }
            try {
                studentId = keyboard.nextLine();
                if(studentId.equalsIgnoreCase("B")){
                    break;
                }else {

                    //Check whether entered input is valid
                    for (Student student : tempStudentList) {
                        if (student.getId().equals(studentId)) {
                            //Check whether student is already added to the other Teams
                            isTaken = false;
                            for(Team team1 : teamList){
                                for(String member : team1.getMembers()){
                                    if(member.equals(studentId)){
                                        isTaken =true;
//                                        throw new InvalidMemberException("mm");
                                        break;
                                    }
                                }
                                if(isTaken)
                                    System.out.println("Sorry, this Student already been assigned to a Team.");
                                break;
                            }

                            //Check whether student is already added to the same Team
                            if(!isTaken){
                                for(String member : team.getMembers()){
                                    if(member.equals(studentId)){
                                        isTaken =true;
                                        System.out.println("Sorry, this Student already been assigned to the same Team.");
                                        break;
                                    }
                                }
                            }

                            //Check conflicts between team members
                            for(String member : team.getMembers()){
                                for(Student student1: studentList){
                                    if(student1.getId().equals(member)) {
                                        for(String confStd : student1.getUnlikeMemb()){
                                            if (confStd.equals(studentId)) {
                                                isTaken = true;
                                                System.out.println("Sorry, this Student has a conflict with the member " + student1.getId() + " in the Team.");
                                                break;
                                            }
                                        }
                                    }

                                }
                            }
                            for(Student student1: studentList) {
                                if(student1.getId().equals(studentId)){
                                    currentStudent = student1;
                                    for(String member : team.getMembers()){
                                        for(String confStd : student1.getUnlikeMemb()){
                                            if (confStd.equals(studentId)) {
                                                isTaken = true;
                                                System.out.println("Sorry, this Student has a conflict with the member " + member + " in the Team.");
                                                break;
                                            }
                                        }

                                    }
                                }
                            }

                            //Check Female Count
                            if(team.getMembers().size()>=1){
                                int femaleCount=0;
                                for(String mem: team.getMembers()){
                                    for(Student student1: studentList){
                                        if(student1.getId().equals(mem)){
                                            if(student1.getGender().equalsIgnoreCase("F")){
                                                femaleCount++;
                                                break;
                                            }
                                        }
                                    }
                                }
                                for(Student student1: studentList){
                                    if(student1.getId().equals(studentId)){
                                        if(student1.getGender().equalsIgnoreCase("F")){
                                            femaleCount++;
                                            break;
                                        }
                                    }
                                }
                                if(femaleCount>1){
                                    isTaken = true;
                                    System.out.println("Sorry, this student can't be added to the team. Female members count cannot exceed 1.");
                                }

                            }

                            //Check Personality Imbalance and No Leader Validation
                            countA=0; countB=0; countC=0; countD=0;
                            for(String member : team.getMembers()) {
                                for (Student student1 : studentList) {
                                    if (student1.getId().equals(member)) {
                                        if(student1.getPersonality()!=null) {
                                            calPersonalityCount(student1.getPersonality());
                                        }
                                    }
                                }
                            }
                            if(currentStudent.getPersonality()!=null) {
                                calPersonalityCount(currentStudent.getPersonality());
                                //A and B Personality Type
                                if(team.getMembers().size()==3){
                                    if(countA == 0 && countB ==0){
                                        isTaken = true;
                                        System.out.println("Sorry, this student can't be added to the team. There must be at least one of personality type A or B!");
                                    }
                                }
                                //Two same type personalities can't be added (constraints affect this)
                                int maxAmt=0;
                                switch (TeamFormationMain.constPersonality){
                                    case 4:{
                                        maxAmt=2;
                                        break;
                                    }
                                    case 3:{
                                        maxAmt=3;
                                        break;
                                    }
                                    case 2:{
                                        maxAmt=4;
                                        break;
                                    }
                                    case 1:{
                                        maxAmt=5;
                                        break;
                                    }
                                }

                                if(team.getMembers().size()>=2){
                                    if(countA>=maxAmt||countB>=maxAmt||countC>=maxAmt||countD>=maxAmt||countE>=maxAmt||countF>=maxAmt){
                                        isTaken = true;
                                        System.out.println("Sorry, this student can't be added to the team. No " +maxAmt+" members of the same personality types can be placed in one team!");
                                    }
                                }
//                                Check Exp years count (constraints affect this)
                                int maxExp=0;
                                switch (TeamFormationMain.constWorkExp){
                                    case 4:{
                                        maxExp=5;
                                        break;
                                    }
                                    case 3:{
                                        maxExp=4;
                                        break;
                                    }
                                    case 2:{
                                        maxExp=3;
                                        break;
                                    }
                                    case 1:{
                                        maxExp=2;
                                        break;
                                    }
                                }
                                if(team.getMembers().size()==3){
                                    int expYearsCount=0;
                                    for(String mem: team.getMembers()){
                                        for(Student student1: studentList){
                                            if(student1.getId().equals(mem)){
                                                if(student1.getExpYears()>=maxExp){
                                                    expYearsCount++;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    for(Student student1: studentList){
                                        if(student1.getId().equals(studentId)){
                                            if(student1.getExpYears()>=maxExp){
                                                expYearsCount++;
                                                break;
                                            }
                                        }
                                    }
                                    if(expYearsCount==0){
                                        isTaken = true;
                                        System.out.println("Sorry, this student can't be added to the team. Team should have one member with at least "+maxExp+" years of previous work experience!");
                                    }

                                }

                                //Check GPA
                                if(team.getMembers().size()==3){
                                    int expGPACount=0;
                                    Double totGpa=0.0;
                                    for(String mem: team.getMembers()){
                                        for(Student student1: studentList){
                                            if(student1.getId().equals(mem)){
                                                totGpa = totGpa+student1.getGpa();
                                                if(student1.getGpa()>=3.0){
                                                    expGPACount++;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    for(Student student1: studentList){
                                        if(student1.getId().equals(studentId)){
                                            totGpa = totGpa+student1.getGpa();
                                            if(student1.getGpa()>=3.0){
                                                expGPACount++;
                                                break;
                                            }
                                        }
                                    }
                                    if(expGPACount<2){
                                        isTaken = true;
                                        System.out.println("Sorry, this student can't be added to the team. Team should have at least two or more students with GPA 3!");
                                    }
                                    if((totGpa/4)>3.5){
                                        isTaken = true;
                                        System.out.println("Sorry, this student can't be added to the team. Average GPA cannot exceed 3.5!");

                                    }

                                }
                            }


                            isIdMatched = true;
                            break;
                        }

                    }
                }
            } catch (Exception e) {
                System.out.println("Sorry, please enter valid Student ID");
            }
            if (isIdMatched == false) {
                System.out.println("Sorry, please enter Student ID in the Students List");
            }else{
                if(!isTaken) {
                    team.getMembers().add(studentId);
                    TeamFormationMain.generateTeamsFile();
                }
            }
        } while (isIdMatched == false);

    }

    private static void calPersonalityCount(String personality){
        switch (personality) {
            case "A":
                countA++;
                break;
            case "B":
                countB++;
                break;
            case "C":
                countC++;
                break;
            case "D":
                countD++;
                break;
        }
    }

    public static void addMembersExistingTeam() throws Exception{
        boolean isMatched = false;
        boolean isGoBack = false;
        String input="";
        String yesOrNo = "";
        boolean isFirst = true;
        Team selctedteam = null;

        do{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please enter the Project Id to Add Members");
            System.out.println("Or enter B to go back!");
            System.out.println("++++Team List++++");
            System.out.println(" Proj ID     Team");
            System.out.println(" -------     ----");

            for (Team team : teamList) {
                String members ="";
                for(String mem1 : team.getMembers()){
                    members = members+ mem1 + " ";
                }
                System.out.println(" " + team.getProjId() + "         " + members);
            }

            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("B")){
                isGoBack = true;
                break;
            }else {

                for (Team team1 : teamList) {
                    if (team1.getProjId().equals(input)) {
                        selctedteam = team1;
                        isMatched = true;
                        break;
                    }
                }

                if (isMatched) {
                    do{
                        if(selctedteam.getMembers().size()<4) {
                            if (!isFirst){
                                System.out.println("Do you want to add a student to the Team?");
                                System.out.println(" Y - Yes");
                                System.out.println(" N - No");
                                yesOrNo = keyboard.nextLine();
                                if (yesOrNo.equalsIgnoreCase("Y")) {
                                    addMembers(selctedteam, input);
                                } else if (yesOrNo.equalsIgnoreCase("N")) {
                                    isGoBack = true;

                                } else {
                                    System.out.println("Sorry, please enter valid input Y or N");
                                }
                            }else{
                                addMembers(selctedteam, input);
                                isFirst = false;
                            }
                        }else{
                            System.out.println("Team has 4 Members!");
                            isGoBack =true;
                        }
                    }while (isGoBack == false);

                }
            }
        } while(isMatched == false);
    }

    public static void showTeams() {
        boolean goBack = false;
        String input="";

        do{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter any key to go back!");
            System.out.println("++++Team List++++");
            System.out.println(" Proj ID     Team");
            System.out.println(" -------     ----");

            for (Team team : teamList) {
                String members ="";
                for(String mem1 : team.getMembers()){
                    members = members+ mem1 + " ";
                }
                System.out.println(" " + team.getProjId() + "         " + members);
            }

            input = keyboard.nextLine();
            goBack = true;
        } while(goBack == false);

    }

}
