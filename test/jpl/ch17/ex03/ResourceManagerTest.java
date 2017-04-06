package jpl.ch17.ex03;

import static org.junit.Assert.*;

import java.lang.ref.WeakReference;

import org.junit.Test;

public class ResourceManagerTest {
	ResourceManager rm = new ResourceManager();
	
	@Test
	public void test() {
		String key1 = "testCase1";
		Resource res1 = rm.getResource(key1);//keyを登録して新たなリソースをゲット
		res1.use(key1, null);//リソースを使用
		new WeakReference<String>(key1);//弱参照に突っ込んで、gc対象にしやすくしてるつもり...
		key1 = null;//key1の参照をnull,参照不可能にしてるつもり...
//		new WeakReference<Resource>(res1);
		
		while(!rm.refs.isEmpty()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.gc();//gcを促す
			long freeMem = Runtime.getRuntime().freeMemory();
		}
		rm.shutdown();
	}
}
