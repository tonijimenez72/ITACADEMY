package scapeRoom.room;

enum DifficultyLevel {
    NOOB, PLAYER, PRO;

    public String getDifficultyLevel() {
        switch (this) {
            case NOOB:
                return "NOOB";
            case PLAYER:
                return "PLAYER";
            case PRO:
                return "PRO";
            default:
                return null;
        }
    }
}
