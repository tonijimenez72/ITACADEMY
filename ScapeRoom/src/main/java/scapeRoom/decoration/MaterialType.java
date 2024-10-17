package scapeRoom.decoration;

public enum MaterialType {
    Wood, Metal, Plastic, Glass;

    public String getMaterialType() {
        switch (this) {
            case Wood:
                return "Wood";
            case Metal:
                return "Metal";
            case Plastic:
                return "Plastic";
            case Glass:
                return "Glass";
            default:
                return null;
        }
    }
}
