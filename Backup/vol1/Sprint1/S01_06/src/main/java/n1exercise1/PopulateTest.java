package n1exercise1;

public class PopulateTest {
    public static String testNoGenericMethods() {
        String result = "";
        NoGenericMethods stringInstance1 = new NoGenericMethods("Go", "Ready", "Steady");
        NoGenericMethods stringInstance2 = new NoGenericMethods("Ready", "Steady", "Go");
        NoGenericMethods stringInstance3 = new NoGenericMethods("Steady", "Go", "Ready");

        result = "Ready: " + stringInstance1.getReady() + "\n"
                + "Steady: " + stringInstance1.getSteady() + "\n"
                + "Go: " + stringInstance1.getGo() + "\n \n"
                + "Steady :" + stringInstance2.getReady() + "\n"
                + "Steady: " + stringInstance2.getSteady() + "\n"
                + "Go: " + stringInstance2.getGo() + "\n \n"
                + "Ready: " + stringInstance3.getReady() + "\n"
                + "Steady: " + stringInstance3.getSteady() + "\n"
                + "Go: " + stringInstance3.getGo();
        return result;
    }
}