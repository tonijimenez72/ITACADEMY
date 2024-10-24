package n1exercise1;

public class Main {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        Worker worker = new Worker("Joan", "Petit", 15.0);
        Online onlineWorker = new Online("Jane", "Doe", 20.0);
        Onsite onsiteWorker = new Onsite("Juan", "Nadie", 18.0);

        int hoursByWeek = 35;

        System.out.println("Base worker's salary: " + worker.calculateSalary(hoursByWeek) + "\n"
                + ANSI_BLUE + "Online worker's salary: " + ANSI_RESET + onlineWorker.calculateSalary(hoursByWeek) + "\n"
                + ANSI_GREEN + "Onsite worker's salary: " + ANSI_RESET + onsiteWorker.calculateSalary(hoursByWeek));
    }
}
