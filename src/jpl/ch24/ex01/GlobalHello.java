package jpl.ch24.ex01;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {
	public static void main(String[] args) {
		
		ResourceBundle res = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes");
		String msg;
		if (args.length > 0) {
			msg = res.getString(GlobalRes.GOODBYE);
		} else {
			msg = res.getString(GlobalRes.HELLO);
		}
		System.out.println(msg);
	}

}
