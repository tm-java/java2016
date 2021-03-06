package jpl.ch17.ex05;

import static org.junit.Assert.*;

import java.lang.ref.WeakReference;

import org.junit.Test;

public class ResourceManagerTest {
	ResourceManager rm = new ResourceManager();
	
	@Test
	public void test() {
		Object key1 = new Object();
		Resource res1 = rm.getResource(key1);//keyを登録して新たなリソースをゲット
		res1.use(key1, null);//リソースを使用
		new WeakReference<Object>(key1);//弱参照に突っ込んで、gc対象にしやすくしてるつもり...
		key1 = null;//key1の参照をnull,参照不可能にしてるつもり...
		
		rm.shutdown();
		assertTrue(rm.refs.isEmpty());
	}
}
