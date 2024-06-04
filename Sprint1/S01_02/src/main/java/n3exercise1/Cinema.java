package n3exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {
    public static final String ANSI_BRED = "\u001B[91m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private byte numRows;
    private byte numSeatsPerRow;
    private AllocateSeat allocateSeat;

    public Cinema() {
        allocateSeat = new AllocateSeat();
        askInitialData();
    }
    public void start() {
        while (true) {
            int option = menu();
            switch (option) {
                case 0:
                    return;
                case 1:
                    showSeatsByRow();
                    break;
                case 2:
                    showSeatsByPerson();
                    break;
                case 3:
                    reserveSeat();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    cancelReservationByPerson();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIT Academy Cinema\n"
                + " 1.- Show all reserved seats.\n"
                + " 2.- Show reserved seats by person.\n"
                + " 3.- Reserve a seat.\n"
                + " 4.- Cancel reservation of a seat.\n"
                + " 5.- Cancel all reservations of a person.\n"
                + " 0.- Exit.\n"
                + "Choose an option: ");
        return scanner.nextInt();
    }

    private void showAllSeats() {
        allocateSeat.getSeats().forEach(System.out::println);
    }

    private void showSeatsByPerson() {
        try {
            String person = inputPerson();
            allocateSeat.getSeats().stream()
                    .filter(s -> s.getPerson().equalsIgnoreCase(person))
                    .forEach(System.out::println);
        } catch (Exceptions.InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }

    private void reserveSeat() {
        try {
            String person = inputPerson();
            byte row = inputRow();
            byte numSeatsToReserve = inputNumSeatsToReserve();
            for (int i = 0; i < numSeatsToReserve; i++) {
                byte seatNumber = inputSeatNumber();
                if (row < 1 || row > numRows || seatNumber < 1 || seatNumber > numSeatsPerRow) {
                    throw new IllegalArgumentException("Invalid row or seat number.");
                }
                allocateSeat.addSeat(new Seat(row, seatNumber, person));
            }
        } catch (Exceptions.InvalidRowException | Exceptions.InvalidSeatNumberException | Exceptions.InvalidPersonNameException | Exceptions.SeatIsReservedException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelReservation() {
        try {
            byte row = inputRow();
            byte seatNumber = inputSeatNumber();
            allocateSeat.removeSeat(row, seatNumber);
        } catch (Exceptions.InvalidRowException | Exceptions.InvalidSeatNumberException | Exceptions.SeatNotReservedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelReservationByPerson() {
        try {
            String person = inputPerson();
            allocateSeat.getSeats().removeIf(s -> s.getPerson().equalsIgnoreCase(person));
        } catch (Exceptions.InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }

    private void askInitialData() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Number of rows (5-30): ");
                numRows = Exceptions.validateInputByte(scanner.nextByte(), 5, 30);
                validInput = true;
            } catch (Exceptions.InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();
            }
        }

        validInput = false;

        while (!validInput) {
            try {
                System.out.print("Number of seats per row (10-30): ");
                numSeatsPerRow = Exceptions.validateInputByte(scanner.nextByte(), 10, 30);
                validInput = true;
            } catch (Exceptions.InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();
            }
        }
    }

    private byte inputRow() throws Exceptions.InvalidRowException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Row number: ");
        byte row = scanner.nextByte();
        if (row < 1 || row > numRows) {
            throw new Exceptions.InvalidRowException("Invalid row number.");
        }
        return row;
    }

    private byte inputSeatNumber() throws Exceptions.InvalidSeatNumberException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seat number: ");
        byte seatNumber = scanner.nextByte();
        if (seatNumber < 1 || seatNumber > numSeatsPerRow) {
            throw new Exceptions.InvalidSeatNumberException("Invalid seat number.");
        }
        return seatNumber;
    }

    private byte inputNumSeatsToReserve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of seats to reserve: ");
        return scanner.nextByte();
    }

    private String inputPerson() throws Exceptions.InvalidPersonNameException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Person's name: ");
        String person = scanner.next();
        if (!person.matches("[a-zA-Z]+")) {
            throw new Exceptions.InvalidPersonNameException("Invalid person's name. Name should contain only letters without accents or spaces.");
        }
        return person;
    }

    private void showSeatsByRow() {
        for (byte row = 1; row <= numRows; row++) {
            System.out.print("Row " + row + ": ");
            for (byte seatNumber = 1; seatNumber <= numSeatsPerRow; seatNumber++) {
                if (isSeatReserved(row, seatNumber)) {
                    System.out.print(ANSI_BRED + " " + seatNumber + " " + ANSI_RESET);
                } else {
                    System.out.print(ANSI_GREEN + " " + seatNumber + " " + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    private boolean isSeatReserved(byte row, byte seatNumber) {
        for (Seat seat : allocateSeat.getSeats()) {
            if (seat.getRow() == row && seat.getSeatNumber() == seatNumber) {
                return true;
            }
        }
        return false;
    }
}