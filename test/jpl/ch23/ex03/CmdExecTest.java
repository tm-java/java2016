package jpl.ch23.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class CmdExecTest {

	@Test
	public void test() throws Exception {
		CmdExec test = new CmdExec();
		String[] cmd = {"ping", "-c", "100", "localhost"};
		String end = "3";
		String[] expected = {};
		//StdoutCapture sc = new StdoutCapture();
		//sc.start();
		
		test.cmdExec(cmd, end);
		
		//sc.stop();
		//sc.assertEquals(expected);
	}

}
