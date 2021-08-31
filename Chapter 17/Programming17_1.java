import java.io.PrintWriter;
import java.io.*;

public class Programming17_1 {
	public static void main(String[] args) {
		File file = new File("Exercise17_01.txt");
		PrintWriter write = null;
		try {
			if(file.exists() && !file.isDirectory()) {
				write = new PrintWriter(new FileOutputStream(new File("Exercise17_01.txt"), true));
			}
			else {
				write = new PrintWriter("Exercise17_01.txt");
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		for(int i = 0; i < 100; i++) {
			write.append(String.valueOf((int) (Math.random() * 10) + 1) + " ");
		}
		write.close();
	}
}