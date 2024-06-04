package n3exercise1;

import java.util.ArrayList;
import java.util.List;

public class AllocateSeat {
    private List<Seat> seats;

    public AllocateSeat() {
        seats = new ArrayList<>();
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) throws Exceptions.SeatIsReservedException {
        if (findSeat(seat.getRow(), seat.getSeatNumber()) != -1) {
            throw new Exceptions.SeatIsReservedException("The seat is already reserved.");
        }
        seats.add(seat);
    }

    public void removeSeat(int row, int seatNumber) throws Exceptions.SeatNotReservedException {
        int index = findSeat(row, seatNumber);
        if (index == -1) {
            throw new Exceptions.SeatNotReservedException("The seat is not reserved.");
        }
        seats.remove(index);
    }

    public int findSeat(int row, int seatNumber) {
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getRow() == row && seats.get(i).getSeatNumber() == seatNumber) {
                return i;
            }
        }
        return -1;
    }
}