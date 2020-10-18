package Management;

import Main.TeamFormationMain;
import Model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Exception.InvalidMemberException;
import Exception.TeamsEmptyException;
import static org.junit.jupiter.api.Assertions.*;

class TeamFormationTest {

    static TeamFormationMain projectTeamMain;
    @BeforeAll
    static void beforeAll() throws Exception {
        projectTeamMain = new TeamFormationMain();
        projectTeamMain.readTeamsFile();
        projectTeamMain.readConstraintsFile();
        projectTeamMain.readProjectsFile();
        projectTeamMain.readStudentsFile();
    }

//    @Test
//    void addMembers() {
//        Assertions.assertThrows(InvalidMemberException.class, () -> {
//            TeamFormation teamFormation = new TeamFormation(projectTeamMain.projectsList,projectTeamMain.studentList,projectTeamMain.teamList);
//            Team team = new Team();
//            team.setId("T1");
//            team.setProjId("Pr2");
//            team.getMembers().add("S1");
//            team.getMembers().add("S2");
//            Team team1 = new Team();
//            team1.setId("T2");
//            team1.setProjId("Pr1");
//            teamFormation.teamList.add(team);
//            teamFormation.teamList.add(team1);
//            teamFormation.addMembers(teamFormation.teamList.get(1),"Pr1");
//        });
//    }


    @Test
    void showTeams() throws Exception {
        Assertions.assertThrows(TeamsEmptyException.class, () -> {
        TeamFormation teamFormation = new TeamFormation(projectTeamMain.projectsList,projectTeamMain.studentList,projectTeamMain.teamList);
        teamFormation.showTeams();
        });

    }
}