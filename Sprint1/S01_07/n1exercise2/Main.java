package n1exercise2;

public class Main {
    @SuppressWarnings("deprecation")

    public static void main(String[] args) {
        OnlineWorker onlineWorker = new OnlineWorker("Jane", "Doe", 20.0);
        OnsiteWorker onsiteWorker = new OnsiteWorker("Joana", "Petita", 18.0);

        int hoursByWeek = 35;

        System.out.println("Weekly salaries:");
        System.out.println(onlineWorker + " (Online Worker): " + onlineWorker.calculateSalary(hoursByWeek) + "€");
        System.out.println(onsiteWorker + " (Onsite Worker): " + onsiteWorker.calculateSalary(hoursByWeek) + "€");

        onlineWorker.deprecate();
        onsiteWorker.deprecate();
    }
}