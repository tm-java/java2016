package java8.ch03.ex21;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class MyStreamTest {

	@Test
	public void test() throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newCachedThreadPool();
		String expected = "1000!!";
		
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		Future<Integer> in = service.submit(() -> {
			Thread.sleep(1000);
			return 1000;
		});
		Future<String> future = MyStream.<Integer, String>map(in, t -> {return String.valueOf(t) + "!!";});
		System.out.println(future.get());
		service.shutdown();
		
		Thread.sleep(1500);
		sc.stop();
		sc.assertEquals(expected);	
	}

}
