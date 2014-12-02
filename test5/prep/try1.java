// http://apcomputersciencetutoring.com/exam-review/flight-free-response-practice-question/

// Part a).

public ArrayList<String> frequentFlyers() {
	ArrayList<String> frequentFlyersList = new ArrayList<String>();
	for (int i = 0 ; i < rows ; i++) {
		for (int a = 0 ; a < seatsPerRow ; a++) {
			if (seats[i][a] != null && seats[i][a].isFrequentFlyer()) {
				frequentFlyersList.add(seats[i][a].passengerName());
			}
		}
	}
	return frequentFlyersList;
}

// Part b).

public boolean reserveAdjacentSeats(String passOneName, String passTwoName) {
	for (int rowNum = 0 ; rowNum < rows ; rowNum++) {
		for (int seatNum = 0 ; seatNum < seatsPerRow - 1 ; seatNum++) {
			if (seats[rowNum][seatNum] == null && seats[rowNum][seatNum + 1] == null) {
				seats[rowNum][seatNum] = new Reservation(passOneName);
				seats[rowNum][seatNum + 1] = new Reservation(passTwoName);
				return true;
			}
		}
	}
	return false;
}

// Part c).

public boolean reserveWindowSeats(String passengerName) {
	for (int rowNum = 0 ; rowNum < rows ; rowNum++) {
		if (seats[rowNum][0] == null) {
			seats[rowNum][0] = new Reservation(passengerName);
			return true;
		}
		else if (seats[rowNum][seatsPerRow - 1] == null) {
			seats[rowNum][seatsPerRow - 1] = new Reservation(passengerName);
			return true;
		}
	}
	return false;
}

// Part d).

public ArrayList<String> isolatedPassengers() {
	ArrayList<String> isolatedList = new ArrayList<String>();
	for (int rowNum = 0 ; rowNum < rows ; rowNum++) {
		if (seats[rowNum][0] != null && seats[rowNum][1] == null) { // First
			isolatedList.add(seats[rowNum][0].passengerName());
		}
		for (int seatNum = 1 ; seatNum < seatsPerRow - 1 ; seatNum++) { // Everything Else
			if (seats[rowNum][seatNum] != null && seats[rowNum][seatNum - 1] == null && seats[rowNum][seatNum + 1] == null) {
				isolatedList.add(seats[rowNum][seatNum].passengerName());
			}
		}
		if (seats[rowNum][seatsPerRow - 1] != null && seats[rowNum][seatsPerRow - 2] == null) { // Last
			isolatedList.add(seats[rowNum][0].passengerName());
		}

	}
	return isolatedList;
}
