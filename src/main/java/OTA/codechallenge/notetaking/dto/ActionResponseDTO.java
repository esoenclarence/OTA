package OTA.codechallenge.notetaking.dto;

public class ActionResponseDTO implements DTOI {
    private String actionStatus;

    public ActionResponseDTO(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }
}
