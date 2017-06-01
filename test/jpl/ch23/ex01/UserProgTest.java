package jpl.ch23.ex01;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class UserProgTest {

	@Test
	public void test() throws IOException {
		String cmd = "ls ./src/jpl/ch23/ex01/";
		String expected ="UserProg.java";
		
		StdoutCapture sc = new StdoutCapture();
		sc.start();
				
		Process pro = UserProg.userProg(cmd);
		try {
			pro.waitFor();
			pro.getInputStream().close();
			pro.getOutputStream().close();
			pro.getErrorStream().close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
