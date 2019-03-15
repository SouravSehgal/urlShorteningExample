package com.sourav.urlshortner.util;

import java.util.ArrayList;
import java.util.List;

public final class Base62Conversion {

	private Base62Conversion() {
		
	}
	
	public static List<Integer> getBase62Conversion(long id) {
		final List<Integer> base62string = new ArrayList<>();
		while (id > 0) {
			final int remainder = (int) id % 62;
			base62string.add(remainder);
			id = id / 62;
		}
		return base62string;
	}
	
	public static void getBase62Number(StringBuilder base62string, int number) {
		switch(number) {
			case 0:
				base62string.append("a");
				break;
			case 1:
				base62string.append("b");
				break;
			case 2:
				base62string.append("c");
				break;
			case 3:
				base62string.append("d");
				break;
			case 4:
				base62string.append("e");
				break;
			case 5:
				base62string.append("f");
				break;
			case 6:
				base62string.append("g");
				break;
			case 7:
				base62string.append("h");
				break;
			case 8:
				base62string.append("i");
				break;
			case 9:
				base62string.append("j");
				break;
			case 10:
				base62string.append("k");
				break;
			case 11:
				base62string.append("l");
				break;
			case 12:
				base62string.append("m");
				break;
			case 13:
				base62string.append("n");
				break;
			case 14:
				base62string.append("o");
				break;
			case 15:
				base62string.append("p");
				break;
			case 16:
				base62string.append("q");
				break;
			case 17:
				base62string.append("r");
				break;
			case 18:
				base62string.append("s");
				break;
			case 19:
				base62string.append("t");
				break;
			case 20:
				base62string.append("u");
				break;
			case 21:
				base62string.append("v");
				break;
			case 22:
				base62string.append("w");
				break;
			case 23:
				base62string.append("x");
				break;
			case 24:
				base62string.append("y");
				break;
			case 25:
				base62string.append("z");
				break;
			case 26:
				base62string.append("A");
				break;
			case 27:
				base62string.append("B");
				break;
			case 28:
				base62string.append("C");
				break;
			case 29:
				base62string.append("D");
				break;
			case 30:
				base62string.append("E");
				break;
			case 31:
				base62string.append("F");
				break;
			case 32:
				base62string.append("G");
				break;
			case 33:
				base62string.append("H");
				break;
			case 34:
				base62string.append("I");
				break;
			case 35:
				base62string.append("J");
				break;
			case 36:
				base62string.append("K");
				break;
			case 37:
				base62string.append("L");
				break;
			case 38:
				base62string.append("M");
				break;
			case 39:
				base62string.append("N");
				break;
			case 40:
				base62string.append("O");
				break;
			case 41:
				base62string.append("P");
				break;
			case 42:
				base62string.append("Q");
				break;
			case 43:
				base62string.append("R");
				break;
			case 44:
				base62string.append("S");
				break;
			case 45:
				base62string.append("T");
				break;
			case 46:
				base62string.append("U");
				break;
			case 47:
				base62string.append("V");
				break;
			case 48:
				base62string.append("W");
				break;
			case 49:
				base62string.append("X");
				break;
			case 50:
				base62string.append("Y");
				break;
			case 51:
				base62string.append("Z");
				break;
			case 52:
				base62string.append("0");
				break;
			case 53:
				base62string.append("1");
				break;
			case 54:
				base62string.append("2");
				break;
			case 55:
				base62string.append("3");
				break;
			case 56:
				base62string.append("4");
				break;
			case 57:
				base62string.append("5");
				break;
			case 58:
				base62string.append("6");
				break;
			case 59:
				base62string.append("7");
				break;
			case 60:
				base62string.append("8");
				break;
			case 61:
				base62string.append("9");
				break;
			default: 
				break;
		}
	}
	
	public static long getDecimalNumber(long number,char ch, int position) {
		switch(ch) {
			case 'a':
				number += 0 * Math.pow(62, position);
				break;
			case 'b':
				number += 1 * Math.pow(62, position);
				break;
			case 'c':
				number += 2 * Math.pow(62, position);
				break;
			case 'd':
				number += 3 * Math.pow(62, position);
				break;
			case 'e':
				number += 4 * Math.pow(62, position);
				break;
			case 'f':
				number += 5 * Math.pow(62, position);
				break;
			case 'g':
				number += 6 * Math.pow(62, position);
				break;
			case 'h':
				number += 7 * Math.pow(62, position);
				break;
			case 'i':
				number += 8 * Math.pow(62, position);
				break;
			case 'j':
				number += 9 * Math.pow(62, position);
				break;
			case 'k':
				number += 10 * Math.pow(62, position);
				break;
			case 'l':
				number += 11 * Math.pow(62, position);
				break;
			case 'm':
				number += 12 * Math.pow(62, position);
				break;
			case 'n':
				number += 13 * Math.pow(62, position);
				break;
			case 'o':
				number += 14 * Math.pow(62, position);
				break;
			case 'p':
				number += 15 * Math.pow(62, position);
				break;
			case 'q':
				number += 16 * Math.pow(62, position);
				break;
			case 'r':
				number += 17 * Math.pow(62, position);
				break;
			case 's':
				number += 18 * Math.pow(62, position);
				break;
			case 't':
				number += 19 * Math.pow(62, position);
				break;
			case 'u':
				number += 20 * Math.pow(62, position);
				break;
			case 'v':
				number += 21 * Math.pow(62, position);
				break;
			case 'w':
				number += 22 * Math.pow(62, position);
				break;
			case 'x':
				number += 23 * Math.pow(62, position);
				break;
			case 'y':
				number += 24 * Math.pow(62, position);
				break;
			case 'z':
				number += 25 * Math.pow(62, position);
				break;
			case 'A':
				number += 26 * Math.pow(62, position);
				break;
			case 'B':
				number += 27 * Math.pow(62, position);
				break;
			case 'C':
				number += 28 * Math.pow(62, position);
				break;
			case 'D':
				number += 29 * Math.pow(62, position);
				break;
			case 'E':
				number += 30 * Math.pow(62, position);
				break;
			case 'F':
				number += 31 * Math.pow(62, position);
				break;
			case 'G':
				number += 32 * Math.pow(62, position);
				break;
			case 'H':
				number += 33 * Math.pow(62, position);
				break;
			case 'I':
				number += 34 * Math.pow(62, position);
				break;
			case 'J':
				number += 35 * Math.pow(62, position);
				break;
			case 'K':
				number += 36 * Math.pow(62, position);
				break;
			case 'L':
				number += 37 * Math.pow(62, position);
				break;
			case 'M':
				number += 38 * Math.pow(62, position);
				break;
			case 'N':
				number += 39 * Math.pow(62, position);
				break;
			case 'O':
				number += 40 * Math.pow(62, position);
				break;
			case 'P':
				number += 41 * Math.pow(62, position);
				break;
			case 'Q':
				number += 42 * Math.pow(62, position);
				break;
			case 'R':
				number += 43 * Math.pow(62, position);
				break;
			case 'S':
				number += 44 * Math.pow(62, position);
				break;
			case 'T':
				number += 45 * Math.pow(62, position);
				break;
			case 'U':
				number += 46 * Math.pow(62, position);
				break;
			case 'V':
				number += 47 * Math.pow(62, position);
				break;
			case 'W':
				number += 48 * Math.pow(62, position);
				break;
			case 'X':
				number += 49 * Math.pow(62, position);
				break;
			case 'Y':
				number += 50 * Math.pow(62, position);
				break;
			case 'Z':
				number += 51 * Math.pow(62, position);
				break;
			case '0':
				number += 52 * Math.pow(62, position);
				break;
			case '1':
				number += 53 * Math.pow(62, position);
				break;
			case '2':
				number += 54 * Math.pow(62, position);
				break;
			case '3':
				number += 55 * Math.pow(62, position);
				break;
			case '4':
				number += 56 * Math.pow(62, position);
				break;
			case '5':
				number += 57 * Math.pow(62, position);
				break;
			case '6':
				number += 58 * Math.pow(62, position);
				break;
			case '7':
				number += 59 * Math.pow(62, position);
				break;
			case '8':
				number += 60 * Math.pow(62, position);
				break;
			case '9':
				number += 61 * Math.pow(62, position);
				break;
			default: 
				break;
		}
		return number;
	}
}