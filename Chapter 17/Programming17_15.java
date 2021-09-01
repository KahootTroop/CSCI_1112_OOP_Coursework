import java.io.*;
import java.util.Scanner;
public class Programming17_15 {
	public static void main(String[] args) throws IOException {
		Scanner user = new Scanner(System.in);
		System.out.println("Enter the name of the file you want decrypted: ");
		File firstFile = new File(user.nextLine());
		if(!firstFile.exists()) {
			System.out.println("Source file " + firstFile + " does not exist");
		}
		System.out.println("Enter the name you want for the decrypted file: ");
		File secondFile = new File(user.nextLine());
		try(
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(firstFile));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(secondFile));
		) {
			int e = 0;
			while((e = input.read()) != -1) {
				output.write((byte)e - 5);
			}
		}
	}
}