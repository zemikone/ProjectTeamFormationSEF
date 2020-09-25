package Management;

import Main.TeamFormationMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Exception.TeamShortageException;

import static org.junit.jupiter.api.Assertions.*;

class ProjectManagerTest {
    static TeamFormationMain projectTeamMain;
    @BeforeAll
    static void beforeAll() throws Exception {
        projectTeamMain = new TeamFormationMain();
        projectTeamMain.readTeamsFile();
        projectTeamMain.readConstraintsFile();
        projectTeamMain.readProjectsFile();
        projectTeamMain.readStudentsFile();
    }

    @Test
    void shortlistProjects() throws Exception {
        Assertions.assertThrows(TeamShortageException.class, () -> {
            ProjectManager projectManager = new ProjectManager(projectTeamMain.projectsList,projectTeamMain.studentList,projectTeamMain.teamList);
            projectManager.shortlistProjects();
        });

    }
}