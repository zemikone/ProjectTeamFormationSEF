package Controller;

//import Model.Preferences;
import Main.TeamFormationMain;
import Management.ProjectManager;
import Management.TeamFormation;
import Model.MainModel;
import Model.Project;
import Model.Student;
import Model.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FitnessMetricsController {
     ArrayList<Project> projectsList;
     ArrayList<Student> studentsList;
     ArrayList<Team> teamList;
     ProjectManager projectManager;

     int clickCount =0;
     String swapId1="";
     String swapId2="";     

//    XYChart.Series<String, Number> dataSeries1;
//    XYChart.Series<String, Number> dataSeries2;
//XYChart.Series<String, Number> dataSeries3;
//      XYChart.Series<String, Number> dataSeries4;

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
    private StackedBarChart<String,Number> chartFItness;

    @FXML
    private BarChart<String,Number> chartSecondFitness;

    @FXML
    NumberAxis xAxis;
    @FXML
    CategoryAxis yAxis;

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
            swapId1 = label.getText();
        }else if(clickCount==1){
            clickCount++;
            swapId2 = label.getText();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select two Student Members.", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
            clearFields();
        }
    }

    public void showData(){
        if(teamList.size()!=0){
            if(teamList.size()>0) {
                if(teamList.get(0).getMembers().size()>0) {
                    lbt1mem1.setText(teamList.get(0).getMembers().get(0));
                }
                if(teamList.get(0).getMembers().size()>1) {
                    lbt1mem2.setText(teamList.get(0).getMembers().get(1));
                }
                if(teamList.get(0).getMembers().size()>2) {
                    lbt1mem3.setText(teamList.get(0).getMembers().get(2));
                }
                if(teamList.get(0).getMembers().size()>3) {
                    lbt1mem4.setText(teamList.get(0).getMembers().get(3));
                }
            }
            if(teamList.size()>1) {
                if(teamList.get(1).getMembers().size()>0) {
                    lbt2mem1.setText(teamList.get(1).getMembers().get(0));
                }
                if(teamList.get(1).getMembers().size()>1) {
                    lbt2mem2.setText(teamList.get(1).getMembers().get(1));
                }
                if(teamList.get(1).getMembers().size()>2) {
                    lbt2mem3.setText(teamList.get(1).getMembers().get(2));
                }
                if(teamList.get(1).getMembers().size()>3) {
                    lbt2mem4.setText(teamList.get(1).getMembers().get(3));
                }
            }

            if(teamList.size()>2) {
                if(teamList.get(2).getMembers().size()>0) {
                    lbt3mem1.setText(teamList.get(2).getMembers().get(0));
                }
                if(teamList.get(2).getMembers().size()>1) {
                    lbt3mem2.setText(teamList.get(2).getMembers().get(1));
                }
                if(teamList.get(2).getMembers().size()>2) {
                    lbt3mem3.setText(teamList.get(2).getMembers().get(2));
                }
                if(teamList.get(2).getMembers().size()>3) {
                    lbt3mem4.setText(teamList.get(2).getMembers().get(3));
                }
            }

            if(teamList.size()>3) {
                if(teamList.get(3).getMembers().size()>0) {
                    lbt4mem1.setText(teamList.get(3).getMembers().get(0));
                }
                if(teamList.get(3).getMembers().size()>1) {
                    lbt4mem2.setText(teamList.get(3).getMembers().get(1));
                }
                if(teamList.get(3).getMembers().size()>2) {
                    lbt4mem3.setText(teamList.get(3).getMembers().get(2));
                }
                if(teamList.get(3).getMembers().size()>3) {
                    lbt4mem4.setText(teamList.get(3).getMembers().get(3));
                }
            }

            if(teamList.size()>4) {
                if(teamList.get(4).getMembers().size()>0) {
                    lbt5mem1.setText(teamList.get(4).getMembers().get(0));
                }
                if(teamList.get(4).getMembers().size()>1) {
                    lbt5mem2.setText(teamList.get(4).getMembers().get(1));
                }
                if(teamList.get(4).getMembers().size()>2) {
                    lbt5mem3.setText(teamList.get(4).getMembers().get(2));
                }
                if(teamList.get(4).getMembers().size()>3) {
                    lbt5mem4.setText(teamList.get(4).getMembers().get(3));
                }
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

    public void initializeCharts(){
        // Create a StackedBarChart
//        chartFItness.getData().clear();
//        chartFItness.layout();
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
        dataSeries1.setName("Std-Dev Min - Gap");

        for(int i=10;i<projectsList.size();i++){
            dataSeries1.getData().add(new XYChart.Data<String, Number>("Metrics (Standard deviation) "+(i+10), (TeamFormationMain.constPersonality*2.5)));
        }

        XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
        dataSeries2.setName("Std Dev max - Experience");
        for(int i=10;i<projectsList.size();i++) {
            dataSeries2.getData().add(new XYChart.Data<String, Number>("Teams " + (i + 12), (TeamFormationMain.constWorkExp * 2)));
        }

        // Add Series to StackedBarChart.
//        chartFItness.getData().addAll(dataSeries1,dataSeries2);
        chartFItness.setTitle("Team Fitness");
        showChart(dataSeries1,dataSeries2);
    }

    public void showCharts(XYChart.Series<String, Number> dataSeries1, XYChart.Series<String, Number> dataSeries2){
        chartFItness.getData().clear();
        chartFItness.layout();
        chartFItness.setAnimated(false);
        chartFItness.getData().addAll(dataSeries1,dataSeries2);
    }



        public void initializeChart(){
        // Create a StackedBarChart
//        chartFItness.getData().clear();
//        chartFItness.layout();
        XYChart.Series<String, Number> dataSeries3 = new XYChart.Series<String, Number>();
        dataSeries3.setName("Std Dev max - Metrics");

        for(int i=0;i<projectsList.size();i++){
            dataSeries3.getData().add(new XYChart.Data<String, Number>("Project "+(i+1), (TeamFormationMain.constPersonality*1)));
        }

        XYChart.Series<String, Number> dataSeries4 = new XYChart.Series<String, Number>();
        dataSeries4.setName("Std Dev min - Metrics");
        for(int i=0;i<projectsList.size();i++) {
            dataSeries4.getData().add(new XYChart.Data<String, Number>("Project " + (i + 12), (TeamFormationMain.constGPA * 1)));
        }

        // Add Series to StackedBarChart.
//        chartFItness.getData().addAll(dataSeries1,dataSeries2);
        chartFItness.setTitle("Team Fitness");
        showCharts(dataSeries3,dataSeries4);
    }

    public void showChart(XYChart.Series<String, Number> dataSeries1, XYChart.Series<String, Number> dataSeries2) {
        chartFItness.getData().clear();
        chartFItness.layout();
        chartFItness.setAnimated(false);
        chartFItness.getData().addAll(dataSeries1, dataSeries2);



    }

//    public void initializeChart()




}
