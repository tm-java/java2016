package jpl.ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UserProg {
	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	private static void plugTogether(InputStream from, OutputStream to) throws IOException {

		Runnable rn = new Runnable() {
			@Override
			public void run() {
				int c;
				try {
					while ((c = from.read()) != -1) {
						to.write(c);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		};

		Thread th = new Thread(rn);
		th.start();
	}

	private static void plugTogether(OutputStream to, InputStream from) throws IOException {
		plugTogether(from, to);
	}

}
