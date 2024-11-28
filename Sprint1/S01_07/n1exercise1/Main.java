package n1exercise1;

public class Main {
    public static void main(String[] args) {
        OnlineWorker onlineWorker = new OnlineWorker("Jane", "Doe", 20.0);
        OnsiteWorker onsiteWorker = new OnsiteWorker("Joana", "Petita", 18.0);

        int hoursByWeek = 35;

        System.out.println("Weekly salaries:");
        System.out.println(onlineWorker + " (Online Worker): " + onlineWorker.calculateSalary(hoursByWeek) + "€");
        System.out.println(onsiteWorker + " (Onsite Worker): " + onsiteWorker.calculateSalary(hoursByWeek) + "€");
    }
}