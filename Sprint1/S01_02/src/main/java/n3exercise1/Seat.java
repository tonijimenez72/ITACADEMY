package n3exercise1;

public class Seat {
    private int row;
    private int seatNumber;
    private String person;

    public Seat(int row, int seatNumber, String person) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.person = person;
    }

    public int getRow() {
        return row;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public String getPerson() {
        return person;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Seat seat = (Seat) obj;
        return row == seat.row && seatNumber == seat.seatNumber;
    }

    @Override
    public String toString() {
        return "Row: " + row + ", Seat: " + seatNumber + ", Person: " + person;
    }
}