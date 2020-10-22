package Model;

import java.util.ArrayList;

public class Team {
    String id;
    String projId;
    ArrayList<String> members;

    public Team() {
        members = new ArrayList();
    }

    public Team(String id, String projId, ArrayList<String> members) {
        this.id = id;
        this.projId = projId;
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }
}
