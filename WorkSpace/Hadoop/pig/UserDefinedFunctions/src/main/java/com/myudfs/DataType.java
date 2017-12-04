package com.myudfs;

public class DataType {
	public static final byte UNKNOWN = 0;
	public static final byte NULL = 1;
	public static final byte BOOLEAN = 5; // internal use only
	public static final byte BYTE = 6; // internal use only
	public static final byte INTEGER = 10;
	public static final byte LONG = 15;
	public static final byte FLOAT = 20;
	public static final byte DOUBLE = 25;
	public static final byte DATETIME = 30;
	public static final byte BYTEARRAY = 50;
	public static final byte CHARARRAY = 55;
	public static final byte BIGINTEGER = 65;
	public static final byte BIGDECIMAL = 70;
	public static final byte MAP = 100;
	public static final byte TUPLE = 110;
	public static final byte BAG = 120;
	public static final byte ERROR = -1;
}
