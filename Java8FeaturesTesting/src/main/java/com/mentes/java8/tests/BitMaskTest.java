package com.mentes.java8.tests;

import java.util.HashMap;

public class BitMaskTest {

	public static void main(String args[]) {
		
		int number =5; //0101
		int pos = 2;
		
		//AND operation
		getBit(number, pos); 
		getBit(7, pos); //0111
		
		//OR operation
		setBit(number, 1); //0111 0 to 1 
		setBit(7, 3); //0111
		
		//Not and AND operation
		clearBit(5, 2); //0101 -> 0001 (5) bit values 128,64,32,16 - 8,4,2,1
		clearBit(7, 1); //0111 -> 0101
		
		//updateBit
		updateBit(15, 3); //1111 -> update to 0111->7
		updateBit(15, 1); //1111 -> update to 1110->13
		updateBit(15, 2); //1111 -> update to 1011->11
		updateBit(15, 0); //1111 -> update to 1110->14
		
		
	}
	
	public static int getBit(int number, int pos) {
		
		int bitmask =1<<pos;
		
		if((bitmask & number) == 0) {
			System.out.println("Bit for number "+ number +" @pos " + pos + " was zero");
			
			return 0;
		} else System.out.println("Bit for number "+ number +" @pos " + pos + " was one");
		
		return 1;
	}
	
   public static void setBit(int number, int pos) {
		
		int bitmask =1<<pos;
		
		System.out.println("New Number is "+ (bitmask | number));
	}
   
   public static void clearBit(int number, int pos) {
		
		int bitmask =1<<pos;
		int notBit = ~bitmask;
		System.out.println("CLear mask "+ (notBit & number));
	}
   
   public static void updateBit(int number, int pos) {
		System.out.println("\n update Bit..\n");
		if(getBit(number, pos) ==0) {
			setBit(number, pos);
		} else {
			clearBit(number, pos);
		}
	}
}
