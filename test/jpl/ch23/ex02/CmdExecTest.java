package jpl.ch23.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class CmdExecTest {

	@Test
	public void test() throws Exception {
		CmdExec test = new CmdExec();
		String[] cmd = {"ls", "./src/jpl/ch23/ex02/"};
		String expected = "0 : CmdExec.java";
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		test.cmdExec(cmd);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
