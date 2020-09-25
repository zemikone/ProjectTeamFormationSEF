package Management;

import Main.TeamFormationMain;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class TeamFormationMainTest {

    static TeamFormationMain teamFormationMain;
    @Before
    void initializeClasses(){
        teamFormationMain = new TeamFormationMain();
    }

    @Test
    void testReadProjectsFile() throws Exception {
        teamFormationMain.projectsList = new ArrayList<>();
        teamFormationMain.readProjectsFile();
        assertEquals("Customer Relationship Management (CRM)",teamFormationMain.projectsList.get(0).getName());
    }

    @Test
    void testReadStudentsFile() throws Exception {
        teamFormationMain.studentList = new ArrayList<>();
        teamFormationMain.readStudentsFile();
        assertEquals("Anne",teamFormationMain.studentList.get(0).getName());
    }

    @Test
    void testReadTeamsFile() throws Exception {
        teamFormationMain.teamList = new ArrayList<>();
        teamFormationMain.readTeamsFile();
        assertEquals("T1",teamFormationMain.teamList.get(0).getId());
    }


}