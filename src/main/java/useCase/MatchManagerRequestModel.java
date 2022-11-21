package useCase;

// Use case layer

public class MatchManagerRequestModel {

    private String p1_id;
    private String p2_id;
    private boolean p1_owner_decision;

    public MatchManagerRequestModel(String p1_id, String p2_id, boolean p1_owner_decision) {
        this.p1_id = p1_id;
        this.p2_id = p2_id;
        this.p1_owner_decision = p1_owner_decision;
    }

    public String getP1_id() {
        return p1_id;
    }

    public String getP2_id() {
        return p2_id;
    }

    public boolean isP1_owner_decision() {
        return p1_owner_decision;
    }

    public void setP1_id(String p1_id) {
        this.p1_id = p1_id;
    }

    public void setP2_id(String p2_id) {
        this.p2_id = p2_id;
    }

    public void setP1_owner_decision(boolean p1_owner_decision) {
        this.p1_owner_decision = p1_owner_decision;
    }
}
