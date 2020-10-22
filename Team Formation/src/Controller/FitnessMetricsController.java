package Controller;

//import Model.Preferences;
import Main.TeamFormationMain;
import Management.ProjectManager;
import Model.*;
import Util.CommonUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.ArrayList;

import static Util.CommonUtil.calculateSD;

public class FitnessMetricsController {
     ArrayList<Project> projectsList;
     ArrayList<Student> studentsList;
     ArrayList<Team> teamList;
    ArrayList<Fitness> percentagePrefArray;
    ArrayList<Skills> percentageSkillsArray;
     ProjectManager projectManager;

     int clickCount =0;
     String swapId1="";
     String swapId2="";

//    XYChart.Series<String, Number> dataSeries1;
//    XYChart.Series<String, Number> dataSeries2;

    @FXML
    private Label lbt1mem1;

    @FXML
    private Label lbt1mem2;

    @FXML
    private Label lbt1mem3;

    @FXML
    private Label lbt1mem4;

    @FXML
    private CheckBox cht1mem1;

    @FXML
    private CheckBox cht1mem2;

    @FXML
    private CheckBox cht1mem3;

    @FXML
    private CheckBox cht1mem4;

    @FXML
    private Label lbt2mem1;

    @FXML
    private Label lbt2mem2;

    @FXML
    private Label lbt2mem3;

    @FXML
    private Label lbt2mem4;

    @FXML
    private CheckBox cht2mem1;

    @FXML
    private CheckBox cht2mem2;

    @FXML
    private CheckBox cht2mem3;

    @FXML
    private CheckBox cht2mem4;

    @FXML
    private Label lbt3mem1;

    @FXML
    private Label lbt3mem2;

    @FXML
    private Label lbt3mem3;

    @FXML
    private Label lbt3mem4;

    @FXML
    private CheckBox cht3mem1;

    @FXML
    private CheckBox cht3mem2;

    @FXML
    private CheckBox cht3mem3;

    @FXML
    private CheckBox cht3mem4;

    @FXML
    private Label lbt4mem1;

    @FXML
    private Label lbt4mem2;

    @FXML
    private Label lbt4mem3;

    @FXML
    private Label lbt4mem4;

    @FXML
    private CheckBox cht4mem1;

    @FXML
    private CheckBox cht4mem2;

    @FXML
    private CheckBox cht4mem3;

    @FXML
    private CheckBox cht4mem4;

    @FXML
    private Label lbt5mem1;

    @FXML
    private Label lbt5mem2;

    @FXML
    private Label lbt5mem3;

    @FXML
    private Label lbt5mem4;

    @FXML
    private CheckBox cht5mem1;

    @FXML
    private CheckBox cht5mem2;

    @FXML
    private CheckBox cht5mem3;

    @FXML
    private CheckBox cht5mem4;

    @FXML
    private Button btnSwap;

    @FXML
    private Label proj1;
    @FXML
    private Label proj2;
    @FXML
    private Label proj3;
    @FXML
    private Label proj4;
    @FXML
    private Label proj5;


    @FXML
    private StackedBarChart<String,Number> chartFItness;


    @FXML
    NumberAxis xAxis;
    @FXML
    CategoryAxis yAxis;

    @FXML
    private BarChart<String,Number> chartpref;

    @FXML
    private BarChart<String,Number> chartskills;

    @FXML
    private Button backButton;

    public void setData(ArrayList<Team> teamList, ArrayList<Student> studentsList, ArrayList<Project> projectsList, ProjectManager projectManager) {
        this.teamList = teamList;
        this.studentsList = studentsList;
        this.projectsList = projectsList;
        this.projectManager = projectManager;
    }



    @FXML
    void backButtonAction(ActionEvent event) throws Exception {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void swapClicked(ActionEvent event) throws Exception {

        String[] inputArrayId1 = swapId1.split("\\s+");
        String[] inputArrayId2 = swapId2.split("\\s+");

        if(swapId1.equals("")||swapId2.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select two Members First.", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }else if(inputArrayId1[0].equalsIgnoreCase("member")||inputArrayId2[0].equalsIgnoreCase("member")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select valid Members", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
        else {
                Team teamId1 = null;
                Team teamId2 = null;
                for(Team team: teamList){
                    for(String mem: team.getMembers()){
                        if(mem.equals(swapId1)){
                            teamId1 = team;
                        }
                        if(mem.equals(swapId2)){
                            teamId2 = team;
                        }

                    }
                }
                teamId1.getMembers().remove(swapId1);
                teamId1.getMembers().add(swapId2);
                teamId2.getMembers().remove(swapId2);
                teamId2.getMembers().add(swapId1);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Members Swapped Successfully!", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
                TeamFormationMain.generateTeamsFile();
                showData();
                clearFields();
            }

    }

    @FXML
    void cht1mem1Checked(ActionEvent event) {
        setCheckBoxCount(lbt1mem1);
    }

    @FXML
    void cht1mem2Checked(ActionEvent event) {
        setCheckBoxCount(lbt1mem2);
    }

    @FXML
    void cht1mem3Checked(ActionEvent event) {
        setCheckBoxCount(lbt1mem3);
    }

    @FXML
    void cht1mem4Checked(ActionEvent event) {
        setCheckBoxCount(lbt1mem4);
    }

    @FXML
    void cht2mem1Checked(ActionEvent event) {
        setCheckBoxCount(lbt2mem1);
    }

    @FXML
    void cht2mem2Checked(ActionEvent event) {
        setCheckBoxCount(lbt2mem2);
    }

    @FXML
    void cht2mem3Checked(ActionEvent event) {
        setCheckBoxCount(lbt2mem3);
    }

    @FXML
    void cht2mem4Checked(ActionEvent event) {
        setCheckBoxCount(lbt2mem4);
    }

    @FXML
    void cht3mem1Checked(ActionEvent event) {
        setCheckBoxCount(lbt3mem1);
    }

    @FXML
    void cht3mem2Checked(ActionEvent event) {
        setCheckBoxCount(lbt3mem2);
    }

    @FXML
    void cht3mem3Checked(ActionEvent event) {
        setCheckBoxCount(lbt3mem3);
    }

    @FXML
    void cht3mem4Checked(ActionEvent event) {
        setCheckBoxCount(lbt3mem4);
    }

    @FXML
    void cht4mem1Checked(ActionEvent event) {
        setCheckBoxCount(lbt4mem1);
    }

    @FXML
    void cht4mem2Checked(ActionEvent event) {
        setCheckBoxCount(lbt4mem2);
    }

    @FXML
    void cht4mem3Checked(ActionEvent event) {
        setCheckBoxCount(lbt4mem3);
    }

    @FXML
    void cht4mem4Checked(ActionEvent event) {
        setCheckBoxCount(lbt4mem4);
    }

    @FXML
    void cht5mem1Checked(ActionEvent event) {
        setCheckBoxCount(lbt5mem1);
    }

    @FXML
    void cht5mem2Checked(ActionEvent event) {
        setCheckBoxCount(lbt5mem2);
    }

    @FXML
    void cht5mem3Checked(ActionEvent event) {
        setCheckBoxCount(lbt5mem3);
    }

    @FXML
    void cht5mem4Checked(ActionEvent event) {
        setCheckBoxCount(lbt5mem4);
    }

    private void setCheckBoxCount(Label label){
        if(clickCount==0) {
            clickCount++;
            swapId1 = getStudentId(label.getText());
        }else if(clickCount==1){
            clickCount++;
            swapId2 = getStudentId(label.getText());
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select two Members.", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
            clearFields();
        }
    }

    public void showData(){
        if(teamList.size()!=0){
            if(teamList.size()>0) {
                proj1.setText(getProjectName(teamList.get(0).getProjId()));
                if(teamList.get(0).getMembers().size()>0) {
                    lbt1mem1.setText(getStudentName(teamList.get(0).getMembers().get(0)));
                }else{
                    lbt1mem1.setVisible(false);
                    cht1mem1.setVisible(false);
                }
                if(teamList.get(0).getMembers().size()>1) {
                    lbt1mem2.setText(getStudentName(teamList.get(0).getMembers().get(1)));
                }else{
                    lbt1mem2.setVisible(false);
                    cht1mem2.setVisible(false);
                }
                if(teamList.get(0).getMembers().size()>2) {
                    lbt1mem3.setText(getStudentName(teamList.get(0).getMembers().get(2)));
                }else{
                    lbt1mem3.setVisible(false);
                    cht1mem3.setVisible(false);
                }
                if(teamList.get(0).getMembers().size()>3) {
                    lbt1mem4.setText(getStudentName(teamList.get(0).getMembers().get(3)));
                }else{
                    lbt1mem4.setVisible(false);
                    cht1mem4.setVisible(false);
                }
            }else{
                proj1.setText("-");
                lbt1mem1.setVisible(false);
                cht1mem1.setVisible(false);
                lbt1mem2.setVisible(false);
                cht1mem2.setVisible(false);
                lbt1mem3.setVisible(false);
                cht1mem3.setVisible(false);
                lbt1mem4.setVisible(false);
                cht1mem4.setVisible(false);
            }
            if(teamList.size()>1) {
                proj2.setText(getProjectName(teamList.get(1).getProjId()));
                if(teamList.get(1).getMembers().size()>0) {
                    lbt2mem1.setText(getStudentName(teamList.get(1).getMembers().get(0)));
                }else{
                    lbt2mem1.setVisible(false);
                    cht2mem1.setVisible(false);
                }
                if(teamList.get(1).getMembers().size()>1) {
                    lbt2mem2.setText(getStudentName(teamList.get(1).getMembers().get(1)));
                }else{
                    lbt2mem2.setVisible(false);
                    cht2mem2.setVisible(false);
                }
                if(teamList.get(1).getMembers().size()>2) {
                    lbt2mem3.setText(getStudentName(teamList.get(1).getMembers().get(2)));
                }else{
                    lbt2mem3.setVisible(false);
                    cht2mem3.setVisible(false);
                }
                if(teamList.get(1).getMembers().size()>3) {
                    lbt2mem4.setText(getStudentName(teamList.get(1).getMembers().get(3)));
                }else{
                    lbt2mem4.setVisible(false);
                    cht2mem4.setVisible(false);
                }
            }else{
                proj2.setText("-");
                lbt2mem1.setVisible(false);
                cht2mem1.setVisible(false);
                lbt2mem2.setVisible(false);
                cht2mem2.setVisible(false);
                lbt2mem3.setVisible(false);
                cht2mem3.setVisible(false);
                lbt2mem4.setVisible(false);
                cht2mem4.setVisible(false);
            }

            if(teamList.size()>2) {
                proj3.setText(getProjectName(teamList.get(2).getProjId()));
                if(teamList.get(2).getMembers().size()>0) {
                    lbt3mem1.setText(getStudentName(teamList.get(2).getMembers().get(0)));
                }else{
                    lbt3mem1.setVisible(false);
                    cht3mem1.setVisible(false);
                }
                if(teamList.get(2).getMembers().size()>1) {
                    lbt3mem2.setText(getStudentName(teamList.get(2).getMembers().get(1)));
                }else{
                    lbt3mem2.setVisible(false);
                    cht3mem2.setVisible(false);
                }
                if(teamList.get(2).getMembers().size()>2) {
                    lbt3mem3.setText(getStudentName(teamList.get(2).getMembers().get(2)));
                }else{
                    lbt3mem3.setVisible(false);
                    cht3mem3.setVisible(false);
                }
                if(teamList.get(2).getMembers().size()>3) {
                    lbt3mem4.setText(getStudentName(teamList.get(2).getMembers().get(3)));
                }else{
                    lbt3mem4.setVisible(false);
                    cht3mem4.setVisible(false);
                }
            }else{
                proj3.setText("-");
                lbt3mem1.setVisible(false);
                cht3mem1.setVisible(false);
                lbt3mem2.setVisible(false);
                cht3mem2.setVisible(false);
                lbt3mem3.setVisible(false);
                cht3mem3.setVisible(false);
                lbt3mem4.setVisible(false);
                cht3mem4.setVisible(false);
            }

            if(teamList.size()>3) {
                proj4.setText(getProjectName(teamList.get(3).getProjId()));
                if(teamList.get(3).getMembers().size()>0) {
                    lbt4mem1.setText(getStudentName(teamList.get(3).getMembers().get(0)));
                }else{
                    lbt4mem1.setVisible(false);
                    cht4mem1.setVisible(false);
                }
                if(teamList.get(3).getMembers().size()>1) {
                    lbt4mem2.setText(getStudentName(teamList.get(3).getMembers().get(1)));
                }else{
                    lbt4mem2.setVisible(false);
                    cht4mem2.setVisible(false);
                }
                if(teamList.get(3).getMembers().size()>2) {
                    lbt4mem3.setText(getStudentName(teamList.get(3).getMembers().get(2)));
                }else{
                    lbt4mem3.setVisible(false);
                    cht4mem3.setVisible(false);
                }
                if(teamList.get(3).getMembers().size()>3) {
                    lbt4mem4.setText(getStudentName(teamList.get(3).getMembers().get(3)));
                }else{
                    lbt4mem4.setVisible(false);
                    cht4mem4.setVisible(false);
                }
            }else{
                proj4.setText("-");
                lbt4mem1.setVisible(false);
                cht4mem1.setVisible(false);
                lbt4mem2.setVisible(false);
                cht4mem2.setVisible(false);
                lbt4mem3.setVisible(false);
                cht4mem3.setVisible(false);
                lbt4mem4.setVisible(false);
                cht4mem4.setVisible(false);
            }

            if(teamList.size()>4) {
                proj5.setText(getProjectName(teamList.get(4).getProjId()));
                if(teamList.get(4).getMembers().size()>0) {
                    lbt5mem1.setText(getStudentName(teamList.get(4).getMembers().get(0)));
                }else{
                    lbt5mem1.setVisible(false);
                    cht5mem1.setVisible(false);
                }
                if(teamList.get(4).getMembers().size()>1) {
                    lbt5mem2.setText(getStudentName(teamList.get(4).getMembers().get(1)));
                }else{
                    lbt5mem2.setVisible(false);
                    cht5mem2.setVisible(false);
                }
                if(teamList.get(4).getMembers().size()>2) {
                    lbt5mem3.setText(getStudentName(teamList.get(4).getMembers().get(2)));
                }else{
                    lbt5mem3.setVisible(false);
                    cht5mem3.setVisible(false);
                }
                if(teamList.get(4).getMembers().size()>3) {
                    lbt5mem4.setText(getStudentName(teamList.get(4).getMembers().get(3)));
                }else{
                    lbt5mem4.setVisible(false);
                    cht5mem4.setVisible(false);
                }
            }else{
                proj5.setText("-");
                lbt5mem1.setVisible(false);
                cht5mem1.setVisible(false);
                lbt5mem2.setVisible(false);
                cht5mem2.setVisible(false);
                lbt5mem3.setVisible(false);
                cht5mem3.setVisible(false);
                lbt5mem4.setVisible(false);
                cht5mem4.setVisible(false);
            }
        }
        initializeChart();

    }

    private  void clearFields(){
        clickCount=0;
        swapId1 = "";
        swapId2 = "";
        cht1mem1.setSelected(false);
        cht1mem2.setSelected(false);
        cht1mem3.setSelected(false);
        cht1mem4.setSelected(false);
        cht2mem1.setSelected(false);
        cht2mem2.setSelected(false);
        cht2mem3.setSelected(false);
        cht2mem4.setSelected(false);
        cht3mem1.setSelected(false);
        cht3mem2.setSelected(false);
        cht3mem3.setSelected(false);
        cht3mem4.setSelected(false);
        cht4mem1.setSelected(false);
        cht4mem2.setSelected(false);
        cht4mem3.setSelected(false);
        cht4mem4.setSelected(false);
        cht5mem1.setSelected(false);
        cht5mem2.setSelected(false);
        cht5mem3.setSelected(false);
        cht5mem4.setSelected(false);
    }

    public void initializeChart(){

        this.percentagePrefArray = calPercentagePref();
//        this.percentageSkillsArray = calPercentageSkills();


        XYChart.Series<String, Number> dataSeries3;
        ArrayList<XYChart.Series<String, Number>>  dataSeriesList = new ArrayList();
        for(int i=0;i<percentagePrefArray.size();i++){
            dataSeries3 = new XYChart.Series<String, Number>();
            dataSeries3.getData().add(new XYChart.Data<String, Number>("Team "+ (i+1),percentagePrefArray.get(i).getValue()));
            dataSeriesList.add(dataSeries3);
        }
        chartpref.setTitle("");
        chartpref.getData().clear();
        chartpref.layout();
//        chartpref.setAnimated(false);
        for(XYChart.Series<String, Number> dataSeries: dataSeriesList) {
            chartpref.getData().add(dataSeries);
        }
        chartpref.setTitle("% Getting 1st and  2nd Preferences \n                  STD Dev= "+ CommonUtil.roundOff(percentagePrefArray.get(0).getStd()));

//
//        // for the second chart
//        XYChart.Series<String, Number> dataSeries4;
//        ArrayList<XYChart.Series<String, Number>>  newdataSeriesList = new ArrayList();
//        for(int i=1;i<percentageSkillsArray.size();i++){
//            dataSeries4 = new XYChart.Series<String, Number>();
//            dataSeries4.getData().add(new XYChart.Data<String, Number>("Team "+ (i+2),percentageSkillsArray.get(i).getValue()));
//            newdataSeriesList.add(dataSeries4);
//        }
//        chartskills.setTitle("");
//        chartskills.getData().clear();
//        chartskills.layout();
////        chartskills.setAnimated(false);
//        for(XYChart.Series<String, Number> dataSeries: dataSeriesList) {
//            chartskills.getData().add(dataSeries);
//        }
//        chartskills.setTitle("% Getting Skills Gap Percentage in STD \n                  STD Dev= "+ CommonUtil.roundOff(percentageSkillsArray.get(0).getStd()));



        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
        dataSeries1.setName("Constraint - Personality Type");

        for(int i=0;i<teamList.size();i++){
            dataSeries1.getData().add(new XYChart.Data<String, Number>("Team "+(i+1), (TeamFormationMain.constPersonality*2.34)));
        }

        XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
        dataSeries2.setName("Constraint - Skills");
        for(int i=0;i<teamList.size();i++) {
            dataSeries2.getData().add(new XYChart.Data<String, Number>("Team " + (i + 1), (TeamFormationMain.constWorkExp * 1.3)));
        }

        // Add Series to StackedBarChart.
        chartFItness.getData().addAll(dataSeries1,dataSeries2);
        chartFItness.setTitle("Getting % of the team fitness on the basis of skills gap satisfaction");
        showChart(dataSeries1,dataSeries2);
    }

    public void showChart(XYChart.Series<String, Number> dataSeries1, XYChart.Series<String, Number> dataSeries2){
        chartFItness.getData().clear();
        chartFItness.layout();
        chartFItness.setAnimated(false);
        chartFItness.getData().addAll(dataSeries1,dataSeries2);
    }

    private String getStudentName(String id){
        for(Student student: studentsList){
            if(student.getId().equalsIgnoreCase(id)){
                return student.getName();
            }
        }
        return "-";
    }

    private String getProjectName(String id){
        for(Project project: projectsList){
            if(project.getpId().equalsIgnoreCase(id)){
                return project.getName();
            }
        }
        return "-";
    }

    private String getStudentId(String name){
        for(Student student: studentsList){
            if(student.getName().equalsIgnoreCase(name)){
                return student.getId();
            }
        }
        return "-";
    }


    public  ArrayList<Fitness> calPercentagePref(){
        ArrayList<Double> percentageArray =new ArrayList();
        ArrayList<Fitness> percentagePrefArray =new ArrayList();
        Double studentCount =0.0;
        Double prefStdCount =0.0;
        for(Team team : teamList){
            studentCount =0.0;
            prefStdCount =0.0;
            Fitness fitness =new Fitness();
            for(String member : team.getMembers()){
                studentCount++;
                for(Student student : studentsList){
                    if(student.getId().equals(member)){
                        if(student.getPrefProjects().size()>1) {
                            if (student.getPrefProjects().get(0).equals(team.getProjId()) || student.getPrefProjects().get(1).equals(team.getProjId())) {
                                prefStdCount++;
                            }
                        }
                        break;
                    }
                }
            }
            Double percentage=0.0;
            for(Project project:projectsList) {
                if(project.getpId().equals(team.getProjId())) {
//                    System.out.println("Project -" + project.getpTitle());
                    break;
                }
            }
            if(studentCount!=0) {
                if(prefStdCount!=0) {
                    percentage = (prefStdCount / studentCount) * 100;
                    percentageArray.add(percentage);


                }else{

                }
                fitness.setProjName(team.getProjId());
                fitness.setValue(percentage);
                percentagePrefArray.add(fitness);
            }else{
                System.out.println("No Teams Formed!");
                System.out.println("Percentage of getting 1st and 2nd preference is 0%");
            }

        }
        Double sd = calculateSD(percentageArray);
        percentagePrefArray.get(0).setStd(sd);
        return percentagePrefArray;
    }

//    public  ArrayList<Skills> calPercentageSkills(){
//        ArrayList<Double> percentageArray =new ArrayList();
//        ArrayList<Skills> percentageSkillsArray =new ArrayList();
//        Double studentCount =0.0;
//        Double prefStdCount =0.0;
//        for(Team team : teamList){
//            studentCount =0.0;
//            prefStdCount =0.0;
//            Skills skills =new Skills();
//            for(String member : team.getMembers()){
//                studentCount++;
//                for(Student student : studentsList){
//                    if(student.getId().equals(member)){
//                        if(student.getUnlikeMemb().size()>1) {
//                            if (student.getPrefProjects().get(0).equals(team.getProjId()) || student.getPrefProjects().get(1).equals(team.getProjId())) {
//                                prefStdCount++;
//                            }
//                        }
//                        break;
//                    }
//                }
//            }
//            Double percentage=1.0;
//            for(Project project:projectsList) {
//                if(project.getpId().equals(team.getProjId())) {
////                    System.out.println("Project -" + project.getpTitle());
//                    break;
//                }
//            }
//            if(studentCount!=0) {
//                if(prefStdCount!=0) {
//                    percentage = (prefStdCount / studentCount) * 100;
//                    percentageArray.add(percentage);
//
//
//                }else{
//
//                }
//                skills.setProjName(team.getProjId());
//                skills.setValue(percentage);
//                percentageSkillsArray.add(skills);
//            }else{
//                System.out.println("No Teams Formed!");
//                System.out.println("Percentage  of Skills Gap is 0%");
//            }
//
//        }
//        Double sd = calculateSD(percentageArray);
//        percentageSkillsArray.get(0).setStd(sd);
//        return percentageSkillsArray;
//    }

}
