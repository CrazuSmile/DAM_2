package com.example;

import java.io.*;

public class Visitaweb {
	public static void main(String[] arg) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		ProcessBuilder pb = null;
		try {
			String web = br.readLine();
			in.close();
			String[] webs = web.split("@");

			if (webs.length > 3) {
				System.out.println("ERROR: demasiadas web");
			}

			// switch (webs.length) {
			// case 1:
			// pb = new ProcessBuilder("firefox", webs[0]);
			// break;
			// case 2:
			// pb = new ProcessBuilder("firefox", webs[0], webs[1]);
			// break;
			// case 3:
			// pb = new ProcessBuilder("firefox", webs[0], webs[1], webs[2]);
			// default:
			// System.out.println("No has introducido ninguna pagina");
			// break;
			// }
			// Process p = pb.start();

			for (String url : webs) {
				pb = new ProcessBuilder("firefox", url);
				Process p = pb.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
