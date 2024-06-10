package n2exercise1;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("John Doe");
        user.setIdCard("12345678A");

        SerializeUser.serializeObject(user);
    }
}
