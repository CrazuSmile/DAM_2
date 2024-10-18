package com.example;

import java.io.*;

public class Visitaweb {
	public static void main(String[] arg) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);

		System.out.println("Introduzca cadena de urls a enviar:");
		String web = br.readLine();
		in.close();
		String[] webs = web.split("@");

		if (webs.length > 3) {
			System.out.println("ERROR: demasiadas web");
		}

		ProcessBuilder pb = new ProcessBuilder(webs);
		Process p = pb.start();

	}
}
