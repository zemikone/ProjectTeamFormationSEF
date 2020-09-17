package Controller;

//import Model.Preferences;
import Model.Project;
import Model.Student;
import Model.Team;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class FitnessMetricsController {
     ArrayList<Project> projectsList;
     ArrayList<Student> studentsList;
     ArrayList<Team> teamList;

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
    private BarChart<?, ?> chartFItness;

    public void setData(ArrayList<Team> teamList,ArrayList<Student> studentsList,ArrayList<Project> projectsList) {
        this.teamList = teamList;
        this.studentsList = studentsList;
        this.projectsList = projectsList;
    }

}
