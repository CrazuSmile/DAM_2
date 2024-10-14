import java.io.*;


public class Test {
	private static Process p;
	public static void main(String[] arg) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("firefox");
		p = pb.start();
	}
}
