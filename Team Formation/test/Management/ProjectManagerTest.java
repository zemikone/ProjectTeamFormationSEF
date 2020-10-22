package Management;

import Exception.TeamShortageException;
import Main.TeamFormationMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
// POSITIVE TEST CASE
    @Test
    void shortlistProjects() throws Exception {
        Assertions.assertThrows(TeamShortageException.class, () -> {
            ProjectManager projectManager = new ProjectManager(projectTeamMain.projectsList,projectTeamMain.studentList,projectTeamMain.teamList);
            projectManager.shortlistProjects();
        });

    }

 // NEGATIVE TEST CASE
    @Test
    void addProject() throws Exception {
        Assertions.assertThrows(TeamShortageException.class, () -> {
            ProjectManager projectManager = new ProjectManager(projectTeamMain.projectsList,projectTeamMain.studentList,projectTeamMain.teamList);
            projectManager.addProject();
     });

 }


}