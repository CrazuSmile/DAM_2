import java.io.*;


public class Test2 {
	private static Process p;
	public static void main(String[] arg) throws IOException {
		File directorio = new File("/home/juasanlop2/Escriptori/DAM2/DAM_2/PSP/UD1/src/main/java");
		
		ProcessBuilder pb = new ProcessBuilder("java", "Test.java");
		pb.directory(directorio);
		p = pb.start();
	}
}
