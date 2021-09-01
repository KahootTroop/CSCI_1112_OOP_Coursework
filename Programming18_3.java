import java.util.Scanner;
class Programming18_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 2 Integers seperated by a space to compute the greatest common divisor");
		int m = input.nextInt();
		int n = input.nextInt();
		int answer = gcd(m, n);
		System.out.println("The greatest common divisor of " + m + " and " + n + " is " + answer);
	}
	public static int gcd(int m, int n) {
		if((m % n) == 0) {
			return n;
		}
		else {
			return gcd(n, (m % n));
		}
	}
}