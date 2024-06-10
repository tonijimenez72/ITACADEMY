package n3exercise1;

public class User {
    @JSONSerialize(directory = "Sprint1/S01_07/src/main/java/n3exercise1/output")
    private String name;

    @JSONSerialize(directory = "Sprint1/S01_07/src/main/java/n3exercise1/output")
    private String idCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String serialize() {
        return "Name: " + name + ", ID Card: " + idCard;
    }
}
