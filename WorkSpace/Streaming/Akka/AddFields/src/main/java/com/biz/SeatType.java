package com.biz;

public enum SeatType {

	Window("W"), Aisle("A"), Other("O"), Unknown("");

	private final String code;

	private SeatType(String code) {
		this.code = code;
	}

	public static SeatType fromCode(String c) {
		if (Window.code.equals(c))
			return Window;
		else if (Aisle.code.equals(c))
			return Aisle;
		else if (Other.code.equals(c))
			return Other;
		else
			return Unknown;
	}

	
}
