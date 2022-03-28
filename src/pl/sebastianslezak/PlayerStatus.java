package pl.sebastianslezak;

public enum PlayerStatus {

    HUMAN("Human"),
    ROBOT("Robot");

    private final String status;

    PlayerStatus(String name) {
        this.status = name;
    }

    public String getStatus() {
        return status;
    }
}
