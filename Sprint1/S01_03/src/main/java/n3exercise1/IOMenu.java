package n3exercise1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class IOMenu {
    private List<Person> people = new ArrayList<>();
    private static final String FILE_NAME = "people.csv";
    private String filePath = System.getProperty("user.dir")  + "/Sprint1/S01_03/src/main/java/n3exercise1/resources/" + FILE_NAME;


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        loadPeopleFromFile();

        int option = -1;
        do {
            System.out.println("\nMenu:\n"
                    + " 1. Add person.\n"
                    + " 2. Show people sorted by name (A-Z).\n"
                    + " 3. Show people sorted by name (Z-A).\n"
                    + " 4. Show people sorted by surname (A-Z).\n"
                    + " 5. Show people sorted by surname (Z-A).\n"
                    + " 6. Show people sorted by DNI (1-9).\n"
                    + " 7. Show people sorted by DNI (9-1).\n"
                    + " 0. Exit.\n"
                    + "Choose an option: ");
            String optionString = scanner.nextLine();

            try {
                option = Integer.parseInt(optionString);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    addPerson(scanner);
                    break;
                case 2:
                    showPeopleSortedBy(Comparator.comparing(Person::getName));
                    break;
                case 3:
                    showPeopleSortedBy(Comparator.comparing(Person::getName).reversed());
                    break;
                case 4:
                    showPeopleSortedBy(Comparator.comparing(Person::getSurname));
                    break;
                case 5:
                    showPeopleSortedBy(Comparator.comparing(Person::getSurname).reversed());
                    break;
                case 6:
                    showPeopleSortedBy(Comparator.comparing(Person::getDni));
                    break;
                case 7:
                    showPeopleSortedBy(Comparator.comparing(Person::getDni).reversed());
                    break;
                case 0:
                    savePeopleToFile();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose another option.");
            }
        } while (option != 0);
    }

    public void loadPeopleFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    people.add(new Person(fields[0], fields[1], fields[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void savePeopleToFile() {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Person person : people) {
                writer.write(String.format("%s,%s,%s\n", person.getName(), person.getSurname(), person.getDni()));
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void addPerson(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter DNI: ");
        String dni = scanner.nextLine();
        people.add(new Person(name, surname, dni));
    }

    public void showPeopleSortedBy(Comparator<Person> comparator) {
        people.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }
}