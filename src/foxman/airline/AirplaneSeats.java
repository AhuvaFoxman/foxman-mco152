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

	private HashMap<String, Integer> seats;
	private int rows;
	private int columns;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {

		this.rows = rows;
		this.columns = columns;
		String[] alphabet = new String[] { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		String key;
		Integer value = null;
		this.seats = new HashMap<String, Integer>();
		for (int i = 0; i < columns - 1; i++) {
			key = alphabet[i];

			for (int k = 1; k < rows; k++) {
				value = k;
			}
			seats.put(key, value);
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
		String[] seat = new String[1];
		seatName.split("[A-Z]*");

		String key;
		Integer value;
		if (seat[0].matches("[A-Z]*")) {
			key = seat[0];
			value = Integer.parseInt(seat[1]);

			for (Map.Entry<String, Integer> entry : seats.entrySet()) {
				if ((entry.getKey() == key) && (entry.getValue() == value)) {
					// then it is in the hashmap and could be removed
					seats.remove(key, value); // remove it from the Hashmap once
												// it is reserved

				}
			}
			// if it didnt find it in the hashmap, then throw an exception
			if (!(seats.containsKey(key) && !(seats.containsValue(value)))) {
				throw new AlreadyReservedException();
			}
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		String[] seat = new String[1];
		seatName.split("[A-Z]*");

		String key = null;
		Integer value = null;
		if (seat[0].matches("[A-Z]*")) {
			key = seat[0];
			value = Integer.parseInt(seat[1]);
		}
		if (!(seats.containsKey(key) && !(seats.containsValue(value)))) {
			return true;
		} else {
			return false;
		}

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
		String[] alphabet = new String[] { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };

		for (int k = 0; k < columns - 1; k++) {
			builder.append(" " + alphabet[k]);
		}
		String key = null;
		Integer value = null;
		for (int i = 1; i < rows; i++) {
			value = i;
			builder.append("\n" + i + " ");

			for (int k = 0; k < columns - 1; k++) {
				key = alphabet[k];

				if (!(seats.containsKey(key)) && !(seats.containsValue(value))) {
					builder.append("# ");
				} else {
					builder.append("o ");
				}
			}
			builder.append("\n");
		}

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
		String[] alphabet = new String[] { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };

		ArrayList<String> seatsInARow = new ArrayList<String>();

		StringBuilder builder = new StringBuilder();
		String key = null;
		Integer value = null;
		int count = 0;

		for (int k = 0; k < columns - 1; k++) {
			key = alphabet[k];

			for (int i = 1; i < rows; i++) {
				value = i;
				if ((seats.get(key) != null) && (seats.get(key) == value)) {

					count++;
				}

			}
			if (count >= numberOfSeatsTogether) {
				builder.append(key + String.valueOf(value));
				reserve(builder.toString());
				seatsInARow.add(key + String.valueOf(value));
			} else {
				throw new AlreadyReservedException();
			}
		}

		return seatsInARow;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		if (seats.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		seats.reserve("A1");
		System.out.println(seats.toString());
	}

}
