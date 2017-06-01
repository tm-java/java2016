package jpl.ch24.ex01;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {
	public static void main(String[] args) {
		File dir = Paths.get("/src/jpl/ch24/ex01").toFile();
		URLClassLoader urlLoader = null;
		try {
			urlLoader = new URLClassLoader(new URL[]{dir.toURI().toURL()});
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		ResourceBundle res = ResourceBundle.getBundle("GlobalRes", Locale.ENGLISH, urlLoader);
		String msg;
		if (args.length > 0) {
			msg = res.getString(GlobalRes.GOODBYE);
		} else {
			msg = res.getString(GlobalRes.HELLO);
		}
		System.out.println(msg);
		
	}

}
