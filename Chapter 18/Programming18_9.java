import java.util.Scanner;
class Programming18_9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the string you want to be reversed: ");
		String user = input.nextLine();
		System.out.print("Your String Reversed Is: ");
		reverseDisplay(user);
	}
	public static void reverseDisplay(String value) {
		if(value.length() > 0) {
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1));
		}
	}
}