package jpl.ch21.ex06;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Concat {
	public void concat(String[] args) throws IOException{
		InputStream in;
		Enumeration<String> files;
		if (args.length == 0) {
			in = System.in;
		} else {
			InputStream fileIn, bufIn;
			List<String> inputs = new ArrayList<>(args.length);
			for (String arg : args) {
				inputs.add(arg);
			}
			files = Collections.enumeration(inputs);
			Enumeration enums = new EnumerationImpl(files);
			in = new SequenceInputStream(enums);

		}
		
		int ch;
		while ((ch = in.read()) != -1) {
			System.out.println(ch);
		}

	}
	
	private class EnumerationImpl implements Enumeration<InputStream> {
		private final Enumeration<String> en;
		
		private EnumerationImpl(Enumeration<String> en) {
			this.en = en;
		}
 		
		@Override
		public boolean hasMoreElements() {
			return en.hasMoreElements();
		}

		@Override
		public InputStream nextElement() {
			if (!en.hasMoreElements()) {
				return null;
			}
			
			InputStream fileIn, bufIn;
			try {
				fileIn = new FileInputStream(en.nextElement());
				bufIn = new BufferedInputStream(fileIn);
				return bufIn;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

}
