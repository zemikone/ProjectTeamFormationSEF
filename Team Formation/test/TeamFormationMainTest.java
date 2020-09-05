import Model.Project;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class TeamFormationMainTest {

    @Test
    void testReadProjectsFile() throws Exception {
        TeamFormationMain teamFormationMain = new TeamFormationMain();
        teamFormationMain.projectsList = new ArrayList<>();
        teamFormationMain.readProjectsFile();
        assertEquals("Customer Relationship Management (CRM)",teamFormationMain.projectsList.get(0).getName());
    }
}