package coreplatform.quickreview;

public class Operators {

	/**
	 * Using unusual operators like:
	 * a = 0011 1100
	 * b = 0000 1101
	 * ~ Bitwise compliment - flipping bits - ~a = 1100 0011
	 * & Bitwise and - copies a bit to the result if it exists in both operands a & b = 0000 1100
	 * | Bitwise or - copies a bit to the result if it exists in either operand a & b = 0011 1101
	 * ^ Bitwise XOR - copies the bit if it is set in one operand but not both - a ^ b = 0011 0001
	 * >> moves to the right the bits
	 * << moves to the left the bits
	 * >>> zero fill right shift - left moves to right and shifted values are filled up with zeros
	 */
	public static void usingOperators() {
		byte a = 60;
		byte b = 13;
		System.out.println(~a);
		System.out.println(a|b);
		System.out.println(a&b);
		System.out.println(a<<2);
		System.out.println(a>>2);
		System.out.println(Integer.toBinaryString(a));
	}
}
