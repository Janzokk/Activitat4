package metodes2JanPerez;

import java.util.Scanner;
/**
 * 
 * @author jpg
 * This code want to write a number (keyboard input) in Catalan.
 */
public class metodes2_3 {
/**
 * 
 * @param args
 * It ask for a number and depending on the length of it, calls to different methods
 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean check = false, end = false;
		int num = 0, temp = 0;

		while (!end) {
			//Validator of the number
			while (!check) {
				check = true;
				try {
					System.out.print("Escriu un numero del 1 al 10000 (negatiu per tancar): ");
					num = in.nextInt();
					if(num>10000) {
						System.err.println("Error: ha de ser inferior a 10000");
						check = false;
					}
				} catch (Exception e) {
					System.err.println("Error: ha de ser un int");
					in.next();
					check = false;
				}
			}
			check = false;
			//Ends the program if the number is negative
			if (num < 0) {
				end = true;
			} else {
				//Depens of the length of the number it syso diferent things
				switch (lengthcheck(num)) {
				case 1:
					System.out.println(units(num));
					break;
				case 2:
					printtens(num);
					break;
				case 3:
					printcents(num);
					printtens(num);
					break;
				case 4:
					//Checks the thousand digit and syso diferent depending of if its 1 or anything else
					temp = num / 1000 % 10;
					if (temp == 1) {
						System.out.print("mil ");
					} else {
						System.out.print(units(temp) + " mil ");
					}
					printcents(num);
					printtens(num);
					break;
				case 5:
					System.out.println("deu mil");
					break;
				}
			}
		}
		in.close();

	}
/**
 * 
 * @param n Is a number
 * @return The length of the number
 */
	public static int lengthcheck(int n) {
		//Check the number of digits the number has
		int length = 0;
		int temp = 1;
		while (temp <= n) {
			length++;
			temp *= 10;
		}
		return length;
	}
/**
 * 
 * @param n Is a digit
 * @return The writen Catalan digit
 */
	public static String units(int n) {
		//Returns a writen number depending of the units digit
		String units = "";
		String[] unitstext = { "un", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit", "nou", "deu" };

		if (n != 0) {
			units += unitstext[n - 1];
		}

		return units;
	}
/**
 * 
 * @param n Is a ten
 * @return The writen Catalan ten
 */
	public static String tens(int n) {
		//Returns a writen nubmer depending of the tens digit
		String tens = "";
		String[] tentenstext = { "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "diset", "divuit",
				"dinou" };
		String[] tenstext = { "deu", "vint", "trenta", "quaranta", "cincuanta", "sixanta", "setanta", "vuitanta",
				"noranta" };

		if (n / 10 % 10 == 1) {
			tens += tentenstext[n % 10];
		} else {
			tens += tenstext[n - 1];
		}

		return tens;
	}
/**
 * 
 * @param n is a ten
 * It prints the writen Catalan tens because they have some cases that make it different
 */
	public static void printtens(int n) {
		//Print the tens depending on the result at (tens)
		int temp = n / 10 % 10;
		if (n / 10 % 10 == 0) {
			System.out.println(units(n % 10));
		} else if (n % 10 == 0) {
			System.out.println(tens(temp));
		} else if (temp == 1) {
			System.out.println(tens(n));
		} else if (temp == 2) {
			System.out.println(tens(temp) + "-i-" + units(n % 10));
		} else {
			System.out.println(tens(temp) + "-" + units(n % 10));
		}
	}
/**
 * 
 * @param n Is a cent
 * It prints the writen Catalan cents because they have some cases that make it different
 */
	public static void printcents(int n) {
		//Print the cents
		int temp = n / 100 % 10;
		if (temp == 1) {
			System.out.print("cent ");
		} else if (temp != 0) {
			System.out.print(units(temp) + "-cents ");
		}
	}

}