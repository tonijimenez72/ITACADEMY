package n1exercise2;

public class Main {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Worker worker = new Worker("Joan", "Petit", 15.0);
        Online onlineWorker = new Online("Jane", "Doe", 20.0);
        Onsite onsiteWorker = new Onsite("Juan", "Nadie", 18.0);

        int hoursByWeek = 35;

        System.out.println("Base worker's salary: " + worker.calculateSalary(hoursByWeek) + "\n"
                + ANSI_BLUE + "Online worker's salary: " + ANSI_RESET + onlineWorker.calculateSalary(hoursByWeek) + "\n"
                + ANSI_GREEN + "Onsite worker's salary: " + ANSI_RESET + onsiteWorker.calculateSalary(hoursByWeek) + "\n\n"
                + ANSI_YELLOW + "Deprecated: " + ANSI_RESET + onlineWorker.deprecate() + "\n"
                + ANSI_YELLOW + "Deprecated: " + ANSI_RESET +  onsiteWorker.deprecate());
    }
}

