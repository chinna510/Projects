package com.biz;

public class SeatReserved {
	public final String letter;
	public final int row;
	public final SeatType seatType;

	public SeatReserved(String letter, int row, SeatType seatType) {
		this.letter = letter;
		this.row = row;
		this.seatType = seatType;
	}

	public Object getLetter() {
		return letter;
	}

	public Object getRow() {
		return row;
	}

	public Object getSeatType() {
		return seatType;
	}
	
}
