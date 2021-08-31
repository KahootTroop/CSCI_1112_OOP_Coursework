import java.io.*;
class Programming17_3 {
	public static void main(String[] args) {
		File file = new File("Exercise17_03.dat");
		DataOutputStream write = null;
		DataInputStream read = null;
		int sum = 0;
		read = createFile(file, write, read);
		findSum(sum, read);
	}
	public static void findSum(int sum, DataInputStream read) {
		try {
			try {
				while(true) {
					sum += read.readInt();
				}
			}
			catch(EOFException e) {
				System.out.println(sum);
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	public static DataInputStream createFile(File file, DataOutputStream write, DataInputStream read) {
		try {
			if(file.exists() && !file.isDirectory()) {
				write = new DataOutputStream(new FileOutputStream(new File("Exercise17_03.dat")));
				read = new DataInputStream(new FileInputStream(new File("Exercise17_03.dat")));
			}
			else {
				write = new DataOutputStream(new FileOutputStream("Exercise17_03.dat"));
				read = new DataInputStream(new FileInputStream("Exercise17_03.dat"));
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		try {
			for(int i = 0; i < 100; i++) {
				write.writeInt((int) (Math.random() * 10) + 1);
			}
			write.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return read;
	}
}