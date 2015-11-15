package foxman.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private HashMap<String, Boolean> seats;
	private int rows;
	private int columns;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {

		this.seats = new HashMap<String, Boolean>();

		this.rows = rows;
		this.columns = columns;

		for (int row = 0; row < rows; row++) {

			for (int col = 65; col < 65 + columns; col++) {
				StringBuilder seat = new StringBuilder();
				seat.append(String.valueOf((char) col) + (row + 1));
				seats.put(seat.toString(), false);
			}

		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException,
			SeatOutOfBoundsException {

		if (seats.containsKey(seatName)) {
			if (seats.get(seatName) == false) {
				seats.put(seatName, true);
			} else {
				throw new AlreadyReservedException();
			}
		} else {
			throw new SeatOutOfBoundsException();
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return (seats.get(seatName));

	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */

	public void reserveAll(String... seatNames)
			throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD\n 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		int countRows = 1;
		int countColumns = 0;
		builder.append("  ");
		for (int col = 65; col < 65 + this.columns; col++) {
			builder.append(String.valueOf((char) col));
		}
		builder.append("\n");
		builder.append("1 ");

		for (Map.Entry<String, Boolean> entry : seats.entrySet()) {

			if (countColumns == this.columns) {
				countRows++;
				builder.append("\n");
				builder.append(countRows + " ");
				countColumns = 0; // reset the columns to zero
			}

			if (entry.getValue()) {
				builder.append("#");
			} else {
				builder.append("o");
			}
			countColumns++;
		}
		builder.append("\n");

		return builder.toString();

	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 * @throws SeatOutOfBoundsException
	 * @throws AlreadyReservedException
	 */

	// call reserve..after they reserveGroup
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException, AlreadyReservedException,
			SeatOutOfBoundsException {

		ArrayList<String> seatsTogether = new ArrayList<String>();

		// if they request seats together which are more than rows, throw
		// NotEnoughSeatsException
		if (numberOfSeatsTogether > this.columns) {
			throw new NotEnoughSeatsException();
		}

		int seatsAvailable = 0;

		for (int row = 0; row < this.rows; row++) {
			seatsAvailable = 0;
			for (int col = 65; col < 65 + this.columns; col++) {
				StringBuilder seat = new StringBuilder();
				seat.append(String.valueOf((char) col) + (row + 1));
				
				if (seats.get(seat.toString()) == false) {
					seatsTogether.add(seat.toString());
					seatsAvailable++;
				} else {
					break;
				}

			} //end inner
			
			if (seatsAvailable == numberOfSeatsTogether) {
				for (String reservedSeat : seatsTogether) {
					reserve(reservedSeat);
				}

			return seatsTogether;
		}
		}//end outer
		
		
		

		throw new NotEnoughSeatsException();

	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		boolean full = true;
		for (Map.Entry<String, Boolean> entry : seats.entrySet()) {
			if (entry.getValue() == false) {
				full = false;
				return full;
			}
		}

		return full;

	}

	public static void main(String[] args) throws AlreadyReservedException,
			SeatOutOfBoundsException, NotEnoughSeatsException {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		seats.reserve("A1");
		seats.reserveGroup(4);
		System.out.println(seats.seats);
		System.out.println(seats.toString());
	}
}
