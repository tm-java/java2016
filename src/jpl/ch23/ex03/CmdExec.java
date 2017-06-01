package jpl.ch23.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class CmdExec {
	private InputStream out;
	private InputStreamReader r;
	private BufferedReader in;

	public void cmdExec(String[] cmd, String end) throws IOException {

		// コマンドを開始する
		Process child = Runtime.getRuntime().exec(cmd);
		
		out = child.getInputStream();

		try {
			// コマンドの出力を読み込む
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						r = new InputStreamReader(out);
						in = new BufferedReader(r);
						String line;
						int num = 0;
						while ((line = in.readLine()) != null) {
							System.out.println(num + " : " + line);
							if (line.contains(end)) {
								in.close();
								r.close();
								out.close();
								child.getErrorStream().close();
								child.getOutputStream().close();
								child.destroy();
								return;
							}
							num++;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};

			Thread outThread = new Thread(runnable);
			outThread.start();

			child.waitFor(); 

			outThread.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (r != null) {
				r.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
