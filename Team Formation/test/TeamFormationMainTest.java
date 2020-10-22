import Main.TeamFormationMain;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
class TeamFormationMainTest {

    // POSITIVE TEST CASES
    @Test
    void testReadProjectsFile() throws Exception {
        TeamFormationMain teamFormationMain = new TeamFormationMain();
        teamFormationMain.projectsList = new ArrayList<>();
        teamFormationMain.readProjectsFile();
        assertEquals("Customer Relationship Management (CRM)",teamFormationMain.projectsList.get(0).getName());
    }
// test case for the students data
    @Test
    void testreadStudentsFile() throws Exception {
        TeamFormationMain teamFormationMain = new TeamFormationMain();
        teamFormationMain.studentList = new ArrayList<>();
        teamFormationMain.readStudentsFile();
        assertEquals("Anne",teamFormationMain.studentList.get(0).getName());

    }
 // test case for teams check
    @Test
    void testReadTeamsFile() throws Exception {
        TeamFormationMain teamFormationMain = new TeamFormationMain();
        teamFormationMain.teamList = new ArrayList<>();
        teamFormationMain.readTeamsFile();
        assertEquals("T1",teamFormationMain.teamList.get(0).getId());
    }



//    @Test
//    void testcalculateSD() throws Exception {
//        TeamFormationMain teamFormationMain = new TeamFormationMain();
//        CommonUtil commonUtil = new CommonUtil();
//        commonUtil.calculateSD();
////        assertEquals("Lisa",teamFormationMain.studentList.get(0).getName());
//        assertEquals("12.6",commonUtil.calculateSD(12.6);
//    }





    // NEGATIVVE TEST CASES
    @Test
    void ReadTeamsFile() throws Exception {
        TeamFormationMain teamFormationMain = new TeamFormationMain();
        teamFormationMain.teamList = new ArrayList<>();
        teamFormationMain.readTeamsFile();
        assertEquals("T100",teamFormationMain.teamList.get(0).getId());
    }
  // test case for checking the conflicting member
    @Test
    void readStudentsFile() throws Exception {
        TeamFormationMain teamFormationMain = new TeamFormationMain();
        teamFormationMain.studentList = new ArrayList<>();
        teamFormationMain.readStudentsFile();
        assertEquals("S4",teamFormationMain.studentList.get(0).getUnlikeMemb());

    }



        @Test
    void readStudentsFiletest() throws Exception{
        TeamFormationMain teamFormationMain = new TeamFormationMain();
        teamFormationMain.teamList = new ArrayList<>();
        assertEquals("Pr3", teamFormationMain.teamList.get(0).getProjId());
    }
}