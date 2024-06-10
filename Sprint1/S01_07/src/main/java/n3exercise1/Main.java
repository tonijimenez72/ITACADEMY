package n3exercise1;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Jane Doe");
        user.setIdCard("87654321Z");

        SerializeUser.serializeObject(user);
    }
}
