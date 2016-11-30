package jpl.ch06.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;
import jpl.ch06.ex03.Verbose.Level;

public class VerboseImplTest {

	@Test
	public void testLevel() {
		Verbose test = new VerboseImpl();
		
		for(Level l: Level.values()){
			test.setVerbosity(l);
			assertEquals(l,test.getVerbosity());
		}
	}
	
	@Test
	public void testMain(){
		String[] expected = new String[] {"SILENT",
		"TERSE",
		"NORMAL",
		"VERBOSE"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		VerboseImpl.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
